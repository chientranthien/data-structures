package com.chientt.avltree;

/**
 * @author chientt
 */
public class AvlTree<T> {

    private Node<T> root;

    public void insert(T data) {
        Node<T> node;
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.leftNode) - height(N.rightNode);
    }

    Node leftRotate(Node z) {
        Node y = z.rightNode;
        Node T2 = y.leftNode;

        y.leftNode = z;
        z.rightNode = T2;

        z.height = Math.max(height(z.leftNode), height(z.rightNode)) + 1;
        y.height = Math.max(height(y.leftNode), height(y.rightNode)) + 1;

        return y;
    }

    Node rightRotate(Node z) {
        Node y = z.leftNode;
        Node T3 = y.rightNode;

        y.rightNode = z;
        z.leftNode = T3;

        z.height = Math.max(height(z.leftNode), height(z.rightNode)) + 1;
        y.height = Math.max(height(y.leftNode), height(y.rightNode)) + 1;

        // Return new root
        return y;
    }

    public void traverse() {

    }

    public static class Node<T> {

        private int data;
        private int height;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(int data) {
            this.data = data;
            height = 1;
        }

    }

}
