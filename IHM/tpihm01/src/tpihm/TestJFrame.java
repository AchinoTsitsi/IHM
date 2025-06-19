package tpihm;

import javax.swing.SwingUtilities;

public class TestJFrame {
	 public static void main(String[] args){
	SwingUtilities.invokeLater(new Runnable(){
	 public void run(){
	MyJFrame fenetre1 = new MyJFrame ();
	 fenetre1.setVisible(true);
	 /*Tp04 fenetre2 = new Tp04 ();
	 fenetre2.setVisible(true);
	 Buttons fenetre3 = new Buttons ();
	 fenetre3.setVisible(true);*/
		 //Tp05 fenetre4 = new Tp05 ();
		 //fenetre4.setVisible(true); 
	 }
	});
	 }
	}

