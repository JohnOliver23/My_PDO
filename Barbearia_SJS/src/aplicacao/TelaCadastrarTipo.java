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


public class TelaCadastrarTipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton btnCadastrar;
	private JLabel lblMsg;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarTipo frame = new TelaCadastrarTipo();
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
	public TelaCadastrarTipo() {
		setTitle("Cadastrando Barbeiros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(98, 30, 120, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(100, 11, 102, 14);
		contentPane.add(lblNome);
		
		JTextField txtpreco = new JTextField();
		txtpreco.setBounds(98, 76, 120, 20);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);

		JLabel lblpreco = new JLabel("Pre\u00E7o");
		lblpreco.setBounds(98, 61, 86, 14);
		contentPane.add(lblpreco);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String nome = txtNome.getText();
					double preco = Double.parseDouble(txtpreco.getText());
					Tipo t = Fachada.cadastrarTipos(nome, preco);
					JOptionPane.showMessageDialog(null, "Tipoo "+t.getNome()+" cadastrado com Sucesso");
					txtNome.setText("");
					txtpreco.setText("");
					txtNome.requestFocus();
					dispose();
					TelaListaTipo t1 = new TelaListaTipo();
					t1.setVisible(true);
				}
				catch(Exception e1){
					lblMsg.setText(e1.getMessage());
					
				}
			}
		});
		btnCadastrar.setBounds(103, 121, 115, 23);
		contentPane.add(btnCadastrar);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(39, 158, 254, 14);
		contentPane.add(lblMsg);
	}
}
