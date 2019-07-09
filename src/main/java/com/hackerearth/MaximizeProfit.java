package com.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximizeProfit {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] profit = new int[n];

        Node root = new Node();
        root.setProfit(0);

        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
            Node newNode = new Node();
            newNode.setProfit(profit[i]);
            addNode(root, newNode);
        }
        System.out.println(maxProfitFinal(root, 0));

    }

    private static void addNode(Node root, Node newNode) {
        for (Node node : root.getChildNodes()) {
            if (newNode.getProfit() % node.getProfit() == 0) {
                addNode(node, newNode);
                return;
            }
        }
        root.setProfit(root.getProfit() + newNode.getProfit());
        root.getChildNodes().add(newNode);
    }

  /*  private static int maxProfit(Node node, int maxProfit) {
        int maxProfitFinal = 0;

        for (Node node1 : node.getChildNodes()) {


            maxProfitFinal += node1.getProfit();
        }
        return
        }
    */


    private static int maxProfitFinal(Node node, int maxProfit) {
        if (node.getChildNodes().isEmpty()) {
            return maxProfit + node.getProfit();
        }
        for (Node node1 : node.getChildNodes()) {
            maxProfit = Math.max(node1.getProfit(), maxProfitFinal(node1, maxProfit));
        }
        return maxProfit;
    }

    static class Node {

        int profit;

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        List<Node> childNodes = new ArrayList<>();
    }

    static int maxProfit(int[] profit) {
        int maxProfit[] = new int[profit.length];
        int lastProfit[] = new int[profit.length];
        for (int i = 0; i < profit.length; i++) {
            lastProfit[i] = 0;
            maxProfit[i] = 0;
            for (int j = i; j < profit.length; j++) {
                if (lastProfit[i] == 0 || profit[j] % lastProfit[i] == 0) {
                    maxProfit[i] += profit[j];
                    lastProfit[i] = profit[j];
                }
            }

        }
        int finalMaxProfit = -1;
        for (int i = 0; i < maxProfit.length; i++) {
            if (finalMaxProfit < maxProfit[i]) {
                finalMaxProfit = maxProfit[i];
            }
        }
        return finalMaxProfit;

    }

}
