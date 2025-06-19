package tpihm;

import javax.swing.SwingUtilities;

public class CallExerciceSlidershowJFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ExerciceSlidershow frame = new ExerciceSlidershow();
				frame.setVisible(true); 
			}
		});

	}

}
