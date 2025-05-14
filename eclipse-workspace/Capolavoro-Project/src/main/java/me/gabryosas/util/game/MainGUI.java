package me.gabryosas.util.game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public MainGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\main-icon.jpg"));
		setTitle("Educazione Civica QUIZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("EDUCAZIONE CIVICA QUIZ");
		lbl_title.setForeground(new Color(0, 128, 192));
		lbl_title.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_title.setBounds(97, 21, 255, 30);
		contentPane.add(lbl_title);
		
		JLabel lbl_subtitle = new JLabel("Sviluppato da Gabriele Muià");
		lbl_subtitle.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_subtitle.setBounds(107, 47, 199, 14);
		contentPane.add(lbl_subtitle);
		
		JButton btn_play = new JButton("GIOCA");
		btn_play.setIcon(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\play-icon.png"));
		btn_play.setFont(new Font("Arial", Font.BOLD, 11));
		
		
		btn_play.setBounds(117, 110, 189, 23);
		contentPane.add(btn_play);
		
		JButton btn_quit = new JButton("CHIUDI");
		btn_quit.setIcon(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\quit-icon.png"));
		btn_quit.setFont(new Font("Arial", Font.BOLD, 11));
		
		btn_quit.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  dispose();
			 } 
		});
		
		btn_quit.setForeground(new Color(0, 0, 0));
		btn_quit.setBounds(117, 140, 189, 23);
		contentPane.add(btn_quit);
		
	}
}
