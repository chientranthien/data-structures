package com.chientt.binarytree;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertThat(parent.getData()).isEqualTo(inputs[0]);
        BinaryTree.Node left = parent.getLeftNode();
        assertThat(left.getData()).isEqualTo(inputs[1]);
        BinaryTree.Node right = parent.getRightNode();
        assertThat(right.getData()).isEqualTo(inputs[2]);
        parent = left;
        left = parent.getLeftNode();
        assertThat(left.getData()).isEqualTo(inputs[3]);
        right = parent.getRightNode();
        assertThat(right.getData()).isEqualTo(inputs[4]);
    }
}
