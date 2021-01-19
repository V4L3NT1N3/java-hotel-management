/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Guest {
    
      public static String[] enumerateGuests() {
        try {
            ArrayList<String> guestDirectoryList = new ArrayList<String>();
            String currentDirectory = System.getProperty("user.dir");

            // Enumerate all files in directory
            File folder = new File(currentDirectory + "/guestinformation/");
            File[] listOfFiles = folder.listFiles();

            // Loop to add each file name to ArrayList
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    guestDirectoryList.add(currentDirectory + "/guestinformation/" + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    // Ignore directories
                }
            }

            // Converting ArrayList to Array 
            String[] guestDirectoryArray = new String[guestDirectoryList.size()];
            guestDirectoryArray = guestDirectoryList.toArray(guestDirectoryArray);

            return guestDirectoryArray;

        } catch (Exception e) {
            System.out.println("Unable to open file");
        }

        return null;
    }
}
