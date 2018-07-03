package com.chientt.bloomfilter;

import java.util.BitSet;

/**
 *
 * @author chientt
 */
public class Md5BloomFilter implements BloomFilter {

    private BitSet bitSet;
    private int numberElementAdded;
    private int bitSetSize;
    
    @Override
    public boolean mightContain(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
