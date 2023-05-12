package main;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools {
    public static  JSONObject jsonFileToJsonObject(String path) throws IOException {
        return new JSONObject(String.join(" ", Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8)));
    }
}
