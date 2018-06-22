package com.chientt.bufferring;

/**
 *
 * @author chientt
 */
public class BufferRing<T> {

    T[] data;
    int pos;
    int capacity;

    public BufferRing(int capacity) {
        this.capacity = capacity;
        data = new T[capacity];
    }

    public void add(T t) {
        data[pos] = t;
    }
}
