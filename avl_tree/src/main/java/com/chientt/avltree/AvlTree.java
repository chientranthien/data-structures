package com.chientt.avltree;

/**
 * @author chientt
 */
public class AvlTree {

    private Node root;

    int height(Node N) {
        if (N == null) {
            return 0;
        }

        return N.height;
    }

    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

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

        return y;
    }

    public void traverse() {

    }

    public static class Node {

        private int data;
        private int height;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
            height = 1;
        }

    }

    public void insert(int data) {
        internalInsert(root, data);
    }

    private Node internalInsert(Node node, int data) {

        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.leftNode = internalInsert(node.leftNode, data);
        } else if (data > node.data) {
            node.rightNode = internalInsert(node.rightNode, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.leftNode),
                height(node.rightNode));

        int balance = getBalance(node);

        if (balance > 1 && data < node.leftNode.data) {
            return rightRotate(node);
        }

        if (balance < -1 && data > node.rightNode.data) {
            return leftRotate(node);
        }

        if (balance > 1 && data > node.leftNode.data) {
            node.leftNode = leftRotate(node.leftNode);
            return rightRotate(node);
        }

        if (balance < -1 && data < node.rightNode.data) {
            node.rightNode = rightRotate(node.rightNode);
            return leftRotate(node);
        }

        return node;
    }

}
