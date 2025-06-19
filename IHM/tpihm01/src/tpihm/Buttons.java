package tpihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons extends JFrame implements ActionListener{
	public Buttons(){
	super();
	initJFrame();
	}
	private void initJFrame() {
		this.setTitle("TP 04");
		this.setSize(320,240);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel() ;
		this.setContentPane(panel) ;
		JButton button1 = new JButton("ok" ) ;
		panel.add(button1) ;
		JButton button2 = new JButton("Annuler" ) ;
		panel.add(button2) ;
		
		button1.addActionListener(this) ;
		button2.addActionListener(this) ;
		
		button1.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent event) {
			 System.out.println("Clic");
			 }
			});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand() ;
		if(action.equals("ok")){
		System.out.println("Vous avez cliqué sur OK");
		}
		else if(action.equals("Annuler")){
		System.out.println("Vous avez cliqué sur Annuler");
		}
        }
}
