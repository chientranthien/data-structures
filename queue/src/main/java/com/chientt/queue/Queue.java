package com.chientt.queue;

/**
 *
 * @author chientt
 */
public interface Queue<T> {

    void enqueue(T t);

    T dequeue();
}
