package tpihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tp04 extends JFrame{
	public Tp04(){
	super();
	initJFrame();
}
	
private void initJFrame() {
	this.setTitle("TP 04");
	this.setSize(320,240);
	this.setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	/*JLabel label = new JLabel();
	label.setBounds(100, 100, 200, 100);
	label.setOpaque(true);
	label.setBackground(Color.cyan);
	this.getLayeredPane().add(label, new Integer(2));
	JLabel sublabel = new JLabel();
	sublabel.setBounds(80, 80, 180, 80);
	sublabel.setOpaque(true);
	sublabel.setBackground(Color.yellow);
	this.getLayeredPane().add(sublabel, new Integer(1));*/
	
	JPanel panel = new JPanel() ;
	this.setContentPane(panel) ;

	JLabel label = new JLabel("Social media") ;
	panel.add(label);
	
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Explore");

	DefaultMutableTreeNode twitter = new DefaultMutableTreeNode("Twitter");
	DefaultMutableTreeNode facebook = new DefaultMutableTreeNode("Facebook");
	facebook.add(new DefaultMutableTreeNode("Messenger"));
	DefaultMutableTreeNode instagram = new DefaultMutableTreeNode("Instagram");
	root.add(twitter);
	root.add(facebook);
	root.add(instagram);


	JTree tree = new JTree(root);
	panel.add(tree);
	
	panel.setLayout(new BorderLayout());
	
	JPanel panel1 = new JPanel();
	panel.add(panel1, BorderLayout.NORTH);
	panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.red));
	JPanel panel2 = new JPanel();
	panel.add(panel2, BorderLayout.SOUTH);
	panel2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.red));
	
	panel1.add(label) ;
	panel2.add(tree) ;
	
	label.setFont(new Font("Serif", Font.PLAIN, 14));

}
}


	
	

