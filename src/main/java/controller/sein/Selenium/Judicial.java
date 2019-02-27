package controller.sein.Selenium;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.AWTException;
import java.awt.Button;

public class Judicial
{
	String endereco,endereco2;
	String user, password;
	private JFrame frmPesquisaNJudicial;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void judicial()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Judicial window = new Judicial();
					window.frmPesquisaNJudicial.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Judicial()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmPesquisaNJudicial = new JFrame();
		frmPesquisaNJudicial.setTitle("Pesquisa N\u00BA Judicial DIN - ENAC");
		frmPesquisaNJudicial.getContentPane().setBackground(SystemColor.menu);
		frmPesquisaNJudicial.setBounds(100, 100, 802, 257);
		frmPesquisaNJudicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JButton btnNewButton = new JButton("Inserir arquivo com lista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Methods met = new Methods();
				if(btnNewButton.isEnabled()==true) {
					
				
				endereco = met.openArquivo();
				textField.setText(endereco);
				textField.show(true);}
			}
		});
		
		final JButton btnNewButton_1 = new JButton("Inserir destino da pesquisa");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Methods met = new Methods();
				if(btnNewButton_1.isEnabled()==true) {
					
				
				endereco2 = met.openArquivo();
				textField_1.setText(endereco2);
				textField_1.show(true);}
			}
		});
		
		final JButton btnNewButton_2 = new JButton("Iniciar Pesquisa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(btnNewButton_2.isEnabled()) {
					
					try
					{
						user=textField_2.getText();
						password= new String (passwordField.getPassword());
						System.out.println(endereco+ " "+endereco2+" "+password+" "+user);
						AutoSapiens.executar(user, password, endereco, endereco2 );
						
					} catch (AWTException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					System.out.println("OKKK");
				}
				
			}
		});
		
		JRadioButton rdbtnVerAndamento = new JRadioButton("Ocultar tela de pesquisa");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		passwordField = new JPasswordField();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				TelaIni tel = new TelaIni();
				tel.setVisible(true);
				frmPesquisaNJudicial.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmPesquisaNJudicial.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addComponent(lblLogin)
							.addComponent(lblSenha)
							.addComponent(passwordField))
						.addComponent(rdbtnVerAndamento))
					.addGap(120)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_1, Alignment.LEADING)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))))
							.addGap(9)
							.addComponent(btnVoltar))
						.addComponent(btnNewButton))
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLogin)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(rdbtnVerAndamento)
						.addComponent(btnVoltar))
					.addGap(164))
		);
		frmPesquisaNJudicial.getContentPane().setLayout(groupLayout);
	}
}
