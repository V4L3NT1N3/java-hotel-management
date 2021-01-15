/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    private String booking_id;
    private int ic_number;
    private String customer_name;
    private String email;
    private int contact_number;
    private String room_number;
    private String checkIn;
    private String checkOut;
    private int[] bookedDaysInt;

    public String getBookingID() {
        return booking_id;
    }

    public void setBookingID(String booking_id) {
        this.booking_id = booking_id;
    }

    public int getICNumber() {
        return ic_number;
    }

    public void setICNumber(int ic_number) {
        this.ic_number = ic_number;
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

    public int getContactNumber() {
        return contact_number;
    }

    public void setContactNumber(int contact_number) {
        this.contact_number = contact_number;
    }

    public String getRoomNumber() {
        return room_number;
    }

    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int[] getbookedDaysInt() {
        return bookedDaysInt;
    }

    public void setBookedDaysInt(int[] bookedDaysInt) {
        this.bookedDaysInt = bookedDaysInt;
    }

    public void bookRoom() {

        // Create new booking file
        try {
            String currentDirectory = System.getProperty("user.dir");
            String filename = currentDirectory + "/bookinglist/" + booking_id + ".txt";
            File myObj = new File(filename);

            if (myObj.createNewFile()) {
                System.out.println("Booking file " + booking_id + " created");
            } else {
                System.out.println("File already exists.");
            }

            // Creating a new booking file and writing details to it 
            FileWriter bookingDetailsWriter = new FileWriter(filename);
            bookingDetailsWriter.write(booking_id + "\n" + ic_number + "\n" + customer_name + "\n" + email + "\n" + contact_number + "\n" + checkIn + "\n" + checkOut);
            bookingDetailsWriter.close();
            System.out.println("Successfully wrote to booking file.");

            // Adding Room Number to the specified booked days            
            for (int i : bookedDaysInt) {
                PrintWriter out = new PrintWriter(new FileWriter(currentDirectory + "/bookingdays/" + String.valueOf(i) + ".txt", true));
                out.append("\n" + room_number);
                out.close();
            }
            System.out.println("Successfully added to booking list.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            
        } catch (Exception e) {
            System.out.println("An error occurred. Try closing any open system files.");
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

    public static String[] enumerateBookings() {
        try {
            ArrayList<String> bookingDirectoryList = new ArrayList<String>();
            String currentDirectory = System.getProperty("user.dir");

            // Enumerate all files in directory
            File folder = new File(currentDirectory + "/bookinglist/");
            File[] listOfFiles = folder.listFiles();

            // Loop to add each file name to ArrayList
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    bookingDirectoryList.add(currentDirectory + "/bookinglist/" + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    // Ignore directories
                }
            }

            // Converting ArrayList to Array 
            String[] bookingDirectoryArray = new String[bookingDirectoryList.size()];
            bookingDirectoryArray = bookingDirectoryList.toArray(bookingDirectoryArray);

            return bookingDirectoryArray;

        } catch (Exception e) {
            System.out.println("Unable to open file");
        }

        return null;
    }

}
