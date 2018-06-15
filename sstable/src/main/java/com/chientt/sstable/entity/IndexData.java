package com.chientt.sstable.entity;

import java.util.Set;

/**
 *
 * @author chientt
 */
public class IndexData {

    public String index;
    public Set<Long> offsets;

    public IndexData(String index, Set<Long> offsets) {
        this.index = index;
        this.offsets = offsets;
    }

    public IndexData() {
    }

}
