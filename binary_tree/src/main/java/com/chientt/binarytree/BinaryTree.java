package com.chientt.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
            temp = queue.peek();
            queue.remove();

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

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class Iter implements Iterator<T> {

        @Override
        public boolean hasNext() {
            if (root == null) {
                return false;
            }

            return true;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

// public class GFG {
//      
//    /* A binary tree node has key, pointer to 
//    left child and a pointer to right child */
//    static class Node {
//        int key;
//        Node left, right;
//         
//        // constructor
//        Node(int key){
//            this.key = key;
//            left = null;
//            right = null;
//        }
//    }
//    static Node root;
//    static Node temp = root;
//     
//    /* Inorder traversal of a binary tree*/
//    static void inorder(Node temp)
//    {
//        if (temp == null)
//            return;
//      
//        inorder(temp.left);q
//        System.out.print(temp.key+" ");
//        inorder(temp.right);
//    }
//      
//    /*function to insert element in binary tree */
//    static void insert(Node temp, int key)
//    {
//        Queue<Node> q = new LinkedList<Node>();
//        q.add(temp);
//      
//        // Do level order traversal until we find
//        // an empty place. 
//        while (!q.isEmpty()) {
//            temp = q.peek();
//            q.remove();
//      
//            if (temp.left == null) {
//                temp.left = new Node(key);
//                break;
//            } else
//                q.add(temp.left);
//      
//            if (temp.right == null) {
//                temp.right = new Node(key);
//                break;
//            } else
//                q.add(temp.right);
//        }
//    }
//      
//    // Driver code
//    public static void main(String args[])
//    {
//        root = new Node(10);
//        root.left = new Node(11);
//        root.left.left = new Node(7);
//        root.right = new Node(9);
//        root.right.left = new Node(15);
//        root.right.right = new Node(8);
//      
//        System.out.print( "Inorder traversal before insertion:");
//        inorder(root);
//      
//        int key = 12;
//        insert(root, key);
//      
//        System.out.print("\nInorder traversal after insertion:");
//        inorder(root);
//    }
//}
//// This code is contributed by Sumit Ghosh
}
