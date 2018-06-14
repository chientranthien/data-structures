package com.chientt.sstable.writer;

import com.chientt.sstable.Data;
import com.chientt.sstable.SStable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class SStableTests {

    @Test
    public void test() throws FileNotFoundException, IOException {
        SStable sstable = new SStable();
        sstable.add(new Data("this", "this doc contains a word"));
//        sstable.add(new Data("this", "a word"));
        List<Data> aaa = sstable.find("word");
        System.out.println(aaa);
    }
}
