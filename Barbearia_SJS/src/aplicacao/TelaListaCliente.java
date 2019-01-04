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
import model.Conta;

public class TelaListaCliente extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private DefaultListModel listModel = new DefaultListModel();

	
	public TelaListaCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				btnListar.doClick();
				
			}
		});
		setTitle("Listar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGarcons = new JLabel("Listagem de Clientes: ");
		lblGarcons.setBounds(10, 11, 264, 14);
		contentPane.add(lblGarcons);
		
		JTable table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(500,80));
		JScrollPane pane = new JScrollPane(table);
		pane.setSize(680, 216);
		pane.setLocation(20, 34);
		contentPane.add(pane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					TelaCadastrarCliente t = new TelaCadastrarCliente();
					dispose();
					t.setVisible(true);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
				
			}
		);
		btnNewButton.setBounds(718, 33, 106, 23);
		contentPane.add(btnNewButton);
		

		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					Object[][] lista = Fachada.listarClientes();
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
						JOptionPane.showMessageDialog(null, "Selecione um Cliente","Atenção",JOptionPane.WARNING_MESSAGE);
						
					}else {
						int id = (int) table.getModel().getValueAt(row, column);
						Fachada.deletarCliente(id);
						JOptionPane.showMessageDialog(null, "Cliente excluido com Sucesso");
						Object[][] lista = Fachada.listarClientes();
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
		btnRemove.setBounds(718, 67, 106, 23);
		contentPane.add(btnRemove);
		
		JButton btnAtualiza = new JButton("Atualizar");
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int column = 0;
					int row = table.getSelectedRow();
					if(row == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um Cliente","Atenção",JOptionPane.WARNING_MESSAGE);
						
					}else {
					int id = (int) table.getModel().getValueAt(row, column);
					Cliente c = Fachada.localizarClienteById(id);
						TelaAtualizaCliente te = new TelaAtualizaCliente(c);
						dispose();
						te.setVisible(true);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnAtualiza.setBounds(718, 107, 106, 23);
		contentPane.add(btnAtualiza);
		
		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				int column = 0;
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um Cliente","Atenção",JOptionPane.WARNING_MESSAGE);
					
				}else {
				int id = (int) table.getModel().getValueAt(row, column);
				Cliente c = Fachada.localizarClienteById(id);
				Conta co = Fachada.cadastrarConta(c.getId());
				int fila = Fachada.totalFilaDeEspera();
				int atdatual = Fachada.totalAtendimentoAtual();
				if(fila ==1 && atdatual<2) {
					TelaCadastrarAtendimento te = new TelaCadastrarAtendimento(co.getId());
					te.setVisible(true);
				}else {
					
					JOptionPane.showMessageDialog(null, "cliente inserido na fila de espera","Ok",JOptionPane.INFORMATION_MESSAGE);
				}
				
					}
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCriarConta.setBounds(720, 151, 104, 23);
		contentPane.add(btnCriarConta);
		

		

		

	}
}
