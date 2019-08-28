package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Noticeboard");
        frame.setPreferredSize(new Dimension(400, 200));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        frame.setLayout(layout);
        
        JTextField textTop = new JTextField();
        JLabel textBottom = new JLabel();
        JButton copyButton = new JButton("Copy!");
        
        AreaCopier copier = new AreaCopier(textTop, textBottom);
        copyButton.addActionListener(copier);
        
        container.add(textTop);
        container.add(copyButton);
        container.add(textBottom);
    }
}
