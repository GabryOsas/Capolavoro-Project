package me.gabryosas.util.game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class KahootGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Game game;
	private JButton btn_red;
	private JButton btn_blue;
	private JButton btn_yellow;
	private JButton btn_green;
	private JLabel lbl_question;
	private JProgressBar bar;
	private JLabel lbl_life;
	private JLabel lbl_question_index;
	private JLabel lbl_final;

	public static void main(String[] args) {
		KahootGUI gui = new KahootGUI();
	}
	
	public KahootGUI() {
		
		this.game = new Game();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\main-icon.jpg"));
		setTitle("Educazione Civica QUIZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bar = new JProgressBar();
		bar.setValue(100);
		bar.setBackground(new Color(37, 7, 107));
		bar.setOpaque(true);
		bar.setBorderPainted(false);
		bar.setForeground(new Color(37, 7, 107));
		bar.setFocusable(false);
		bar.setBounds(0, 297, 434, 14);
		contentPane.add(bar);
		
		lbl_final = new JLabel("DOMANDA FINALE");
		lbl_final.setIcon(null);
		lbl_final.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_final.setForeground(new Color(255, 0, 0));
		lbl_final.setFont(new Font("YOU", Font.BOLD, 20));
		lbl_final.setBounds(70, 0, 299, 30);
		lbl_final.setVisible(false);
		contentPane.add(lbl_final);
		
		lbl_question_index = new JLabel(String.valueOf(game.getDomande()));
		lbl_question_index.setIcon(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\question.png"));
		lbl_question_index.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_question_index.setForeground(Color.BLACK);
		lbl_question_index.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_question_index.setBounds(354, 0, 29, 30);
		contentPane.add(lbl_question_index);
		
		lbl_life = new JLabel(String.valueOf(game.getLife()));
		lbl_life.setIcon(new ImageIcon("C:\\Users\\Utente\\eclipse-workspace\\Capolavoro-Project\\src\\main\\resources\\vita.png"));
		lbl_life.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_life.setForeground(Color.BLACK);
		lbl_life.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_life.setBounds(395, 0, 29, 30);
		contentPane.add(lbl_life);
		
		lbl_question = new JLabel(game.getQuestion());
		lbl_question.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_question.setForeground(new Color(0, 0, 0));
		lbl_question.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_question.setBounds(89, 21, 255, 30);
		contentPane.add(lbl_question);
		
		btn_red = new JButton("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(0)) + "</body></html>");
		btn_red.setVerticalAlignment(SwingConstants.TOP);
		btn_red.setBackground(new Color(255, 0, 60));
		btn_red.setOpaque(true);
		btn_red.setBorderPainted(false);
		btn_red.setFocusable(false);
		btn_red.setBounds(89, 57, 100, 100);
		contentPane.add(btn_red);
		
		btn_blue = new JButton("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(1))+ "</body></html>");
		btn_blue.setVerticalAlignment(SwingConstants.TOP);
		btn_blue.setBackground(new Color(26, 100, 173));
		btn_blue.setOpaque(true);
		btn_blue.setBorderPainted(false);
		btn_blue.setFocusable(false);
		btn_blue.setBounds(244, 57, 100, 100);;
		contentPane.add(btn_blue);
		
		btn_yellow = new JButton("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(2)) + "</body></html>");
		btn_yellow.setVerticalAlignment(SwingConstants.TOP);
		btn_yellow.setBackground(new Color(245, 158, 0));
		btn_yellow.setOpaque(true);
		btn_yellow.setBorderPainted(false);
		btn_yellow.setFocusable(false);
		btn_yellow.setBounds(89, 177, 100, 100);;
		contentPane.add(btn_yellow);
		
		btn_green = new JButton("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(3)) + "</body></html>");
		btn_green.setVerticalAlignment(SwingConstants.TOP);
		btn_green.setBackground(new Color(0, 139, 58));
		btn_green.setOpaque(true);
		btn_green.setBorderPainted(false);
		btn_green.setFocusable(false);
		btn_green.setBounds(244, 177, 100, 100);
		contentPane.add(btn_green);
		
		btn_red.addActionListener(this);
		btn_blue.addActionListener(this);
		btn_yellow.addActionListener(this);
		btn_green.addActionListener(this);
		setVisible(true);

		SoundUtil.playSound(ObjectUtil.MUSIC_PATH.getString());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btn_red 
				&& game.getArgomento().getRisposte().check(game.getAnswers().get(0))) {
			reload(true);
			return;
		}
		if (e.getSource() == btn_blue 
				&& game.getArgomento().getRisposte().check(game.getAnswers().get(1))) {
			reload(true);
			return;
		}
		if (e.getSource() == btn_yellow 
				&& game.getArgomento().getRisposte().check(game.getAnswers().get(2))) {
			reload(true);
			return;
		}
		if (e.getSource() == btn_green 
				&& game.getArgomento().getRisposte().check(game.getAnswers().get(3))) {
			reload(true);
			return;
		}
		
		if (game.getLife() == 1) {
			dispose();
			System.out.println("Partita persa, ignorante");
		}
		
		game.removeLife();
		reload(false);
	}
	private void reload(boolean reload) {
		
		if (game.getArgomento().getDomande().getArray().size() == game.getIndex() + 1) {

			if (game.getLife() >= 1 && reload) {
				//vittoria
				System.out.println("Hai vinto!");
			}
			return;
		}
		
		if (reload) {
			game.next();
			game.addDomande();
			
			lbl_question.setText(game.getQuestion());
			btn_red.setText("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(0)) + "</body></html>");
			btn_blue.setText("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(1)) + "</body></html>");
			btn_yellow.setText("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(2)) + "</body></html>");
			btn_green.setText("<html><body>" + game.getArgomento().getRisposte().format(game.getAnswers().get(3)) + "</body></html>");
			
			if (game.getArgomento().getDomande().getArray().size() == game.getDomande() + 1) {
				SoundUtil.stopAllSounds();
				SoundUtil.playSound(ObjectUtil.FINAL_MUSIC_PATH.getString());
				lbl_final.setVisible(true);
			} else {	
				SoundUtil.stopAllSounds();
				SoundUtil.playSound(ObjectUtil.MUSIC_PATH.getString());		
			}
		}
		
		lbl_life.setText(String.valueOf(game.getLife()));
		lbl_question_index.setText(String.valueOf(game.getDomande()));

		
	}
}
