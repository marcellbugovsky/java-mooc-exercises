/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Marcell
 */
public class ClickListener implements ActionListener {
    private Calculator calculator;
    private JLabel label;
    
    public ClickListener(Calculator calculator, JLabel label) {
        this.calculator = calculator;
        this.label = label;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.increase();
        label.setText(calculator.giveValue() + "");
    }
    
}
