package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class ConfReader {
    private static Properties properties;

    static {
        try {
            String confPATH = "conf.properties";
            FileInputStream confInput = new FileInputStream(confPATH);
            properties = new Properties();
            properties.load(confInput);
            confInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConf(String keyName) {
        String val = properties.getProperty(keyName);
        return val;
    }
}
