/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Payment extends Booking {
String bookingID;

    public Payment(String booking_ID) {
        bookingID = booking_ID;
    }

    public boolean checkPaymentAmount(int payment_amt, int room_charges) {
        boolean isSufficient;

        // Check if payment made is more than or equal to room charges
        if (payment_amt >= room_charges) {
            isSufficient = true;
        } else {
            isSufficient = false;
        }

        return isSufficient;
    }

    public void moveFolders() throws IOException {

        // Get current user directory 
        String currentDirectory = System.getProperty("user.dir");

        // Concantenate the complete path with booking ID and detination folders
        String booking = currentDirectory + "/bookinglist/" + bookingID + ".txt";
        String folder = currentDirectory + "/paidbookings/" + bookingID + ".txt";

        // Move paid files to the paidbooking folder
        Path source = Paths.get(booking);
        Path destination = Paths.get(folder);

        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

}
