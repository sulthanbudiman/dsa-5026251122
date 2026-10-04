package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // ===== Problem 1 =====

        List<String> playlist = new ArrayList<>();
        Scanner scan = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        
        while (scan.hasNextLine()) {
            
            String line = scan.nextLine();
            String[] parts = line.split(" ", 2);
            
            if (parts[0].equals("ADD")) {
                String song = parts[1];
                playlist.add(song);

            } else if (parts[0].equals("INSERT")) {
                
                String[] data = parts[1].split(" ", 2);
                int index = Integer.parseInt(data[0]);
                String song = data[1];
                playlist.add(index, song);
                
            } else if (parts[0].equals("REMOVE")) {
                
                String song = parts[1];
                playlist.remove(song);
                
            }
        }
        
        scan.close();
        
        System.out.println("===== Problem 1 =====");
        // Display the total number of songs
        System.out.println("Total songs: " + playlist.size());

        // Display every song in the playlist
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        // ===== Problem 2 =====

        Set<String> participants = new LinkedHashSet<>();
        Scanner scan2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        int duplicateCount = 0;

        while (scan2.hasNextLine()) {

            String name = scan2.nextLine();

            if (participants.add(name)) {

                // Successfully added

            } else {
                duplicateCount++;
            }
        }

        scan2.close();
        System.err.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicateCount);


        // ===== Problem 3 =====
        
        Map<String, Integer> inventory = new LinkedHashMap<>();

        Scanner scan3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        int failedSales = 0;

        while (scan3.hasNextLine()) {

            String line = scan3.nextLine();

            String[] parts = line.split(" ");

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {
                    inventory.put(product,
                        inventory.get(product) + quantity);

                } else {
                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product,
                        inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }

            }
        }

        scan3.close();
        System.err.println();
        System.out.println("===== Problem 3 =====");
        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }

        System.out.println("Failed sales: " + failedSales);
    }
}
