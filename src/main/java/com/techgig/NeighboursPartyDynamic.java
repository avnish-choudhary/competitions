package com.techgig;

import java.util.Scanner;

public class NeighboursPartyDynamic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int[] ticket = new int[n];

            for (int i = 0; i < n; i++) {
                ticket[i] = scanner.nextInt();

            }


            String maxPath = "";
            for (int i = n - 1; i >= 0; i--) {

                if (ticket[i] > 0) {

                    if (i - 3 < n && i !=0) {
                        int ind = getMaxElement(i, i - 1, i - 2, i - 3, ticket);
                        maxPath += ticket[ind];
                        i = ind - 1;
                    } else if (i - 2 < n && i !=0) {
                        int ind = getMaxElement(i, i - 1, i - 2, -1, ticket);
                        maxPath += ticket[ind];
                        i = ind - 1;
                    } else if (i - 1 < n && i !=0)   {
                        int ind = getMaxElement(i, i - 1, -1, -1, ticket);
                        maxPath += ticket[ind];
                        i = ind - 1;
                    } else {
                        maxPath += ticket[i];
                    }
                } else {
                    //i--;
                }

            }
            System.out.println(maxPath);
        }

    }

    private static int getMaxElement(int a, int b, int c, int d, int[] elem) {
        if (elem[b] < 0) {
            return a;
        } else if (c == -1) {
            return elem[a] > elem[b] ? a : b;
        } else if (d == -1) {
            if (elem[c] > 0) {
                return elem[a] + elem[c] > elem[b] ? a : b;
            }
            return elem[a] > elem[b] ? a : b;
        } else if (elem[c] > 0 && elem[d] < 0) {
            return elem[a] + elem[c] > elem[b] ? a : b;
        } else if (elem[a] > 0 && elem[b] > 0 && elem[c] > 0 && elem[d] > 0) {
            return (elem[a] + elem[c] > elem[b] + elem[d]) ? a : b;
        }
        return a;
    }
}
