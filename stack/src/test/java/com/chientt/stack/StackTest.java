package com.chientt.stack;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class StackTest {

    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer value = stack.pop();
        assertThat(value).isEqualTo(3);
        value = stack.pop();
        assertThat(value).isEqualTo(2);
        value = stack.pop();
        assertThat(value).isEqualTo(1);
    }

    @Test
    public void testAutoResize() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }
}
