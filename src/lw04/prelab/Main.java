package lw04.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int manyBranches = scan.nextInt();
        int[] branchesValue = new int[manyBranches];

        // transfer the input to the array input
        for (int i = 0; i < manyBranches; i++) {
            int input = scan.nextInt();
            branchesValue[i] = input;
        }

        // transfer the target to the array target
        int target = scan.nextInt();
        int[] targetValue = new int[target];
        for (int i = 0; i < target; i++) {
            int manyTarget = scan.nextInt();
            targetValue[i] = manyTarget;
        }

        // insertion sort
        for (int i = 1; i <= 3; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int oldVal = branchesValue[j];
                int newVal = branchesValue[j + 1];

                if (newVal > oldVal) {
                    branchesValue[j + 1] = oldVal;
                    branchesValue[j] = newVal;
                }
            }
        }

        for (int a : branchesValue) {
            System.out.print(a + " ");
        }
        System.out.println();
        // linear search
        boolean found = true;
        int indexFound = 0;
        for (int i = 0; i < targetValue.length; i++) {
            for (int j = 0; j < branchesValue.length; j++) {
                if (targetValue[i] == branchesValue[j]) {
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
