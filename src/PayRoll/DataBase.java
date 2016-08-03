/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author James
 */
public class DataBase extends JFrame implements ActionListener {

    public JButton updateIngredientsButton, workerSignInButton, adminLoginButton;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataBase frame = new DataBase();
        frame.setSize(1500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public DataBase() {
        super("Data Base");
        createGUI();
    }

    /**
     * method createGUI creates GUI objects and adds them to the frame
     */
    private void createGUI() {

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout(0, 0)); // 5 pixels hor and vert gap

        JPanel buttonPanel = new JPanel();  //contains buttons
        buttonPanel.setLayout(new GridLayout(5, 5, 0, 0));

        c.add(buttonPanel, BorderLayout.CENTER);

        workerSignInButton = new JButton("Check in / Check out");
        buttonPanel.add(workerSignInButton);
        workerSignInButton.addActionListener(this);

        updateIngredientsButton = new JButton("Inventory");
        buttonPanel.add(updateIngredientsButton);
        updateIngredientsButton.addActionListener(this);
        
        adminLoginButton = new JButton("Admin");
        buttonPanel.add(adminLoginButton);
        adminLoginButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object object = ae.getSource();
        if (object == updateIngredientsButton) {
           
        }
        if (object == workerSignInButton) {
            WorkerSignInWindow workerSignInWindow = new WorkerSignInWindow();
            workerSignInWindow.setSize(550, 100);
        }
        if (object == adminLoginButton) {
            AdminLoginWindow adminLoginWindow = new AdminLoginWindow();
            adminLoginWindow.setSize(550, 100);
        }

    }
}
