package com.chientt.sstable.entity;

/**
 *
 * @author chientt
 */
public class Data {

    public String index;
    public String value;

    public Data(String index, String value) {
        this.index = index;
        this.value = value;
    }

    public Data() {
        
    }

    @Override
    public String toString() {
        return "Data{" + "index=" + index + ", value=" + value + '}';
    }

    
    
}
