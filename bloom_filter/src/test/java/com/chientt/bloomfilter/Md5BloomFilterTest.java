package com.chientt.bloomfilter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class Md5BloomFilterTest {

    private String[] inputs
            = new String[]{"this", "is", "a", "very", "simple", "test"};
    private String[] randomInputs
            = new String[]{"go", "to", "a", "place"};
    BloomFilter bloomFilter
            = new Md5BloomFilter(inputs.length);

    public Md5BloomFilterTest() {
        for (String input : inputs) {
            bloomFilter.put(input);
        }
    }
    
    @Test
    public void shouldContain() {

        for (String input : inputs) {
            boolean mayContain = bloomFilter.mightContain(input);
            Assertions.assertThat(mayContain).isTrue();
        }
    }
}
