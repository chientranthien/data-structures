package com.chientt.queue;

/**
 *
 * @author chientt
 */
public class QueueImpl<T> implements Queue<T> {

    private Node<T> head;

    @Override
    public void enqueue(T t) {
        if (head == null) {
            head = new Node(t);
        } else {
            Node<T> node = head;
            while (node.nextNode != null) {
                node = node.nextNode;
            }
            node.nextNode = new Node(t);
        }
        int a = 1;
    }

    @Override
    public T dequeue() {
        T result = head.data;
        head = head.nextNode;
        return result;
    }

    public static class Node<T> {

        T data;
        public Node nextNode;

        public Node(T t) {
            data = t;
            nextNode = null;
        }

    }
}
