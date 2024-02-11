package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigurationUtils {
    public static Properties getPropertiesFromFile(String filePath) {
        Properties properties = new Properties();
        String fileUrl = Thread.currentThread().getContextClassLoader().getResource(filePath).getPath();

        try (InputStream stream = Files.newInputStream(Path.of(fileUrl.substring(1)))) {
            properties.load(stream);
        } catch (IOException e) {
            // we should log this actually and return empty map
            e.printStackTrace();
        }

        return properties;
    }
}
