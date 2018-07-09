package com.chientt.binarytree;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author chientt
 */
public class BinaryTreeTest {

    private int[] inputs = new int[]{1, 2, 3, 4, 5};

    @Test
    public void shouldInsert() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        for (int input : inputs) {
            binaryTree.insert(input);
        }

        BinaryTree.Node parent = Whitebox.getInternalState(binaryTree, "root");

        Assertions.assertThat(parent.getData()).isEqualTo(inputs[0]);
        BinaryTree.Node left = parent.getLeftNode();
        Assertions.assertThat(left.getData()).isEqualTo(inputs[1]);
        BinaryTree.Node right = parent.getRightNode();
        Assertions.assertThat(right.getData()).isEqualTo(inputs[2]);
        parent = left;
        left = parent.getLeftNode();
        Assertions.assertThat(left.getData()).isEqualTo(inputs[3]);
        right = parent.getRightNode();
        Assertions.assertThat(right.getData()).isEqualTo(inputs[4]);

    }
}
