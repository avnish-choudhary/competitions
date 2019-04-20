package com.techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeighboursPartyNew {
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
                for (int i = groups.size() - 1; i >= 0; i--) {
                    List<Integer> group = groups.get(i);
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

                }
                System.out.println();

            }
        }
    }

    private static int getEvenSum(List<Integer> group) {
        int sum = 0;
        for (int i = group.size() - 1; i >= 0; i -= 2) {
            sum += group.get(i);
        }
        return sum;
    }

    private static boolean isEven(List<Integer> group) {
        boolean even = true;
        for (int i = group.size() - 1; i > 0; i -= 1) {
            if (group.get(i) > group.get(i - 1)) {
                return true;
            } else if (group.get(i) < group.get(i - 1)) {
                return false;
            }
        }
        return even;
    }

    private static void printEven(List<Integer> group) {
        for (int j = group.size() - 1; j >= 0; j -= 2) {
            System.out.print(group.get(j));
        }
    }

    private static void printOdd(List<Integer> group) {
        for (int j = group.size() - 2; j >= 0; j -= 2) {
            System.out.print(group.get(j));
        }
    }

    private static int getOddSum(List<Integer> group) {
        int sum = 0;
        for (int i = group.size() - 2; i >= 0; i -= 2) {
            sum += group.get(i);
        }
        return sum;
    }


}
