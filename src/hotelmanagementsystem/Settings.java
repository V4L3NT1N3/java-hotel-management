/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

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

        for (String s : bookingDirectoryList) {
            File myObj = new File(s);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
    }
}
