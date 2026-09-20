package lw01.prelab;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        ArrayList<PrintJob> jobs = new ArrayList<>();
        

        while (scan.hasNext()){
            String type = scan.next();
            String id = scan.next();
            int pages = scan.nextInt();

            if (type.equalsIgnoreCase("Mono")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equalsIgnoreCase("Colour")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }
        

        // for (int i = 0; i <= jobs.size(); i++) {
        //     System.out.println(jobs.summary());
        // }

        for (PrintJob thisjob : jobs) {
            System.out.println(thisjob.summary());
        }
    }

    
}
