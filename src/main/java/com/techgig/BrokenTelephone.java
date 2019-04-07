package com.techgig;

import java.util.Scanner;

public class BrokenTelephone {

    private static int findAnswer(int a[]) {
        int count = 0;
        if (a.length > 1) {
            int lastIndex = -1;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] != a[i + 1]) {
                    if (lastIndex == i) {
                        count++;
                    } else {
                        count += 2;
                    }
                    lastIndex = i + 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(findAnswer(a));
            t--;
        }
    }
}
