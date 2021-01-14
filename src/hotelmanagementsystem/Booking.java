/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.Startup.checkBookingDirectory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Booking {

    private String booking_id;
    private int ic_number;
    private String customer_name;
    private String email;
    private int contact_number;
    private String room_number;
    private String checkIn;
    private String checkOut;

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

    public void bookRoom() {
        
        // Check for booking list folder existence
        checkBookingDirectory();

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

            // Writing details to file
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(booking_id + "\n" + ic_number + "\n" + customer_name + "\n" + email + "\n" + contact_number + "\n" + checkIn + "\n" + checkOut);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
