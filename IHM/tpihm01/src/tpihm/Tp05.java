package tpihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Tp05 extends JFrame {
    private JLabel statusBar;
    private JSpinner spinner;
    private int count = 0;
    private JLabel activeLabel;
    
    public Tp05() {
        super();
        initJFrame();
    }

    private void initJFrame() {
        this.setTitle("TP 05");
        this.setSize(320, 240);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        statusBar = new JLabel("0");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        panel.add(statusBar);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ButtonListener1());
        addButton.addActionListener(new ButtonListener2());
        panel.add(addButton);

        SpinnerNumberModel numModel = new SpinnerNumberModel(0, -100, 100, 1);
        spinner = new JSpinner(numModel);
        panel.add(spinner);
        
        JCheckBox activeBox = new JCheckBox("Activer/Désactiver");
        activeLabel = new JLabel("activeBox Unchecked.");
        panel.add(activeLabel);
        
        activeBox.addItemListener(new ItemListener() {
        	@Override
        	 public void itemStateChanged(ItemEvent event) {
        	 if (activeBox.isSelected()) {
        	 activeLabel.setText("activeBox Checked.");
        	 } else {
        	 activeLabel.setText("activeBox Unchecked.");
        	 }
        	 }

        });
        panel.add(activeBox);
        
        activeLabel.addMouseListener(new MouseListener() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        	activeLabel.setBorder(BorderFactory.createMatteBorder(1, 1,
        	1, 1, Color.red));
        	}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	});

    }

    private class ButtonListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            statusBar.setText(Integer.toString(++count));
        }
    }

    private class ButtonListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer val = (Integer) spinner.getValue();
            spinner.setValue(++val);
        }
    }

  
}
