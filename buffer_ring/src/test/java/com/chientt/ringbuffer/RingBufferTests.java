package com.chientt.ringbuffer;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class RingBufferTests {

    int capacity = 3;
    int[] inputs = new int[capacity];

    {
        for (int i = 0; i < capacity; i++) {
            inputs[i] = i;
        }
    }

    @Test
    public void shouldPut() {

        Queue<Integer> ringBuffer = new RingBuffer<>(capacity);
        for (int input : inputs) {
            boolean put = ringBuffer.put(input);
            assertThat(put).isTrue();
        }
        boolean put = ringBuffer.put(capacity + 1);
        assertThat(put).isFalse();

    }

    @Test
    public void shouldTake() {
        Queue<Integer> ringBuffer = new RingBuffer<>(capacity);
        for (int input : inputs) {
            ringBuffer.put(input);
        }
        for (int input : inputs) {
            Integer take = ringBuffer.take();
            assertThat(take).isEqualTo(input);
        }
        Integer take = ringBuffer.take();
        assertThat(take).isNull();
    }
}
