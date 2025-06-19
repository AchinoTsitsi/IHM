package tpihm;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TP052 extends JFrame {

    private JLabel labelx;
    private JLabel labely;

    public TP052() {
        super();
        initJFrame();
    }

    private void initJFrame() {
        this.setTitle("TP 052");
        this.setSize(320, 240);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        labelx = new JLabel("X = ");
        labelx.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(labelx);

        labely = new JLabel("Y = ");
        labely.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(labely);

        // Add component listener to track movement
        addComponentListener(new MoveAdapter());

        // Make the frame visible
        this.setVisible(true);
    }

    private class MoveAdapter extends ComponentAdapter {
        @Override
        public void componentMoved(ComponentEvent e) {
            int x = e.getComponent().getX();
            int y = e.getComponent().getY();
            labelx.setText("X = " + x);
            labely.setText("Y = " + y);
        }
    }

    public static void main(String[] args) {
        new TP052();
    }
}
