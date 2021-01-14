/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Startup {

    static void checkDaysDirectory() {

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
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

    public static String[] readBooking(String file) {
        try {
            String[] booking_details = new String[7];

            // Read booking details and store them to an array
            Scanner scanner = new Scanner(new File(file));
            for (int i = 0; i < 7; i++) {
                booking_details[i] = scanner.next();
            }

            return booking_details;

        } catch (Exception e) {
            System.out.println("Failed to read file");
        }
        
        return null;
    }

    static void enumerateBookings() {
        String currentDirectory = System.getProperty("user.dir");

        // Enumerate all files in directory
        File folder = new File(currentDirectory + "/bookinglist/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                // Ignore directories
            }
        }
    }
}
