package com.chientt.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 *
 * @author chientt
 */
public class BinaryTree<T> implements Iterable<T> {

    private Node<T> root;

    void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Node<T> temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.leftNode == null) {
                temp.leftNode = new Node(data);
                break;
            } else {
                queue.add(temp.leftNode);
            }

            if (temp.rightNode == null) {
                temp.rightNode = new Node(data);
                break;
            } else {
                queue.add(temp.rightNode);
            }
        }
    }

    void traverse(Consumer<Node> consumer) {
        Node<T> tmp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tmp);
        while (!queue.isEmpty()) {
            tmp = queue.remove();
            if (tmp != null) {
                consumer.accept(tmp);
                queue.add(tmp.leftNode);
                queue.add(tmp.rightNode);
            } else {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>();
    }

    public class Iter<T> implements Iterator<T> {

        Queue<Node> queue = new LinkedList<>();

        public Iter() {
            queue.add(root);
        }

        @Override
        public boolean hasNext() {
            Node peek = queue.peek();
            if (peek == null) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            Node<T> node = queue.remove();
            if (node != null) {
                queue.add(node.leftNode);
                queue.add(node.rightNode);
            }
            return node.getData();
        }

    }

    public static class Node<T> {

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;
    }

}
