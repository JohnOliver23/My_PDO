package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import model.Barbeiro;
import model.Tipo;


public class TelaCadastrarAtendimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdConta;
	private JLabel lblIdMesa;
	private JButton btnCadastrar;
	//private static int idConta;  //esse atributo tem que ser estatico

	public TelaCadastrarAtendimento(int idConta) {
		setTitle("Por favor, crie sua conta!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 299, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIdConta = new JTextField();
		txtIdConta.setBounds(77, 11, 101, 20);
		contentPane.add(txtIdConta);
		txtIdConta.setText(Integer.toString(idConta));
		txtIdConta.setColumns(10);

		lblIdMesa = new JLabel("Id Conta");
		lblIdMesa.setBounds(10, 14, 74, 14);
		contentPane.add(lblIdMesa);
		ArrayList<Barbeiro> barbeiros = new ArrayList<>();
		String array[] = Fachada.listarNomeBarbeiros();
		JComboBox comboBarbeiro = new JComboBox(array);
		//comboBox.setModel(new DefaultComboBoxModel<>(garcoms);
		comboBarbeiro.setBounds(77, 42, 195, 20);
		contentPane.add(comboBarbeiro);
		String array2[] = Fachada.listarNomeServicos();
		JComboBox comboServico = new JComboBox(array2);
		comboServico.setBounds(77, 73, 195, 20);
		contentPane.add(comboServico);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					int idConta = Integer.parseInt(txtIdConta.getText());
					String barbeiro = comboBarbeiro.getSelectedItem().toString();
					String tipo = comboServico.getSelectedItem().toString();
					Fachada.cadastrarServico(barbeiro, tipo, idConta);
					JOptionPane.showMessageDialog(null, "atendimento cadastrado com sucesso");
					dispose();
					
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
					

				}
			}
		});
		btnCadastrar.setBounds(87, 125, 115, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblBarbeiro = new JLabel("Barbeiro");
		lblBarbeiro.setBounds(10, 45, 74, 14);
		contentPane.add(lblBarbeiro);
		

		
		JLabel lblServico = new JLabel("Servi\u00E7o");
		lblServico.setBounds(10, 73, 74, 14);
		contentPane.add(lblServico);
	}
}
