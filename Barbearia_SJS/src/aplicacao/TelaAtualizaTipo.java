package aplicacao;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import model.Barbeiro;
import model.Tipo;


public class TelaAtualizaTipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton btnAtualiza;
	private JLabel lblMsg;
	private static Tipo t;  //esse atributo tem que ser estatico
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizaTipo frame = new TelaAtualizaTipo(t);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAtualizaTipo(Tipo t) {
		setTitle("Atualizando Barbeiros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtNome = new JTextField();
		txtNome.setBounds(98, 30, 120, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("Tipo de Serviço");
		lblNome.setBounds(100, 11, 102, 14);
		contentPane.add(lblNome);
		
		JTextField txtpreco = new JTextField();
		txtpreco.setBounds(98, 76, 120, 20);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);

		JLabel preco = new JLabel("Pre\u00E7o");
		preco.setBounds(98, 61, 86, 14);
		contentPane.add(preco);
		txtNome.setText(t.getNome());
		txtpreco.setText(Double.toString(t.getPreco()));

		btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = txtNome.getText();
					double preco = Double.parseDouble(txtpreco.getText());
					Tipo ti = Fachada.AtualizaTipo(t.getId(),nome, preco);
					JOptionPane.showMessageDialog(null, "Tipo de serviço "+ti.getNome()+" atualizado com Sucesso");
					txtNome.setText("");
					txtpreco.setText("");
					txtNome.requestFocus();
					dispose();
					TelaListaTipo t = new TelaListaTipo();
					t.setVisible(true);
				}
				catch(Exception e1){
					lblMsg.setText(e1.getMessage());
					
				}
			}
		});
		btnAtualiza.setBounds(98, 114, 115, 23);
		contentPane.add(btnAtualiza);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(48, 148, 234, 14);
		contentPane.add(lblMsg);
	}
}
