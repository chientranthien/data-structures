package com.chientt.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class QueueTests {

    @Test
    public void shouldEnqueInTheRightOrder() {
        int[] input = new int[]{1, 2, 3};
        Queue<Integer> queue = new QueueImpl<>();
        for (int i = 0; i < input.length; i++) {
            queue.enqueue(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            Integer dequeued = queue.dequeue();
            Assertions.assertThat(dequeued).isEqualTo(input[i]);
        }
    }
}
