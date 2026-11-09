package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int manyCards = scan.nextInt();
        int[] cardsNumbers = new int[manyCards];

        // transfer the cards numbers to the array cards numbers
        for (int i = 0; i < manyCards; i++) {
            int input = scan.nextInt();
            cardsNumbers[i] = input;
        }

        // transfer the target to the array target
        int target = scan.nextInt();
        int[] targetValue = new int[target];
        for (int i = 0; i < target; i++) {
            int manyTarget = scan.nextInt();
            targetValue[i] = manyTarget;
        }
        
        //selection sort
        for (int i = 0; i < 2; i++) {
            int posMin = i;
            for (int j = i; j < cardsNumbers.length; j++) {
                if (cardsNumbers[j] < cardsNumbers[posMin]) {
                    posMin = j;
                }
            }
            int tempVal = cardsNumbers[i];
            cardsNumbers[i] = cardsNumbers[posMin];
            cardsNumbers[posMin] = tempVal;
        }
        
        //showing the sorting result
        for (int a : cardsNumbers) {
            System.out.print(a + " ");
        }
        System.out.println();

        //linear search
        boolean found = true;
        int indexFound = 0;
        for (int i = 0; i < targetValue.length; i++) {
            for (int j = 0; j < cardsNumbers.length; j++) {
                if (targetValue[i] == cardsNumbers[j]) {
                    found = true;
                    indexFound = j;
                    break;
                } else {
                    found = false;
                }
            }
            if (found) {
                System.out.println(targetValue[i] + ": FOUND at index " + indexFound);
            } else {
                System.out.println(targetValue[i] + ": NOT FOUND");
            }
        }
    }
}
