package com.chientt.binarytree;

import java.util.Iterator;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author chientt
 */
public class BinaryTreeIterTest {

    private int[] inputs = new int[]{1, 2, 3, 4, 5};

    @Test
    public void shouldTraverseAllKey() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        for (Integer input : inputs) {
            binaryTree.insert(input);
        }

        Iterator<Integer> iterator = binaryTree.iterator();
        for (int i = 0; i < inputs.length; i++) {
            boolean hasNext = iterator.hasNext();
            assertThat(hasNext).isTrue();
            Integer next = iterator.next();
            assertThat(next).isEqualTo(inputs[i]);
        }
    }
}
