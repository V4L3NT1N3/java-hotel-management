/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.io.IOException;

public class Startup {

    static void checkDaysDirectory() {

        String[] days = {"0", "1", "2", "3", "4", "5", "6"};
        int i;
        String currentDirectory = System.getProperty("user.dir");

        // Checking and creating booking days directory
        File directory = new File(currentDirectory + "/bookingdays/");
        try {
            if (directory.mkdir()) {
                System.out.println("Days directory created");
            } else {
                System.out.println("Days directory exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Checking and creating text files for every days in the week
        for (i = 0; i < days.length; i++) {
            try {
                String filename = currentDirectory + "/bookingdays/" + days[i] + ".txt";
                File newday = new File(filename);
                if (newday.createNewFile()) {
                    System.out.println("File created: " + newday.getName());
                } else {
                    // do nothing
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    static void checkBookingDirectory() {

        String currentDirectory = System.getProperty("user.dir");

        // Checking and creating booking list directory if it doesn't exist
        File folder = new File(currentDirectory + "/bookinglist/");
        try {
            if (folder.mkdir()) {
                System.out.println("Booking list directory created");
            } else {
                System.out.println("Booking list directory exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
