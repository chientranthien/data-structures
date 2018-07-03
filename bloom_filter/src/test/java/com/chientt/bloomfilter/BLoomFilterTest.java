package com.chientt.bloomfilter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class BLoomFilterTest {

    private String[] inputs
            = new String[]{"this", "is", "a", "very", "simple", "test"};
    private String[] randomInputs
            = new String[]{"go", "to", "a", "place"};
    BloomFilter bloomFilter
            = new SimpleBloomFilter(inputs.length);

    public BLoomFilterTest() {
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
