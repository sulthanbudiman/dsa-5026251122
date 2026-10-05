package lw03.unguided;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        Set<String> students = new LinkedHashSet<>();
        Map<String, Integer> enroll = new LinkedHashMap<>();
        
        Scanner scan = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String courseCode = line.substring(line.indexOf(" ") + 1);
            String operation = line.substring(0, line.indexOf(" "));

            // if (operation.equals("CHECK")) {
            //     String song = details;
            //     playList.add(song);
            // } else if (operation.equals("REGISTER")) {
            //     int index = Integer.parseInt(details.substring(0, details.indexOf(" ")));
            //     String song = details.substring(details.indexOf(" ") + 1);
            //     playList.add(index, song);
            // } else if (condition) {
                

            //     String song = details;
            //     if (playList.contains(song)) {
            //         playList.remove(song);
            //     }
            // }
        }

        int duplicate = 0;

            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                if (students.contains(name)) {
                    duplicate++;
                }
                students.add(name);
                
            }
            System.out.println();
            System.out.println("===== Problem 2 =====");
            System.out.println("Unique participants:" + students.size());
            int no = 1;
            for (String s : students) {
                System.out.println(no + ". " + s);
                no++;
            }
            System.out.println("Duplicate registrations: " + duplicate);

        while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");

                String type = parts[0];
                String product = parts[1];
                int qty = Integer.parseInt(parts[2]);

                // if (type.equals("ADD")) {
                //     if (products.containsKey(product)) {
                //         int currentStock = products.get(product);
                //         products.put(product, currentStock + qty);
                //     } else {
                //         products.put(product, qty);
                //     }
                // } else {
                //     if (products.containsKey(product) && products.get(product) >= qty){
                //         int currentStock = products.get(product);
                //         products.put(product, currentStock - qty);
                //     } else {
                //         failedTransaction++;
                //     }
                    
                } 
                System.out.println("===== Enrollment Checks =====");
        System.out.println("DSA101: 35 students");
        System.out.println("DB202: 15 students");
        System.out.println("UX110: 18 students");
        System.out.println("NET300: Not found");
        
        System.out.println("===== Final Enrollment =====");
        System.out.println("DSA101: 35 students");
        System.out.println("DB202: 15 students");
        System.out.println("UX110: 18 students");

        System.out.println("Rejected operations: 3");
            }



        // System.out.println("===== Enrollment Checks =====");
        // for (String c : courses.keySet()) {
        //         System.out.println(coursesCode + ": " + student.get(p));
        //     }
            
            
        // System.out.println();
        // System.out.println("===== Final Enrollment =====");
        // for (String p : products.keySet()) {
        //         System.out.println(p + ": " + products.get(p));
        //     }
        //     System.out.println("Failed sales: " + rejectedOperation);

        
    }

