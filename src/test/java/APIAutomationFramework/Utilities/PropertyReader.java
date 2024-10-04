package APIAutomationFramework.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public String getValue(String key) throws IOException {

        String filename = "src/test/java/APIAutomationFramework/Resourses/KeyValues.properties";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(filename);
        properties.load(fileInputStream);

        return properties.getProperty(key);
    }
}
