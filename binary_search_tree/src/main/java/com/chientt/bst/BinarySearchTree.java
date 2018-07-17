package com.chientt.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author chientt
 */
public class BinarySearchTree {

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node tmp = root;
        queue.add(tmp);
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            if (data > tmp.data) {
                if (tmp.rightNode == null) {
                    tmp.rightNode = new Node(data);
                    break;
                } else {
                    queue.add(tmp.rightNode);
                }
            } else {
                if (tmp.leftNode == null) {
                    tmp.leftNode = new Node(data);
                    break;
                } else {
                    queue.add(tmp.leftNode);
                }
            }
        }
    }

    public boolean contains(int value) {
        Node findResult = internalFind(root, value);
        return findResult != null;
    }

    public Node internalFind(Node node, int value) {
        if (node == null || node.data == value) {
            return node;
        }

        if (node.data < value) {
            return internalFind(node.rightNode, value);
        } else {
            return internalFind(node.leftNode, value);
        }

    }

    public static class Node {

        public int data;
        public Node leftNode;
        public Node rightNode;

        public Node(int data) {
            this.data = data;
        }

    }
}
