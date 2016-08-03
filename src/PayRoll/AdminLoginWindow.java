/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


/**
 *
 * @author James
 */
public class AdminLoginWindow extends JFrame implements ActionListener {

    
    protected JButton logInButton;
    
    protected JLabel userNameLabel, passWordLabel;
    
    protected JTextField userNameField, passWordField;
    
    private String password = "12345";
    private String adminName = "admin";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public AdminLoginWindow() {
        super("Ingredients");
        createGUI();
    }



    private void createGUI() {
        
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        userNameLabel = new JLabel("Username:");
        window.add(userNameLabel);
        
        userNameField = new JTextField(10);
        window.add(userNameField);
        
        passWordLabel = new JLabel("Password:");
        window.add(passWordLabel);
        
        passWordField = new JTextField(10);
        window.add(passWordField);
        
        logInButton = new JButton("Sign in");
        window.add(logInButton);
        logInButton.addActionListener(this);
        
        setVisible(true);
    }
    
    
    @Override
     public void actionPerformed(ActionEvent ae){
       
        Object object = ae.getSource();
        
        if(object == logInButton) {
            
            if( verifyPassWord()) {
            
            AdminWindow AdminWindow = new AdminWindow();
            AdminWindow.setSize(550, 100);
                
            } else {
            try {
            errorSigningIn();
            } catch(WrongLoginException ve) {
                
                JOptionPane.showMessageDialog(null, "Incorrect information. "
                + "Please try again.");

            }
            }
                
        }

    }

    private boolean verifyPassWord() {
        String userName, userPassword;
        
        userName = userNameField.getText();
        userPassword = passWordField.getText();
        
        if((userName.equals(adminName)) && userPassword.equals(password)) {
            return true;
        } 
        
        return false;
        
    }

    private void errorSigningIn() throws WrongLoginException {
        
        throw new WrongLoginException();
    }
    
}
