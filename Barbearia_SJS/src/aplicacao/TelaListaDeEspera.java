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

public class TelaListaDeEspera extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private DefaultListModel listModel = new DefaultListModel();

	
	public TelaListaDeEspera() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				btnListar.doClick();
				
			}
		});
		setTitle("Fila de Espera");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilaDeEspera = new JLabel("Fila de Espera: ");
		lblFilaDeEspera.setBounds(21, 11, 264, 14);
		contentPane.add(lblFilaDeEspera);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500,80));
		JScrollPane pane = new JScrollPane(table);
		pane.setSize(799, 216);
		pane.setLocation(20, 34);
		contentPane.add(pane, BorderLayout.CENTER);
		
		JButton btnCadastrar = new JButton("Inserir atendimento");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				int column = 0;
				int row = table.getSelectedRow();
				if(row == -1) {
				   JOptionPane.showMessageDialog(null, "Selecione um Cliente","Atenção",JOptionPane.WARNING_MESSAGE);
				}else {
				int idconta = (int) table.getModel().getValueAt(row, column);	
				int atdatual = Fachada.totalAtendimentoAtual();
				if(atdatual >=2) {
					JOptionPane.showMessageDialog(null, "Não há barbeiro disponível no momento");
				}else {
					TelaCadastrarAtendimento t = new TelaCadastrarAtendimento(idconta);
					t.setVisible(true);
					dispose();
				}
				}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(659, 7, 160, 23);
		contentPane.add(btnCadastrar);


		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					Object[][] lista = Fachada.listarFilaDeEspera();
					String [] colunas = {"id conta" ,"Nome","Data","Hora Chegada"};
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
