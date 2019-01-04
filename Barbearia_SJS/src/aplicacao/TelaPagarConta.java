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
import model.Conta;
import model.Pagamento;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class TelaPagarConta extends JFrame {

	private JPanel contentPane;
	private JLabel lblMesage;
	private JLabel lblMsg;
	private JTextField txt_idServico;

	public TelaPagarConta(int idconta) {
		setTitle("Por favor, crie sua conta!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 228);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMesage = new JLabel("Tipo: ");
		lblMesage.setBounds(10, 14, 51, 14);
		contentPane.add(lblMesage);
		
		
		
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 175, 351, 14);
		contentPane.add(lblMsg);
		
		JLabel lblIdConta = new JLabel("Id Conta");
		lblIdConta.setBounds(10, 45, 74, 14);
		contentPane.add(lblIdConta);
		
		JComboBox combo_tipo = new JComboBox();
		
		combo_tipo.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Cart\u00E3o"}));
		combo_tipo.setBounds(83, 8, 82, 20);
		contentPane.add(combo_tipo);
		
		txt_idServico = new JTextField();
		txt_idServico.setBounds(81, 39, 84, 20);
		contentPane.add(txt_idServico);
		txt_idServico.setText(Integer.toString(idconta));
		txt_idServico.setColumns(10);
		
		JLabel lblPercent = new JLabel("Percentual: ");
		lblPercent.setBounds(10, 73, 74, 14);
		contentPane.add(lblPercent);
		
		JComboBox combo_percent = new JComboBox();
		combo_percent.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		combo_percent.setBounds(83, 70, 41, 20);
		contentPane.add(combo_percent);
		
		JLabel lblCard = new JLabel("Cart\u00E3o:");
		lblCard.setBounds(193, 14, 46, 14);
		contentPane.add(lblCard);
		
		JComboBox combo_card = new JComboBox();
		combo_card.setModel(new DefaultComboBoxModel(new String[] {"Hyper Card", "Master", "Visa", "Elo"}));
		combo_card.setBounds(249, 11, 104, 20);
		combo_card.setEnabled(false);
		contentPane.add(combo_card);
		
		JLabel lblParcelas = new JLabel("Parcelas: ");
		lblParcelas.setBounds(193, 45, 82, 14);
		contentPane.add(lblParcelas);
		
		JComboBox combo_parcela = new JComboBox();
		combo_parcela.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		combo_parcela.setBounds(249, 42, 51, 20);
		combo_parcela.setEnabled(false);
		contentPane.add(combo_parcela);
		
		JButton lblConfirm = new JButton("Confirmar");
		lblConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String tipo = combo_tipo.getSelectedItem().toString();
					
					int percentual = Integer.parseInt(combo_percent.getSelectedItem().toString());
					
					String cartao = combo_card.getSelectedItem().toString();
					
					int parcela = Integer.parseInt(combo_parcela.getSelectedItem().toString());
					
					Pagamento p = Fachada.pagarConta(idconta, tipo, percentual, cartao, parcela);
					
					JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso");
					
					dispose();
					
					TelaContasFechadas t = new TelaContasFechadas();
					
					t.setVisible(true);
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage(),"title", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblConfirm.setBounds(112, 131, 127, 23);
		contentPane.add(lblConfirm);
		

		
		combo_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo = combo_tipo.getSelectedItem().toString();
				if(tipo.equalsIgnoreCase("Dinheiro")) {
					combo_card.setEnabled(false);
					combo_parcela.setEnabled(false);
					combo_percent.setEnabled(true);
					
				}else if(tipo.equalsIgnoreCase("Cartão")) {
					combo_card.setEnabled(true);
					combo_parcela.setEnabled(true);
					combo_percent.setEnabled(false);
				}
			}
		});
	}
}
