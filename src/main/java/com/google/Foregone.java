package com.google;

import java.util.Scanner;

public class Foregone {

    static boolean isDigitPresent(int x, int d) {
        // Breal loop if d is present as digit
        while (x > 0) {
            if (x % 10 == d || x % 10 == 0)
                break;

            x = x / 10;
        }

        // If loop broke
        return (x > 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            for (int i = n/2; i >0; i--) {

                if (!isDigitPresent(i, 4) && !isDigitPresent(n - i, 4)) {
                    System.out.println("Case #" + t + ": " + i + " " + (n - i));
                    break;
                }
            }
        }
    }
}

