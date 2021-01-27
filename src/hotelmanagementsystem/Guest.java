/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Guest implements IOProcess {

    private String guestID;
    private String customer_name;
    private String email;
    private String contact_number;

    public String getGuestID() {
        return guestID;
    }

    public void setguestID(String guest_id) {
        this.guestID = guest_id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomerEmail() {
        return email;
    }

    public void setCustomerEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contact_number;
    }

    public void setContactNumber(String contact_number) {
        this.contact_number = contact_number;
    }

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
                    String path = currentDirectory + "/guestinformation/" + listOfFiles[i].getName();
                    guestDirectoryList.add(path.trim());
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

    public static boolean searchGuest(String IC) {

        // List all guest files
        String[] existing_guests = enumerateGuests();

        // Concantenating guest file path , because everything is in file paths , what a brilliant author
        String currentDirectory = System.getProperty("user.dir");
        String guest_path = currentDirectory + "/guestinformation/" + IC + ".txt";

        boolean record_exists = false;

        // Loop through all files to check for matchng records
        for (int i = 0; i < existing_guests.length; i++) {

            // This form of searching an array for certain values is good , I spent 4 days on it
            if (Arrays.asList(existing_guests).contains(guest_path)) {
                // If record found , flip boolean to true 
                record_exists = true;
            } else {
                record_exists = false;
            }

        }

        return record_exists;

    }

    @Override
    public void deleteRecord() {

        try {
            File selectedFile = new File(currentDirectory + "/guestinformation/" + guestID + ".txt");
            selectedFile.delete();
            System.out.println(guestID + " deleted");

        } catch (Exception e) {
            System.out.println("Unable to delete files");
        }
    }

    @Override
    public void EditRecord() {

        // Concntenate guest file path 
        String guestfilename = currentDirectory + "/guestinformation/" + guestID + ".txt";

        // Overwriting exisitng file contents
        FileWriter guestDetailsWriter;
        try {
            guestDetailsWriter = new FileWriter(guestfilename);
            guestDetailsWriter.write(guestID + "\n" + customer_name + "\n" + email + "\n" + contact_number);
            guestDetailsWriter.close();
            System.out.println("Successfully edited guest information.");
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
