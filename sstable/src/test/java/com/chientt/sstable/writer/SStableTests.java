package com.chientt.sstable.writer;

import com.chientt.sstable.SStable;
import com.chientt.sstable.entity.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class SStableTests {

    @Test
    public void shouldWriteAndReadDataSuccess() throws FileNotFoundException, IOException {
        SStable sstable = new SStable();
        Data data = new Data("word", "this doc contains a word");
        sstable.add(data);
        List<Data> allData = sstable.find("word");

        assertThat(allData)
                .isNotNull()
                .isNotEmpty()
                .allMatch((t) -> {
                    return t.index.equals(data.index);
                });

    }
}
