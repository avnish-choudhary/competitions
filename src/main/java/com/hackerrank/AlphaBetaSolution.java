package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'alphaBeta' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY pile as parameter.
     */

    public static int alphaBeta(List<Integer> pile) {
    // Write your code here
        pile = new ArrayList<>(new HashSet<>(pile));
         Collections.sort(pile);

         return pile.size()>1 ? pile.get(pile.size()-2) : 0;
    }

}

public class AlphaBetaSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pileTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> pile = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pileItem = Integer.parseInt(pileTemp[i]);
            pile.add(pileItem);
        }

        int result = Result.alphaBeta(pile);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
