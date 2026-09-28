package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> bookStock = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        Queue<String[]> queueReq = new LinkedList<>();
        Stack<String[]> failedReq = new Stack<>();

        // Read file
        Scanner scan = new Scanner(
            Main.class.getResourceAsStream("borrowing.txt")
        );

        String[] storeKal = new String[2];
        storeKal[0] = "Kalkulus";
        storeKal[1] = "2";
        bookStock.add(storeKal);

        String[] storeFi = new String[2];
        storeFi[0] = "Fisika";
        storeFi[1] = "1";
        bookStock.add(storeFi);
        
        String[] storeStat = new String[2];
        storeStat[0] = "Statistika";
        storeStat[1] = "2";
        bookStock.add(storeStat);
        
        while(scan.hasNext()){
            String name = scan.next();
            String book = scan.next();

            String[] requests = {name, book};
            request.add(requests);

            boolean exist = false;
            for (String[] member : members) {

                if (member[0].equals(name)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                String[] newMember = { name, "0" };
                members.add(newMember);
            }

            int manyBook = Integer.parseInt(requests[1]);
            if (manyBook <= 2 ) {
                 += amount;
                requests[1] = String.valueOf(balance);

            } else if (type.equals("WITHDRAW")) {

                if (amount <= balance) {

                    balance -= amount;
                    customer[1] = String.valueOf(balance);

                } else {

                    // Failed transaction -> Stack
                    failedReq.push(requests);
                }
        }
        }
        scan.close();

        for (String[] requestData : request) {
            queueReq.add(requestData);
        }

        System.out.println("\n=== Successfully Processed Requests ===");

        for (String[] member : members) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===");

        for (String[] stock : bookStock) {
            System.out.println(stock[0] + " : " + stock[1]);
        }
        // Failed transactions
        System.out.println("\n=== Failed Requests ===");

        while (!failedReq.isEmpty()) {

            String[] transaction = failedReq.pop();

            System.out.println(
                transaction[0] + " " +
                transaction[1] + " " +
                transaction[2]
            );
        }
        
        
            
            
            

        
    

        // while (!members.isEmpty()) {
        //     String[] member = members.poll();

        //     String name = member[0];
        //     String bookCount = member[1];
            
        //     // Find member
        //     String[] memberisNot = null;

        //     for (String[] memberData : members) {
        //         if (memberData[0].equals(name)) {
        //             memberisNot = memberData;
        //             break;
        //         }
        //     }

        //     // Add new member if not found
        //     if (member == null) {
        //         member = new String[]{name, "0"};
        //         members.add(member);
        //     }
        // }

        
        // // LinkedList -> Queue
        // queue.addAll(transactions);

        // // Process transactions using FIFO
        // while (!queue.isEmpty()) {

        //     String[] transaction = queue.poll();

        //     String name = transaction[0];
        //     String type = transaction[1];
        //     int amount = Integer.parseInt(transaction[2]);

        //     // Find customer
        //     String[] customer = null;

        //     for (String[] data : customers) {
        //         if (data[0].equals(name)) {
        //             customer = data;
        //             break;
        //         }
        //     }

        //     // Add new customer if not found
        //     if (customer == null) {
        //         customer = new String[]{name, "0"};
        //         customers.add(customer);
        //     }

        //     int balance = Integer.parseInt(customer[1]);

        //     if (type.equals("DEPOSIT")) {

        //         balance += amount;
        //         customer[1] = String.valueOf(balance);

        //     } else if (type.equals("WITHDRAW")) {

        //         if (amount <= balance) {

        //             balance -= amount;
        //             customer[1] = String.valueOf(balance);

        //         } else {

        //             // Failed transaction -> Stack
        //             failed.push(transaction);
        //         }
        //     }
        // }

        // // Final balances
        // System.out.println("\n=== Final Balances ===");

        // for (String[] customer : customers) {
        //     System.out.println(customer[0] + " : " + customer[1]);
        // }

        // // Failed transactions
        // System.out.println("\n=== Failed Transactions ===");

        // while (!failed.isEmpty()) {

        //     String[] transaction = failed.pop();

        //     System.out.println(
        //         transaction[0] + " " +
        //         transaction[1] + " " +
        //         transaction[2]
        //     );
        // }
    }
}
