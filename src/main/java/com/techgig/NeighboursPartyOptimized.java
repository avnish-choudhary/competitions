package com.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeighboursPartyOptimized {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int[] ticket = new int[n];

            List<List<Integer>> groups = new ArrayList<List<Integer>>();

            List<Integer> subgroup = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                ticket[i] = scanner.nextInt();

                if (ticket[i] > 0) {
                    subgroup.add(ticket[i]);

                } else {
                    if (!subgroup.isEmpty()) {
                        groups.add(subgroup);
                        subgroup = new ArrayList<Integer>();
                    }
                }
            }
            if (!subgroup.isEmpty()) {
                groups.add(subgroup);
            }
            int max = ticket[0];
            for (int i = 1; i < n; i++) {
                if (ticket[i] > max) {
                    max = ticket[i];
                }
            }
            if (groups.isEmpty()) {
                System.out.println(max);
            } else {
               /* for (int i = ticket.length - 1; i >= 0; i--) {

                    if(t)

                    if (getEvenSum(group) > getOddSum(group)) {
                        printEven(group);
                    } else if (getEvenSum(group) < getOddSum(group)) {
                        printOdd(group);
                    } else {
                        if (isEven(group)) {
                            printEven(group);
                        } else
                            printOdd(group);
                    }

                }*/
                System.out.println();

            }
        }
    }

    private static int getEvenSum(int[] ticket, int i, int j) {
        int sum = 0;
        for (int m = i; m >= j; m -= 2) {
            sum += ticket[m];
        }
        return sum;
    }

    private static boolean isEven(int[] ticket, int i, int j) {
        boolean even = true;
        for (int m = i; m > j; m -= 1) {
            if (ticket[m] > ticket[m - 1]) {
                return true;
            } else if (ticket[m] < ticket[m - 1]) {
                return false;
            }
        }
        return even;
    }

    private static void printEven(int[] ticket, int i, int j) {
        for (int m = i; m >= j; m -= 2) {
            System.out.print(ticket[m]);
        }
    }

    private static void printOdd(int[] ticket, int i, int j) {
        for (int m = i; m >= i; m -= 2) {
            System.out.print(ticket[m]);
        }
    }

    private static int getOddSum(int[] ticket, int i, int j) {
        int sum = 0;
        for (int m = i; m >= j; m -= 2) {
            sum += ticket[m];
        }
        return sum;
    }


}
