package lw01.unguided;
import java.util.Scanner;

import lw01.prelab.ColourPrint;
import lw01.prelab.MonoPrint;
import lw01.prelab.PrintJob;


public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        
        Rental[] rentalList = new Rental[records];
        int records = scan.nextInt();

        for (int i = 1; i <= rentalList.length; i++) {
            String type = scan.next();
            String id = scan.next();
            int days = scan.nextInt();

            if (type.equalsIgnoreCase("Laptop")) {
                rentalList[i] = new LaptopRental(id, days);
            } else if (type.equalsIgnoreCase("Projector")) {
                rentalList[i] = new ProjectorRental(id, days);
            }

        }
            
        
        for (int i = 1; i <= rentalList.length; i++) {
            System.out.println(sumarry);
        }

        
    }

    
}
