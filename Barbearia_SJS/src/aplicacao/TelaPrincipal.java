package aplicacao;	

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenu mnBarbeiro;
	private JMenuItem itemCadastarProd;
	private JMenuItem itemListarBarbeiro;
	private JMenu mnServico;
	private JMenuItem itemCadastrarGarcom;
	private JMenuItem itemListarGarcom;
	private JMenuItem itemCalcularGorjeta;
	private JMenu mnCliente;
	private JMenuItem itemListarCliente;
	private JMenuItem itemSolicitarProd;
	private JLabel oii;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		Fachada.inicializar();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Barbearia SJS");
			

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro

				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "Volte Sempre!!");
			}
		});

		frmPrincipal.setBounds(100, 100, 485, 340);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		oii = new JLabel("oiii");
		oii.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/smoli.jpg")));
		oii.setBounds(0, -12, 469, 305);
		frmPrincipal.getContentPane().add(oii);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setBorderPainted(false);
		UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(Color.black, 0));
		UIManager.put("MenuItem.selectionBackground", new Color(153, 102, 51));
		UIManager.put("MenuItem.selectionForeground", Color.WHITE);
		UIManager.put("Menu.selectionBackground", new Color(153, 102, 51));
		UIManager.put("Menu.selectionForeground", Color.WHITE);
		UIManager.put("MenuBar.selectionBackground", new Color(153, 102, 51));
		UIManager.put("MenuBar.selectionForeground", Color.WHITE);
		
		frmPrincipal.setJMenuBar(menuBar);

		mnBarbeiro = new JMenu("   Barbeiro   ");
		mnBarbeiro.setContentAreaFilled(false);
		
		mnBarbeiro.setForeground(Color.WHITE);
		mnBarbeiro.setBorderPainted(false);
		menuBar.add(mnBarbeiro);
		

		itemListarBarbeiro = new JMenuItem("Tela Barbeiro");
		itemListarBarbeiro.setContentAreaFilled(false);
		itemListarBarbeiro.setBorder(null);
		itemListarBarbeiro.setBorderPainted(false);
		itemListarBarbeiro.setBackground(Color.BLACK);
		itemListarBarbeiro.setForeground(Color.WHITE);
		
		itemListarBarbeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaBarbeiro t = new TelaListaBarbeiro();
				t.setVisible(true);
			}
		});
		mnBarbeiro.add(itemListarBarbeiro);
		mnBarbeiro.setBorderPainted(false);
 
		mnCliente = new JMenu("       Cliente       ");
		mnCliente.setForeground(Color.WHITE);
		mnCliente.setBorderPainted(false);
		menuBar.add(mnCliente);

		itemListarCliente = new JMenuItem("TelaCliente");
		itemListarCliente.setBackground(Color.BLACK);
		itemListarCliente.setForeground(Color.WHITE);
		itemListarCliente.setContentAreaFilled(false);
		itemListarCliente.setBorder(null);
		itemListarCliente.setBorderPainted(false);
		itemListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaCliente te = new TelaListaCliente();
				te.setVisible(true);
			}
		});
		mnCliente.add(itemListarCliente);

		
		mnServico = new JMenu("   Tipo de Serviço   ");
		mnServico.setForeground(Color.WHITE);
		mnServico.setBorderPainted(false);
		menuBar.add(mnServico);	



		JMenuItem itemListarServico = new JMenuItem("Tela Tipo de Servico");
		itemListarServico.setForeground(Color.WHITE);
		itemListarServico.setBackground(Color.BLACK);
		itemListarServico.setContentAreaFilled(false);
		itemListarServico.setBorder(null);
		itemListarServico.setBorderPainted(false);
		itemListarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaTipo t = new TelaListaTipo();
				t.setVisible(true);
			}
		});
		mnServico.add(itemListarServico);
		
		JMenu mnConta = new JMenu("     Consultas     ");
		mnConta.setForeground(Color.WHITE);
		mnConta.setBorderPainted(false);
		menuBar.add(mnConta); 

		JMenuItem itemCriarConta = new JMenuItem("Fila de espera");
		itemCriarConta.setBackground(Color.BLACK);
		itemCriarConta.setForeground(Color.WHITE);
		itemCriarConta.setContentAreaFilled(false);
		itemCriarConta.setBorder(null);
		itemCriarConta.setBorderPainted(false);
		itemCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaDeEspera t = new TelaListaDeEspera();
				t.setVisible(true);
			}
		});
		mnConta.add(itemCriarConta);

		JMenuItem itemListarConta = new JMenuItem("Atendimento atual");
		itemListarConta.setForeground(Color.WHITE);
		itemListarConta.setBackground(Color.BLACK);
		itemListarConta.setContentAreaFilled(false);
		itemListarConta.setBorder(null);
		itemListarConta.setBorderPainted(false);
		itemListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtendimentoAtual t = new TelaAtendimentoAtual();
				t.setVisible(true);
			}
		});
		mnConta.add(itemListarConta);

		JMenuItem itemConsultarConta = new JMenuItem("Pagamentos");
		itemConsultarConta.setForeground(Color.WHITE);
		itemConsultarConta.setBackground(Color.BLACK);
		itemConsultarConta.setContentAreaFilled(false);
		itemConsultarConta.setBorder(null);
		itemConsultarConta.setBorderPainted(false);
		itemConsultarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPagamento t = new TelaPagamento();
				t.setVisible(true);
			}
		});
		mnConta.add(itemConsultarConta);
		
		
		
		JMenuItem itemPagarConta = new JMenuItem("Contas Fechadas");
		itemPagarConta.setForeground(Color.WHITE);
		itemPagarConta.setBackground(Color.BLACK);
		itemPagarConta.setContentAreaFilled(false);
		itemPagarConta.setBorder(null);
		itemPagarConta.setBorderPainted(false);
		itemPagarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaContasFechadas t = new TelaContasFechadas();
				t.setVisible(true);
			}
		});
		
		mnConta.add(itemPagarConta);
		
	}
}
