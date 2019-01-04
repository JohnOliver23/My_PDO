package aplicacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import model.Pagamento;

public class TelaPagamento extends JFrame {

	private JPanel contentPane;
	private JLabel lblPeriodo;

	public TelaPagamento() {
		setTitle("Por favor, informe os dados");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 228);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setBounds(65, 31, 58, 14);
		contentPane.add(lblPeriodo);
		
		JLabel lblBarbeiro = new JLabel("Barbeiro");
		lblBarbeiro.setBounds(65, 65, 58, 14);
		contentPane.add(lblBarbeiro);
		String array[] = Fachada.listarNomeBarbeiros();
		
		JComboBox combo_barbeiro = new JComboBox(array);
		combo_barbeiro.setBounds(133, 59, 141, 20);
		contentPane.add(combo_barbeiro);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setBounds(65, 100, 58, 14);
		contentPane.add(lblPagamento);
		
		JComboBox combo_pagamento = new JComboBox();
		combo_pagamento.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Dinheiro", "Cart\u00E3o"}));
		combo_pagamento.setBounds(133, 97, 141, 20);
		contentPane.add(combo_pagamento);
		
		JComboBox combo_periodo = new JComboBox();
		
		combo_periodo.setModel(new DefaultComboBoxModel(new String[] {"Hoje", "Janeiro 2019 ", "Fevereiro 2019", "Mar\u00E7o 2019"}));
		combo_periodo.setBounds(133, 28, 141, 20);
		contentPane.add(combo_periodo);
		
		JButton lblConfirm = new JButton("Listar");
		lblConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String periodo = combo_periodo.getSelectedItem().toString();
					String barbeiro = combo_barbeiro.getSelectedItem().toString();
					String pagamento = combo_pagamento.getSelectedItem().toString();
					
					JOptionPane.showMessageDialog(null, periodo+" "+barbeiro+" "+pagamento);
					
					
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage(),"title", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblConfirm.setBounds(133, 145, 86, 23);
		contentPane.add(lblConfirm);
		

		

		
		
	}
}
