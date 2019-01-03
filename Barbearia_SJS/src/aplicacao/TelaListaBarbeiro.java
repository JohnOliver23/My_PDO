package aplicacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import model.Barbeiro;
import model.Cliente;

public class TelaListaBarbeiro extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private DefaultListModel listModel = new DefaultListModel();

	
	public TelaListaBarbeiro() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				btnListar.doClick();
				
			}
		});
		setTitle("Listar Barbeiro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGarcons = new JLabel("Listagem de Barbeiros: ");
		lblGarcons.setBounds(10, 11, 264, 14);
		contentPane.add(lblGarcons);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500,80));
		JScrollPane pane = new JScrollPane(table);
		pane.setSize(500, 216);
		pane.setLocation(20, 34);
		contentPane.add(pane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					TelaCadastrarBarbeiro t = new TelaCadastrarBarbeiro();
					dispose();
					t.setVisible(true);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
				
			}
		);
		btnNewButton.setBounds(528, 35, 89, 23);
		contentPane.add(btnNewButton);
		

		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					Object[][] lista = Fachada.listarBarbeiros();
					String [] colunas = {"id","Nome","Data de Nascimento"};
					DefaultTableModel tableModel = new DefaultTableModel(lista,colunas);
					table.setModel(tableModel);
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int column = 0;
					int row = table.getSelectedRow();
					if(row == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um Barbeiro","Atenção",JOptionPane.WARNING_MESSAGE);
						
					}else {
						int id = (int) table.getModel().getValueAt(row, column);
						Fachada.deletarBarbeiro(id);
						JOptionPane.showMessageDialog(null, "Barbeiro excluido com Sucesso");
						Object[][] lista = Fachada.listarBarbeiros();
						String [] colunas = {"id","Nome","Data de Nascimento"};
						DefaultTableModel tableModel = new DefaultTableModel(lista,colunas);
						table.setModel(tableModel);
					}
					
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}				
			}
			
		});
		btnRemove.setBounds(528, 69, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int column = 0;
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um Barbeiro","Atenção",JOptionPane.WARNING_MESSAGE);
					
				}else {
				int id = (int) table.getModel().getValueAt(row, column);
				Barbeiro b = Fachada.localizarBarbeiroById(id);
					TelaAtualizaBarbeiro te = new TelaAtualizaBarbeiro(b);
					dispose();
					te.setVisible(true);
				}
			}
		});
		btnAtualiza.setBounds(528, 109, 89, 23);
		contentPane.add(btnAtualiza);
		

		

		

	}
}
