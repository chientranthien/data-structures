package com.chientt.ringbuffer;

/**
 *
 * @author chientt
 */
public interface Queue<T> {

    boolean put(T t);

    T take();
}
