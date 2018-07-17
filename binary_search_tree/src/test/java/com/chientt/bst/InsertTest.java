package com.chientt.bst;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author chientt
 */
public class InsertTest {

    BinarySearchTree binarySearchTree = new BinarySearchTree();

    @Test
    public void shouldInsert() {
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(1);
        BinarySearchTree.Node parent = Whitebox.getInternalState(binarySearchTree, "root");
        Assertions.assertThat(parent.rightNode.data).isEqualTo(6);
        Assertions.assertThat(parent.leftNode.data).isEqualTo(2);
          Assertions.assertThat(parent.rightNode.rightNode.data).isEqualTo(7);
        Assertions.assertThat(parent.leftNode.leftNode.data).isEqualTo(1);
    }
}
