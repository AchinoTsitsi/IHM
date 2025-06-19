package tpihm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ExerciceSlidershow extends JFrame {
	
	 private ImageIcon previ;
	 private ImageIcon nexti;
	 
	 private CardLayout cardlayout;
	 private JPanel cardpanel;
	 private ImageIcon slideimg1;
	 private ImageIcon slideimg2;
	 
	 private JPanel panelLogin;
	 private JTextField username;
	 private JPasswordField password;
	 private JLabel invalid;
	
	public ExerciceSlidershow () {
		super();
		initJFrame();
		buildLogInGUI();
	}
	
	private void initJFrame() {
		
		this.setSize(500, 400);
		this.setTitle("Exercice - Slidershow");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}
	
	private void buildLogInGUI() {
		panelLogin = new JPanel();
		
		username = new JTextField("Username");
		username.setBorder(BorderFactory.createTitledBorder("Username"));
		username.setColumns(20);
		panelLogin.add(username);
		
		password = new JPasswordField("Password");
		password.setBorder(BorderFactory.createTitledBorder("Password"));
		password.setColumns(20);
		panelLogin.add(password);
		
		invalid = new JLabel();
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] correctPassword = {'P', 'a', 's', 's', 'w', 'o', 'r', 'd'};
				
				if(username.getText().equals("Username") && Arrays.equals(correctPassword, password.getPassword()))
				{
					getContentPane().removeAll();
					initJFrame();
					buildSlideshowGUI();
				}
				else {
					invalid.setText("Invalid !");
					panelLogin.add(invalid);
					panelLogin.revalidate();
				}
			}
		});
		panelLogin.add(login);
		
		this.setContentPane(panelLogin);
	}
	
	private void buildSlideshowGUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.setContentPane(panel);
		
		cardpanel = new JPanel();
		
		cardlayout = new CardLayout();
		
		cardpanel.setLayout(cardlayout);
		panel.add(cardpanel, BorderLayout.CENTER);
		
		slideimg1 = new ImageIcon("C:/images/icon1.png");
        slideimg2 = new ImageIcon("C:/images/icon4.jpg");
        JLabel label1 = new JLabel(slideimg1);
        JLabel label2 = new JLabel(slideimg2);
        cardpanel.add(label1);
        cardpanel.add(label2);
		
		JPanel btnpanel = new JPanel();
		btnpanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.gray));
		
		BufferedImage imgprev = null;
        try {
            imgprev = ImageIO.read(new File("C:/images/icon3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage imgnext = null;
        try {
            imgnext = ImageIO.read(new File("C:/images/icon2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
               
        previ = new ImageIcon(imgprev.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        nexti = new ImageIcon(imgnext.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        
        JButton prevButton = new JButton(previ);
        prevButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 cardlayout.previous(cardpanel);
			}
        	
        });

        JButton nextButton = new JButton(nexti);
        nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 cardlayout.next(cardpanel);
			}
        	
        });
             
        btnpanel.add(nextButton);
        btnpanel.add(prevButton);
		panel.add(btnpanel, BorderLayout.SOUTH);
		pack();
	}

}