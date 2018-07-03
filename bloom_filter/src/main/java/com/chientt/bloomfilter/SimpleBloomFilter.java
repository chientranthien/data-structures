package com.chientt.bloomfilter;

import java.util.BitSet;

/**
 *
 * @author chientt
 */
public class SimpleBloomFilter implements BloomFilter {

    private BitSet bitSet;
    private int numberElementAdded;
    private int bitSetSize;

    public SimpleBloomFilter(int bitSetSize) {
        this.bitSetSize = bitSetSize;
        bitSet = new BitSet(bitSetSize);
    }

    @Override
    public boolean mightContain(String val) {
        int index = computeIndex(val);
        return bitSet.get(index);
    }

    @Override
    public void put(String val) {
        int index = computeIndex(val);
        bitSet.set(index);
        numberElementAdded++;
    }

    private int computeIndex(String val) {
        int hashCode = val.hashCode();
        hashCode=Math.abs(hashCode);
        return hashCode % bitSetSize;
    }

    public int getNumberElementAdded() {
        return numberElementAdded;
    }

}
