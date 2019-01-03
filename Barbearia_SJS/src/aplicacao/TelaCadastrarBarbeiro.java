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


public class TelaCadastrarBarbeiro extends JFrame {

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
					TelaCadastrarBarbeiro frame = new TelaCadastrarBarbeiro();
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
	public TelaCadastrarBarbeiro() {
		setTitle("Cadastrando Barbeiros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 266);
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

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String nome = txtNome.getText();
					String sobrenome = txtSobreNome.getText();
					Date data = formatter.parse(txtData.getText());
					Barbeiro b = Fachada.cadastrarBarbeiro(nome, sobrenome, data);
					JOptionPane.showMessageDialog(null, "Barbeiro "+b.getNome()+" cadastrado com Sucesso");
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
		btnCadastrar.setBounds(103, 177, 115, 23);
		contentPane.add(btnCadastrar);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(41, 213, 254, 14);
		contentPane.add(lblMsg);
	}
}
