package com.chientt.bloomfilter;

/**
 *
 * @author chientt
 */
public interface BloomFilter {

    boolean mightContain(String val);

    void put(String val);
}
