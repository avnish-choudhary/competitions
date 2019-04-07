package com.techgig;

import java.util.Scanner;

public class NeighboursParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int[] ticket = new int[n];

            for (int i = 0; i < n; i++) {
                ticket[i] = scanner.nextInt();

            }
            int oddMax = 0;
            int max = ticket[0];
            String oddMaxPath = "";
            for (int i = 0; i < n; i++) {

                if (ticket[i] > max) {
                    max = ticket[i];
                }

            }
            for (int i = n - 1; i >= 0; i -= 2) {

                if (ticket[i] > 0) {
                    oddMax += ticket[i];
                    oddMaxPath += ticket[i];
                } else {
                    i++;
                }

            }
            int evenMax = 0;
            String evenMaxPath = "";
            for (int i = n - 2; i >= 0; i -= 2) {

                if (ticket[i] > 0) {
                    evenMax += ticket[i];
                    evenMaxPath += ticket[i];
                } else {
                    i++;
                }
            }
            if (evenMax > max && evenMax == oddMax) {
                if (Integer.parseInt(oddMaxPath) > Integer.parseInt(evenMaxPath)) {
                    System.out.println(oddMaxPath);
                } else {
                    System.out.println(evenMaxPath);
                }
            } else if (evenMax > oddMax && evenMax > max) {
                System.out.println(evenMaxPath);
            } else if (oddMax > max) {
                System.out.println(oddMaxPath);
            } else {
                System.out.println(max);
            }
        }

    }
}
