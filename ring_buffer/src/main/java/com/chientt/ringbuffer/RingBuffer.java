package com.chientt.ringbuffer;

/**
 * @author chientt
 */
public class RingBuffer<T> implements Queue<T> {

    public Object[] data;
    private int writePos;
    private int readPos;
    private int capacity;
    private boolean flipped;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void reset() {
        this.writePos = 0;
        this.readPos = 0;
        this.flipped = false;
    }

    @Override
    public boolean put(T t) {
        if (flipped) {
            if (writePos < readPos) {
                data[writePos++] = t;
            } else {
                return false;
            }

        } else {
            data[writePos++] = t;
            if (writePos >= capacity) {
                writePos = 0;
                flipped = true;
            }
        }

        return true;
    }

    @Override
    public T take() {
        if (flipped) {

            T result = (T) data[readPos++];
            if (readPos >= capacity) {
                readPos = 0;
                flipped = false;
            }
            return result;
        } else {
            if (readPos < writePos) {
                T result = (T) data[readPos++];
                if (readPos >= capacity) {
                    readPos = 0;
                }
                return result;
            } else {
                return null;
            }
        }

    }

}
