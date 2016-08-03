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
public class WorkerSignInWindow extends JFrame implements ActionListener {

   
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JButton checkInButton, checkOutButton;
    private TextFile tempWorkLog = new TextFile(); 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WorkerSignInWindow frame = new WorkerSignInWindow();
        frame.setSize(550, 100);

    }

    public WorkerSignInWindow() {
        super("Sign in");
        createGUI();

    }

    private void createGUI()  {

        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        nameLabel = new JLabel("Name");
        window.add(nameLabel);
        
        nameTextField = new JTextField(10);
        window.add(nameTextField);
        
        checkInButton = new JButton("Check in");
        window.add(checkInButton);
        checkInButton.addActionListener(this);
        
        checkOutButton = new JButton("Check out");
        window.add(checkOutButton);
        checkOutButton.addActionListener(this);
        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        Object object = ae.getSource();
        if(object == checkInButton) {
            checkIn();
        }
        if(object == checkOutButton) {
            checkOut();
        }

    }

    public void checkIn() {
        String name = nameTextField.getText();
        try {
        tempWorkLog.checkWorkerIn(name);
       
    }   catch (IOException ex) {
            Logger.getLogger(WorkerSignInWindow.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void checkOut() {
        String name = nameTextField.getText();
        try {
            tempWorkLog.checkWorkerOut(name);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkerSignInWindow.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
