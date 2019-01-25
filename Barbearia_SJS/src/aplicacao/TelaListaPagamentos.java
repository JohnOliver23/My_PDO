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

public class TelaListaPagamentos extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private DefaultListModel listModel = new DefaultListModel();

	
	public TelaListaPagamentos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				btnListar.doClick();
				
			}
		});
		setTitle("Lista Pagamentos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilaDeEspera = new JLabel("Contas Fechadas");
		lblFilaDeEspera.setBounds(20, 19, 264, 14);
		contentPane.add(lblFilaDeEspera);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500,80));
		JScrollPane pane = new JScrollPane(table);
		pane.setSize(777, 206);
		pane.setLocation(20, 44);
		contentPane.add(pane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int column = 0;
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma conta","Atenção",JOptionPane.WARNING_MESSAGE);
					
				}else {
					int idservico = (int) table.getModel().getValueAt(row, column);
					TelaPagarConta t = new TelaPagarConta(idservico);
					dispose();
					t.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(708, 7, 89, 23);
		contentPane.add(btnNewButton);


		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					Object[][] lista = Fachada.listarContasFechadas();
					String [] colunas = {"id conta","Cliente","Data fechamento","Hora Fechamento","Total"};
					DefaultTableModel tableModel = new DefaultTableModel(lista,colunas);
					table.setModel(tableModel);
					
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		

		

		

	}
}
