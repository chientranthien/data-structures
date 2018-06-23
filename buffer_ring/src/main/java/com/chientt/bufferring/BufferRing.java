package com.chientt.bufferring;

/**
 * @author chientt
 */
public class BufferRing<T> {

    Object[] data;
    private int writePos;
    private int readPos;
    private int capacity;

    public BufferRing(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void add(T t) {
        data[writePos] = t;
        writePos++;
        if (writePos >= capacity)
            writePos = 0;
    }

    public T get() {
        T result = (T) data[readPos];
        readPos++;
        if (readPos >= capacity)
            readPos = 0;

        return result;
    }
}
