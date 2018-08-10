package com.chientt.stack;

import java.util.Arrays;

/**
 *
 * @author chientt
 */
public class Stack<T> {

    private static final Integer DEFAULT_CAPACITY = 12;
    private Object[] array;
    private int pos;

    public Stack() {
        pos = -1;
        array = new Object[DEFAULT_CAPACITY];
    }

    public Stack(int capacity) {
        pos = -1;
        array = new Object[capacity];
    }

    public void push(T value) {
        pos++;
        if (pos < array.length) {
            array[pos] = value;
        } else {
            int newLength = array.length * 2;
            array = Arrays.copyOf(array, newLength);
        }
    }

    public T pop() {
        if (pos < 0 || pos > array.length) {
            return null;
        }
        T result = (T) array[pos];
        array[pos] = null;
        pos--;
        return result;
    }
}
