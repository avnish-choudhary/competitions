package com.techgig;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the countSpecialElements function below.
    static int countSpecialElements(List<List<Integer>> matrix) {
        Set<Integer> uniqueNos = new HashSet<>();
        Set<Integer> rowMaxSet = new HashSet<>();
        Set<Integer> rowMinSet = new HashSet<>();
        for (List<Integer> data : matrix) {
            int rowMax = -1;
            int rowMin = Integer.MAX_VALUE;
            for (Integer no : data) {
                if (!uniqueNos.add(no)) {
                    return -1;
                }
                if (rowMax < no) {
                    rowMax = no;
                }
                if (rowMin > no) {
                    rowMin = no;
                }
            }
            rowMaxSet.add(rowMax);
            rowMinSet.add(rowMin);
        }
        uniqueNos = new HashSet<>();
        Set<Integer> colMaxSet = new HashSet<>();
        Set<Integer> colMinSet = new HashSet<>();

        for (int i = 0; i < matrix.get(0).size(); i++) {
            int colMax = -1;
            int colMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix.size(); j++) {

                int no = matrix.get(j).get(i);
                if (!uniqueNos.add(no)) {
                    return -1;
                }
                if (colMax < no) {
                    colMax = no;
                }
                if (colMin > no) {
                    colMin = no;
                }

            }
            colMaxSet.add(colMax);
            colMinSet.add(colMin);
        }

        Set<Integer> specialElements = new HashSet<>();
        specialElements.addAll(colMaxSet);
        specialElements.addAll(colMinSet);
        specialElements.addAll(rowMaxSet);
        specialElements.addAll(rowMinSet);
        return specialElements.size();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = scanner.nextInt();
        int matrixColumns = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < matrixRows; i++) {
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < matrixColumns; j++) {
                int matrixItem = scanner.nextInt();
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int res = countSpecialElements(matrix);
        System.out.println(res);
    }
}
