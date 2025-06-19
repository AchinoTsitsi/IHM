package tpihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyJFrame extends JFrame{
public MyJFrame(){
	super();
	initJFrame();
}
private void initJFrame(){
	
	
	// TP WINDOW AND FRAME
	this.setTitle("Entertainement Tonight");
	this.setSize(320,240);
	this.setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JMenuBar menuBar = new JMenuBar();
	JMenu streaming = new JMenu("Streaming");
	menuBar.add(streaming) ;
	JMenuItem tv = new JMenu("TV Show");
	streaming.add(tv) ;
	streaming.addSeparator() ;
	JMenuItem movies = new JMenu("Movies");
	streaming.add(movies) ;
	streaming.addSeparator() ;
	JMenuItem manga = new JMenu("Manga");
	streaming.add(manga) ;
	JMenu games = new JMenu("Games");
	menuBar.add(games) ;
	JMenuItem street = new JMenu("Street Fighter");
	games.add(street) ;
	this.setJMenuBar(menuBar) ;
	
	/*JMenuBar menuBar = new JMenuBar();
	JMenu compte = new JMenu("Mon compte");
	menuBar.add(compte);
	JMenuItem param = new JMenuItem("Parametres");
	compte.add(param);
	compte.addSeparator();
	JMenuItem exit = new JMenuItem("Se deconnecter");
	compte.add(exit);
	this.setJMenuBar(menuBar);*/
	
	
	// TP LAYOUT
	this.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
	this.setUndecorated(true);
	this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	
	//this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
	//this.getContentPane().setLayout(new GridLayout(2,3,5,5));
	//JLabel label1 = new JLabel("Label 1");
	//this.getContentPane().add(label1);
	
	//JLabel label2 = new JLabel("Label 2");
	//this.getContentPane().add(label2);
	
	//this.getContentPane().setLayout(new BorderLayout());
	
	//JLabel label3 = new JLabel("Label 3");
	//this.getContentPane().add(label3,BorderLayout.NORTH);

	//JLabel label4 = new JLabel("Label 4");
	//this.getContentPane().add(label4,BorderLayout.SOUTH);
	
	/*JLabel label5 = new JLabel("Label 5");
	label5.setHorizontalAlignment(SwingConstants.CENTER);
	label5.setPreferredSize(new Dimension(90,40));
	label5.setBackground(Color.cyan);
	label5.setOpaque(true);
	label5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
	this.getContentPane().add(label5);
	
	JLabel label6 = new JLabel("Label 6");
	label6.setHorizontalAlignment(SwingConstants.CENTER);
	label6.setPreferredSize(new Dimension(90,40));
	label6.setBackground(Color.cyan);
	label6.setOpaque(true);
	label6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
	this.getContentPane().add(label6);
	
	JLabel label7 = new JLabel("Label 7");
	label7.setHorizontalAlignment(SwingConstants.CENTER);
	label7.setPreferredSize(new Dimension(90,40));
	label7.setBackground(Color.cyan);
	label7.setOpaque(true);
	label7.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
	this.getContentPane().add(label7);
	
	JLabel label8 = new JLabel("Label 8");
	label8.setHorizontalAlignment(SwingConstants.CENTER);
	label8.setPreferredSize(new Dimension(90,40));
	label8.setBackground(Color.cyan);
	label8.setOpaque(true);
	label8.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
	this.getContentPane().add(label8);*/
	
	/*BoxLayout boxLayout = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
	this.getContentPane().setLayout(boxLayout);
	
	this.getContentPane().add(label1);
	this.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
	this.getContentPane().add(label2);*/
	
	JTextField textField = new JTextField("Enter your email ...");
	textField.setColumns(20);
	textField.setBorder(BorderFactory.createTitledBorder("Email"));
	textField.setCaretColor(Color.red);
	textField.setHorizontalAlignment(JTextField.CENTER);
	this.getContentPane().add(textField);
	
	JPasswordField passwordField = new JPasswordField("Enter your password ...");
	passwordField.setColumns(20);
	passwordField.setToolTipText("Enter your pasword");
	passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
	this.getContentPane().add(passwordField);
}
}
