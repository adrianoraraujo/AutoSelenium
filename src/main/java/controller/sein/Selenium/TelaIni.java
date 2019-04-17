package controller.sein.Selenium;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.Canvas;
import java.awt.Panel;

public class TelaIni extends JFrame 
{
	static TelaIni frame = new TelaIni();
	private JPanel contentPane;
	private Image image;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws AWTException, InterruptedException
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaIni()
	{
		setType(Type.POPUP);
		setTitle("Camaleão DIN - ENAC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 388);
		
		
	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenu mnPesquisa = new JMenu("Pesquisar");
		mnArquivo.add(mnPesquisa);
		
		final JMenuItem mntmDossie = new JMenuItem("Dossie");
		mntmDossie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mntmDossie.isEnabled()==true) {
					Dossie frame2 = new Dossie();
					try
					{
						Dossie.dossie();
					} catch (AWTException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					dispose();
				}
			}
		});
		mnPesquisa.add(mntmDossie);
		
		final JMenuItem mntmNJudicial = new JMenuItem("N\u00BA Judicial");
		mntmNJudicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(mntmNJudicial.isEnabled()==true) {
					Judicial frame2 = new Judicial();
					frame2.judicial();
					
					dispose();
				}
			}
		});
		mnPesquisa.add(mntmNJudicial);
		
		final JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(mntmSobre.isEnabled()) {
					JOptionPane.showMessageDialog(null, "Programa desenvolvido por desenvolvimento SEIN - ENAC  \r\nEste programa tem os objetivos de realizar pesquisas automáticas de dossiês e números judiciais.  \r\n"
							+"Para maiores informações clique em help \r\nVersão 1.2 beta" , "Camaleão DIN - ENAC (Sobre)", 1);
						}
			}
		});
		mnArquivo.add(mntmSobre);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Runtime.getRuntime().exec("help.pdf");
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmHelp);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArquivo.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Icon img = new ImageIcon("camaleao.gif");
		
contentPane.add(new JLabel(img), BorderLayout.CENTER);
		
	}
}
