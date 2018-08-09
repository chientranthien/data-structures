package com.chientt.stack;

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

    public void push(T value) {
        pos++;
        array[pos] = value;
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
