package com.techgig;

import java.util.Scanner;

public class InsertionSort {

    public static int[] sort(int[] a)
    {
        for(int i=0;i<a.length; i++)
        {
            int j=i;

            while (j>0 && a[j] < a[j-1])
            {
                int temp = a[j];
                a[j]= a[j-1];
                a[j-1]= temp;

                j--;
            }


        }
        return a;
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();

        }
       sort(a);
        System.out.println("Sorted Array:");
        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }

    }


}
