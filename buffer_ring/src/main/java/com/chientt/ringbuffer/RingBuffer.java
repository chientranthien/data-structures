package com.chientt.ringbuffer;

/**
 * @author chientt
 */
public class RingBuffer<T> {

    private Object[] data;
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

    public int available() {
        if (!flipped) {
            return writePos - readPos;
        }
        return capacity - readPos + writePos;
    }

    public int remainingCapacity() {
        if (!flipped) {
            return capacity - writePos;
        }
        return readPos - writePos;
    }

    public boolean put(T t) {
        if (flipped) {
            if (writePos < readPos) {
                data[writePos++] = t;
            } else {
                return false;
            }

        } else {
            if (writePos > readPos) {
                data[writePos++] = t;
                if (writePos >= capacity) {
                    writePos = 0;
                    flipped = true;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public T take() {
        T result = (T) data[readPos];
        readPos++;
        if (readPos >= capacity) {
            readPos = 0;
        }

        return result;
    }
}
