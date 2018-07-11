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
