/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.Startup.checkBookingDirectory;
import static hotelmanagementsystem.Startup.checkDaysDirectory;
import java.io.File;
import java.util.ArrayList;

public class Settings {

    static void resetSystem(String directory) {

        // Get current user directory 
        String currentDirectory = System.getProperty("user.dir");
        ArrayList<String> bookingDirectoryList = new ArrayList<String>();

        // Enumerate all files in directory
        File folder = new File(currentDirectory + "/" + directory + "/");
        File[] listOfFiles = folder.listFiles();

        // Loop to add each file name to ArrayList
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                bookingDirectoryList.add(currentDirectory + "/" + directory + "/" + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                // Ignore directories
            }
        }

        // Delete all files in the directory
        try {
            for (String s : bookingDirectoryList) {
                File myObj = new File(s);
                myObj.delete();
            }
        } catch (Exception e) {
            System.out.println("Unable to delete files");
        }    

        System.out.println("System reset succesful");

    }
}
