package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Are you?"));
        
        ButtonGroup buttonGroup1 = new ButtonGroup();
        
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        
        buttonGroup1.add(yes);
        buttonGroup1.add(no);
        
        container.add(yes);
        container.add(no);
        
        container.add(new JLabel("Why?"));
        
        ButtonGroup buttonGroup2 = new ButtonGroup();
        
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton cuzFun = new JRadioButton("Because it is fun!");
        
        buttonGroup2.add(noReason);
        buttonGroup2.add(cuzFun);
        
        container.add(noReason);
        container.add(cuzFun);
        
        container.add(new JButton("Done!"));
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
