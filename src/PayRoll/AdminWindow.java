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
public class AdminWindow extends JFrame implements ActionListener {
    
    protected JButton addUserButton, editUsersButton;
    
    
     public static void main(String[] args) {
        WorkerSignInWindow frame = new WorkerSignInWindow();
        frame.setSize(550, 100);

    }
     
       public AdminWindow() {
        super("Admin");
        createGUI();

    }

    private void createGUI()  {

        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        
         addUserButton = new JButton("Add User");
        window.add(addUserButton);
        addUserButton.addActionListener(this);
        
         editUsersButton = new JButton("Edit Users");
        window.add(editUsersButton);
        editUsersButton.addActionListener(this);
        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        Object object = ae.getSource();
        if(object == addUserButton) {
            AddUserWindow addUserWindow = new AddUserWindow();
            addUserWindow.setSize(550, 700);
        }
       

    }

    
    

}
