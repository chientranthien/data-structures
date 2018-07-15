package com.chientt.avltree;

/**
 *
 * @author chientt
 */
public class AvlTree<T> {

    private Node<T> root;

    public void insert(T data) {
        Node<T> node;
    }

Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
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
