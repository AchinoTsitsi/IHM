package tpihm;

import javax.swing.SwingUtilities;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestJDialogue {
	 public static void main(String[] args){
	SwingUtilities.invokeLater(new Runnable(){
	 public void run(){
	JDialog dialog = new JDialog();
	dialog.setSize(300, 200);
	dialog.setTitle("Première fenêtre");
	dialog.setVisible(true);
	dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	});
	}
}