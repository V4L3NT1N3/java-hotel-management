/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import static hotelmanagementsystem.Utilities.convertIntegers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utilities {

    // Convert int ArrayList to int Array
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    // Convert days to corresponding int values
    public static int[] daysToInt(int checkIn, int checkOut) {

        List<Integer> bookedDaysArray = new ArrayList<Integer>();

        if (checkIn >= checkOut) {
            // Add booked days to ArrayList if only one day
            bookedDaysArray.add(checkIn);
        } else {
            // Looping to fill in missing days in between a range 
            do {
                bookedDaysArray.add(checkIn);
                checkIn++;
            } while (checkIn <= checkOut);
        }

        // Converting int ArrayList to int Array
        int[] convertedArray = convertIntegers(bookedDaysArray);
        return convertedArray;
    }

    public static ArrayList<String> generateRoomNumbers(int max) {
        
        int i; 
        ArrayList<String> room_numbers = new ArrayList<String>();
        
        // Generating room numbers based on total number of rooms parameter
        for (i = 0; i < max; i++){
            String format_mask = String.format("%03d", i); 
            room_numbers.add("R" + format_mask);
        }      
        
        return room_numbers;
        
    }
}
