/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




/**
 *
 * @author James
 */
public class AddUserWindow extends JFrame implements ActionListener {

    protected double hourlyPay;
    protected String email, fullName;
    protected int bankNumber;
    
    protected JButton submitInformation;
    protected JTextField hourlyPayField, emailField, fullNameField, 
            bankNumberField;;
    
    
    
    public static void main(String[] args) {
        WorkerSignInWindow frame = new WorkerSignInWindow();
        frame.setSize(550, 100);
    }
    
    public AddUserWindow() {
        super("AddUserWindow");
        createGUI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    private void createGUI() {
        
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        
        setVisible(true);
        
        
        
    }
    
}
