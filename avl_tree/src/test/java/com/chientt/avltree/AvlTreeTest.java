package com.chientt.avltree;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author chientt
 */
public class AvlTreeTest {

    AvlTree binarySearchTree = new AvlTree();

    @Test
    public void shouldInsert() {
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);
        binarySearchTree.insert(11);

        AvlTree.Node root = Whitebox.getInternalState(binarySearchTree, "root");

        assertThat(root.data).isEqualTo(9);
        assertThat(root.rightNode.data).isEqualTo(10);
        assertThat(root.leftNode.leftNode.data).isEqualTo(8);
        assertThat(root.leftNode.leftNode.data).isEqualTo(7);
        assertThat(root.rightNode.rightNode.data).isEqualTo(11);

    }
}
