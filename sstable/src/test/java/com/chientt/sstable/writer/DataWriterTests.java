package com.chientt.sstable.writer;

import com.chientt.sstable.util.DataUtils;
import static com.chientt.sstable.constant.GlobalConstant.*;
import com.chientt.sstable.entity.Data;
import com.chientt.sstable.reader.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class DataWriterTests {

    @Test
    public void shouldAppendFile() throws IOException {
        Data data = new Data("index", "value");
        DataWriter dataWriter = new DataWriter();
        dataWriter.write(data);
        String lastLine = getLastLine();
        System.out.println(lastLine);
        assertThat(lastLine)
                .isNotNull()
                .isNotEmpty()
                .contains(SEPARATED_CHAR);

        Data decodedData = DataUtils.decodeDataStr(lastLine);
        assertThat(data.index).isEqualTo(decodedData.index);
        assertThat(data.value).isEqualTo(decodedData.value);
    }

 
    private String getLastLine() throws IOException {
        Path path = Paths.get(DATA_PATH);
        List<String> allLines = Files.readAllLines(path);
        return allLines.get(allLines.size() - 1);
    }
}
