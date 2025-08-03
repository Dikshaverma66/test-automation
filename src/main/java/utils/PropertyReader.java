package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String readKey(String key) {
        FileInputStream file = null;
        Properties prop = null;

        try{
            file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        assert prop != null;
        return prop.getProperty(key);
    }
}
