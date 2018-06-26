package com.chientt.bufferring;

/**
 * @author chientt
 */
public class BufferRing<T> {

    private Object[] data;
    private int writePos;
    private int readPos;
    private int capacity;
    private boolean flipped;

    public BufferRing(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void reset() {
        this.writePos = 0;
        this.readPos = 0;
        this.flipped = false;
    }

    public int available() {
        if (!flipped) {
            return writePos - readPos;
        }
        return capacity - readPos + writePos;
    }


    public int remainingCapacity() {
        if(!flipped){
            return capacity - writePos;
        }
        return readPos - writePos;
    }
    public void put(T t) {
        data[writePos] = t;
        writePos++;
        if (writePos >= capacity)
            writePos = 0;
    }

    public T take() {
        T result = (T) data[readPos];
        readPos++;
        if (readPos >= capacity)
            readPos = 0;

        return result;
    }
}
