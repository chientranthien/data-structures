package com.chientt.sstable.writer;

import static com.chientt.sstable.constant.GlobalConstant.DATA_PATH;
import com.chientt.sstable.entity.Data;
import com.chientt.sstable.util.DataUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @author chientt
 */
public class DataWriter implements FileWriter {

    /**
     * key columnCount
     *
     * @param data
     * @return
     */
    @Override
    public long write(Data data) {
        long pos = -1;
        try {
            String line = DataUtils.encodeData(data);
            List<String> lines = Arrays.asList(line);
            Path path = Paths.get(DATA_PATH);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            pos = Files.size(path);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pos;

    }

}
