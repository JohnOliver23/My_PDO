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


public class TelaAtualizaBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton btnAtualiza;
	private JLabel lblMsg;
	private static Barbeiro b;  //esse atributo tem que ser estatico
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizaBarbeiro frame = new TelaAtualizaBarbeiro(b);
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
	public TelaAtualizaBarbeiro(Barbeiro b) {
		setTitle("Atualizando Barbeiros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtNome = new JTextField();
		txtNome.setBounds(98, 30, 120, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("Primeiro Nome");
		lblNome.setBounds(100, 11, 102, 14);
		contentPane.add(lblNome);
		
		JTextField txtSobreNome = new JTextField();
		txtSobreNome.setBounds(98, 76, 120, 20);
		contentPane.add(txtSobreNome);
		txtSobreNome.setColumns(10);

		JLabel lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(98, 61, 86, 14);
		contentPane.add(lblSobreNome);

		JLabel lblData = new JLabel("Data de Nascimento");
		lblData.setBounds(98, 106, 120, 14);
		contentPane.add(lblData);

		JTextField txtData = new JTextField();
		txtData.setBounds(98, 131, 120, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		txtNome.setText(b.getNome());
		txtSobreNome.setText(b.getSobrenome());
		txtData.setText(b.getDatanasc());

		btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String nome = txtNome.getText();
					String sobrenome = txtSobreNome.getText();
					Date data = formatter.parse(txtData.getText());
					Barbeiro ba = Fachada.AtualizaBarbeiro(b.getId(),nome, sobrenome, data);
					JOptionPane.showMessageDialog(null, "Barbeiro "+ba.getNome()+" atualizado com Sucesso");
					txtNome.setText("");
					txtSobreNome.setText("");
					txtData.setText("");
					txtNome.requestFocus();
					dispose();
					TelaListaBarbeiro t = new TelaListaBarbeiro();
					t.setVisible(true);
				}
				catch(Exception e1){
					lblMsg.setText(e1.getMessage());
					
				}
			}
		});
		btnAtualiza.setBounds(103, 177, 115, 23);
		contentPane.add(btnAtualiza);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(49, 211, 234, 14);
		contentPane.add(lblMsg);
	}
}
