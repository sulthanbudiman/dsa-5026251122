package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customerData = new LinkedList<>();
        Queue<String[]> transactionsQueue = new LinkedList<>();
        Stack<String[]> failedTrans = new Stack<>();

        while (scan.hasNext()) {
            String name = scan.next();
            String type = scan.next();
            int amount = scan.nextInt();
            String amountString = amount + "";

            String[] transactionsData = { name, type, amountString };
            transactions.add(transactionsData);

            boolean exist = false;
            for (String[] customer : customerData) {

                if (customer[0].equals(name)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                String[] newCuStrings = { name, "0" };
                customerData.add(newCuStrings);
            }
        }
        for (String[] transData : transactions) {
            transactionsQueue.add(transData);
        }

        while (!transactionsQueue.isEmpty()) { 
            String[] fifoTrans = transactionsQueue.poll();
            for (String[] customer : customerData) {
                if (customer[0].equalsIgnoreCase(fifoTrans[0])) {
                    int amount = Integer.parseInt(fifoTrans[2]);
                    int custDataInt = Integer.parseInt(customer[1]);
                    
                    if (fifoTrans[1].equalsIgnoreCase("Deposit")) {
                        custDataInt += amount;
                        customer[1] = String.valueOf(custDataInt);
                    } else if (fifoTrans[1].equalsIgnoreCase("Withdraw")) {
                        if (custDataInt >= amount){
                            custDataInt -= amount;
                            customer[1] = String.valueOf(custDataInt);
                        } else{
                            failedTrans.push(fifoTrans);
                        }
                    }
                    break;
                }
            }

            
        }
        System.out.println("=== Final Balances ===");

        for (String[] customer : customerData) {
            System.out.println(customer[0] + " : " + customer[1]);
        }
        System.out.println("");
        System.out.println("=== Failed Transactions ===");
        while (!failedTrans.isEmpty()) { 
            String[] failed = failedTrans.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}
