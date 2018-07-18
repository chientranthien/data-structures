package com.chientt.bst;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class ContainTest {

    private BinarySearchTree binarySearchTree = new BinarySearchTree();
    private int[] inputs = new int[]{5, 2, 4, 7, 6};

    public ContainTest() {
        for (int input : inputs) {
            binarySearchTree.insert(input);
        }

    }

    @Test
    public void shouldContainValue() {
        for (int input : inputs) {
            boolean contains = binarySearchTree.contains(input);
            Assertions.assertThat(contains).isTrue();
        }
    }

    @Test
    public void shouldNotContainValue() {
        boolean contains = binarySearchTree.contains(9);
        Assertions.assertThat(contains).isFalse();
        contains = binarySearchTree.contains(10);
        Assertions.assertThat(contains).isFalse();
        contains = binarySearchTree.contains(-1);
        Assertions.assertThat(contains).isFalse();
        contains = binarySearchTree.contains(-2);
        Assertions.assertThat(contains).isFalse();
    }
}
