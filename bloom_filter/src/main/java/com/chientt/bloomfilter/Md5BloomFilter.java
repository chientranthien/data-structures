package com.chientt.bloomfilter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/**
 *
 * @author chientt
 */
public class Md5BloomFilter implements BloomFilter {

    private int NUM_HASH = 3;

    private BitSet bitSet;
    private int numberElementAdded;
    private int bitSetSize;
    private static final String hashName = "MD5";
    private static final MessageDigest digestFunction;

    public Md5BloomFilter(int bitSetSize) {
        this.bitSetSize = bitSetSize;
        bitSet= new BitSet(bitSetSize);
    }

    static { // The digest method is reused between instances
        MessageDigest tmp;
        try {
            tmp = java.security.MessageDigest.getInstance(hashName);
        } catch (NoSuchAlgorithmException e) {
            tmp = null;
        }
        digestFunction = tmp;
    }

    @Override
    public boolean mightContain(String val) {
        int[] hashes = hash(val, NUM_HASH);
        for (int hash : hashes) {
            int index = getIndex(hash);
            boolean isSet = bitSet.get(index);
            if (!isSet) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void put(String val) {
        int[] hashes = hash(val, NUM_HASH);
        for (int hash : hashes) {
            int index = getIndex(hash);
            bitSet.set(index);
            numberElementAdded++;
        }
    }

    private int getIndex(int hash) {
        return Math.abs(hash / bitSetSize);
    }

    private int[] hash(String val, int num_hash) {
        int result[] = new int[num_hash];
        for (byte i = 0; i < num_hash; i++) {
            digestFunction.update(i);
            byte[] digest = digestFunction.digest(val.getBytes());
            int len = digest.length;
            for (int j = 0; j < len && i < num_hash; j += 4) {
                int hash = bytesToInt(digest, j, j + 4);
                result[i] = hash;
                i++;
            }
        }
        return result;
    }

    private int bytesToInt(byte[] bytes, int from, int to) {
        int num = 0;
        for (int i = from; i < to; i++) {
            byte aByte = bytes[from];
            num = num << 8;
            num |= aByte;
        }
        return num;
    }

  
}
