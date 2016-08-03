package PayRoll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author James
 */
public class TextFile {

    public String[] ingredientNames;
    public JTextField[] ingredientTextArray;

    public TextFile(String[] names, JTextField[] ingredientText) {
        ingredientNames = names;
        ingredientTextArray = ingredientText;
    }

    public TextFile() {
        createTempWorkFile();
    }

    public void createInventoryTextFile() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        JOptionPane.showMessageDialog(null, "Report sucessfully generated!");

        Writer output = null;
        File file = new File("C:\\Users\\James\\Documents\\NetBeansProjects"
                + "\\InventoryDataBase\\InventoryReports\\"
                + (dateFormat.format(date)) + ".txt");
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write("THIS REPORT SHOWS INFORMATION ON INVENTORY"
                    + System.lineSeparator());
            output.write("-----------------------------------------"
                    + System.lineSeparator());
            for (int i = 0; i < ingredientTextArray.length; i++) {
                output.write(ingredientNames[i] + ":"
                        + ingredientTextArray[i].getText()
                        + System.lineSeparator());
            }
            output.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "we");
        }

    }

    public void checkWorkerIn(String workerName) throws IOException {

        DateFormat hoursFormat = new SimpleDateFormat("HH-mm-ss");
        Date hour = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        FileWriter fw = new FileWriter("C:\\Users\\James\\Documents\\"
                + "NetBeansProjects"
                + "\\InventoryDataBase\\TempWorkerReports\\"
                + (dateFormat.format(date)) + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        {
            out.println(workerName);
            out.println((hoursFormat.format(hour)));
            out.close();
            JOptionPane.showMessageDialog(null, workerName + " "
                    + "you have successfully signed in!");
        }

    }

    public void checkWorkerOut(String workerName) throws FileNotFoundException {

        ArrayList<String> names = listOfWorkerNames();
        ArrayList<String> times = listOfTimeIn();
        boolean found = false;
        String time = "";

        Iterator<String> itr1 = names.iterator();
        Iterator<String> itr2 = times.iterator();
        while (itr1.hasNext() && itr2.hasNext() && !found) {
            time = itr2.next();
            if (itr1.next().equals(workerName)) {
                found = true;
                JOptionPane.showMessageDialog(null, workerName
                        + " was found!" + time);
            }

        }
        JOptionPane.showMessageDialog(null, calculateHours(time));
    }

    public void createTempWorkFile() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);

        Writer output = null;

        if (!(new File("C:\\Users\\James\\Documents\\NetBeansProjects"
                + "\\InventoryDataBase\\TempWorkerReports\\"
                + currentDate + ".txt").isFile())) {

            File file = new File("C:\\Users\\James\\Documents\\NetBeansProjects"
                    + "\\InventoryDataBase\\TempWorkerReports\\"
                    + currentDate + ".txt");
            try {
                output = new BufferedWriter(new FileWriter(file));
            } catch (IOException ex) {
                Logger.getLogger(TextFile.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<String> listOfWorkerNames() throws FileNotFoundException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);

        ArrayList<String> listOfNames = new ArrayList<>();

        for (Scanner sc = new Scanner(new File("C:\\Users\\James\\Documents"
                + "\\NetBeansProjects\\InventoryDataBase\\TempWorkerReports"
                + "\\" + currentDate + ".txt")); sc.hasNext();) {

            listOfNames.add(sc.nextLine());
            sc.nextLine();

        }

        return listOfNames;
    }

    public ArrayList<String> listOfTimeIn() throws FileNotFoundException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);

        ArrayList<String> listOfTimeIn = new ArrayList<>();

        for (Scanner sc = new Scanner(new File("C:\\Users\\James\\Documents"
                + "\\NetBeansProjects\\InventoryDataBase\\TempWorkerReports"
                + "\\" + currentDate + ".txt")); sc.hasNext();) {

            sc.nextLine();
            listOfTimeIn.add(sc.nextLine());

        }

        return listOfTimeIn;

    }

    public String calculateHours(String time) {
       
        DateFormat hoursFormat = new SimpleDateFormat("HH-mm-ss");
        Date hour = new Date();

        String currentTime = hoursFormat.format(hour);
        String timeWorked = "";
        int hoursWorked = 0;
        int minutesWorked = 0;
        int secondsWorked = 0;

        StringTokenizer st = new StringTokenizer(time, "-");
        int initalHour = Integer.parseInt(st.nextToken());
        int initalMinute = Integer.parseInt(st.nextToken());
        int initalSecond = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(currentTime, "-");
        int finalHour = Integer.parseInt(st1.nextToken());
        int finalMinute = Integer.parseInt(st1.nextToken());
        int finalSecond = Integer.parseInt(st1.nextToken());

        if (finalHour - initalHour < 0) {
            hoursWorked = finalHour - initalHour + 24;
        } else {
            hoursWorked = finalHour - initalHour;
        }

        if (finalMinute - initalMinute < 0) {
            minutesWorked = finalMinute - initalMinute + 60;
        } else {
            minutesWorked = finalMinute - initalMinute;
        }

        if (finalSecond - initalSecond < 0) {
            secondsWorked = finalSecond - initalSecond + 60;
        } else {
            secondsWorked = finalSecond - initalSecond;
        }

        return timeWorked = hoursWorked + "-" + minutesWorked + "-"
                + secondsWorked;
    }

}
