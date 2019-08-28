/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Marcell
 */
public class ClickListener implements ActionListener {
    private char operation;
    private JTextField input;
    private JTextField output;
    private JButton z;
    
    public ClickListener(char operation, JTextField input, JTextField output, JButton z) {
        this.operation = operation;
        this.input = input;
        this.output = output;
        this.z = z;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(operation) {
            case '+': try{output.setText((Integer.parseInt(output.getText()) + Integer.parseInt(input.getText())) + "");}catch(Exception ae){}; input.setText(""); z.setEnabled(true); break;
            case '-': try{output.setText((Integer.parseInt(output.getText()) - Integer.parseInt(input.getText())) + "");}catch(Exception ae){} input.setText(""); z.setEnabled(true); break;
            case 'Z': output.setText("0"); input.setText(""); z.setEnabled(false); break;
        }
    }
    
}
