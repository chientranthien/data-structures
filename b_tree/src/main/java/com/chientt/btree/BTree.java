package com.chientt.btree;

public class BTree {

    public static class Node {

        private int data;
        private int[] keys;
        private Node[] childNodes;
        private boolean leaf;
        private int minimumDegree;
    }
}
