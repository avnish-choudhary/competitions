package com.techgig;

import java.util.Scanner;

public class ChefAndInterview {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            System.out.println(findAnswer(n));
            t--;
        }

    }

    private static int findAnswer(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
      //  int lcm = find
    return -1;
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static int findGCD(int arr[]) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            result = gcd(arr[i], result);
        return result;
    }

    private static int lcm(int[] a) {
        int lcm = 1;
        int gcd = findGCD(a);
        for (int i = 0; i < a.length; i++) {
            lcm *= a[i];
        }
        lcm /= gcd;
        return lcm;
    }


}
