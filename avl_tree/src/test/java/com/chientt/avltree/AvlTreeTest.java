package com.chientt.avltree;

import org.junit.Test;

/**
 *
 * @author chientt
 */
public class AvlTreeTest {

    @Test
    public void shouldInsert() {

        AvlTree avlTree = new AvlTree();
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(6);
        
        
    }
}
