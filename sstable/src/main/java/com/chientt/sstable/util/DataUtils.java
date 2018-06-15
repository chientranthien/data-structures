package com.chientt.sstable.util;

import static com.chientt.sstable.constant.GlobalConstant.SEPARATED_CHAR;
import com.chientt.sstable.entity.Data;
import java.util.Base64;

/**
 *
 * @author chientt
 */
public class DataUtils {

    public static String encode(String str) {
        byte[] encoded = Base64
                .getEncoder()
                .encode(str.getBytes());
        return new String(encoded);
    }

    public static String decode(String str) {
        byte[] decoded = Base64
                .getDecoder()
                .decode(str);
        return new String(decoded);
    }

    public static Data decodeDataStr(String line) {
        if (line == null || line.isEmpty() || !line.contains(SEPARATED_CHAR)) {
            return null;
        }
        String[] splited = line.split(SEPARATED_CHAR);
        String decodedIndex = decode(splited[0]);
        String decodedValue = decode(splited[1]);
        return new Data(decodedIndex, decodedValue);
    }

    public static String encodeData(Data data) {
        if (data == null || data.index == null || data.value == null) {
            return null;
        }
        String encodedIndex = encode(data.index);
        String encodedValue = encode(data.value);
        return encodedIndex + SEPARATED_CHAR + encodedValue;
    }
}
