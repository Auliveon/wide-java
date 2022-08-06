package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtReader {

    public static String getText(String path) {
        String result = null;
        try {
            result = String.join("\n", Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
