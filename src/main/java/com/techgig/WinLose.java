package com.techgig;

import java.util.Arrays;
import java.util.Scanner;

public class WinLose {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int[] player = new int[n];
            int[] villain = new int[n];
            for (int i = 0; i < n; i++) {
                villain[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                player[i] = scanner.nextInt();
            }

            Arrays.sort(player);
            Arrays.sort(villain);
            boolean win = true;
            for (int i = 0; i < n; i++) {
                if (player[i] < villain[i]) {
                    win = false;
                    break;
                }
            }
            System.out.println(win ? "WIN" : "LOSE");
        }
    }
}
