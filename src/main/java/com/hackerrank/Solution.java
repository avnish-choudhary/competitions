package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the secureChannel function below.
    static String secureChannel(int operation, String message, String key) {

                try {
                    if (operation == 1) {
                        char[] chars = message.toCharArray();
                        int pos = 0;
                        String newMessage = "";
                        for (char duplicateCount : key.toCharArray()) {
                            int count = Integer.parseInt(duplicateCount + "");
                            if(pos< chars.length) {
                                char character = chars[pos++];
                                for (int i = 0; i < count; i++) {
                                    newMessage += character;
                                }
                            }
                        }
                        if (pos < message.length()) {
                            newMessage += message.substring(pos);
                        }
                        return newMessage;
                    } else if (operation == 2) {
                        char[] chars = message.toCharArray();
                        int pos = 0;
                        String newMessage = "";
                        int length = 0;
                        for (char duplicateCount : key.toCharArray()) {
                            int count = Integer.parseInt(duplicateCount + "");
                            for (int i = 0; i < count - 1; i++) {
                                pos++;
                            }
                            if(pos< chars.length) {
                                char character = chars[pos];
                                newMessage += character;
                                length += count;
                            }
                        }
                        if (length < message.length()) {
                            newMessage += message.substring(length);
                        }
                        return newMessage;
                    }
                } catch (Exception e) {

                    return "-1";
                }
                return "-1";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int operation = Integer.parseInt(bufferedReader.readLine().trim());

        String message = bufferedReader.readLine();

        String key = bufferedReader.readLine();

        String res = secureChannel(operation, message, key);
        System.out.println(res);

        bufferedReader.close();
    }
}