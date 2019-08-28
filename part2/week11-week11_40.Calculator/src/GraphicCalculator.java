import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(500, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        frame.setLayout(layout);
        
        JTextField output = new JTextField("0");
        JTextField input = new JTextField();
        
        output.setEnabled(false);
        
        container.add(output);
        container.add(input);
        container.add(bottomPanel(input, output));
    }
    
    private JPanel bottomPanel(JTextField input, JTextField output) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton z = new JButton("Z");
        
        plus.addActionListener(new ClickListener('+', input, output, z));
        minus.addActionListener(new ClickListener('-', input, output, z));
        z.addActionListener(new ClickListener('Z', input, output, z));
        
        z.setEnabled(false);
        
        panel.add(plus);
        panel.add(minus);
        panel.add(z);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
