package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public static String getProperty(String filename, String key) {
        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(filename);
            if (input == null) {
                System.out.println("Unable to find " + filename);
                return "";
            }

            // load a properties file
            properties.load(input);

            // get the property value and print it out
            return properties.getProperty("URL", "");

        } catch (IOException io) {
            io.getStackTrace();
        }
        return "";
    }

    public static Map<String, String> getAllProperties(String filename) {
        Properties properties = new Properties();
        InputStream input = null;
        Map<String, String> data = new HashMap<>();

        try {
            input = new FileInputStream(filename);
            if (input == null) {
                System.out.println("Unable to find " + filename);
                return null;
            }

            // load a properties file
            properties.load(input);

            // get the property value and print it out
            Enumeration<?> e = properties.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                // System.out.println("Key: " + key + ", Value: " + value);

                data.put(key, value);
            }
            return data;
        } catch (IOException io) {
            io.getStackTrace();
        }
        return null;
    }

  	/* -----------------------------------------------------
    For testing purpose
	----------------------------------------------------- */

    public static void main(String[] args) {
//        final String CONFIG_FILENAME = "src/main/java/com/thomas/config/config.properties";
//        String value = getProperty(CONFIG_FILENAME, "URL");
//        System.out.println(value);

//        Map<String, String> data = getAllProperties(CONFIG_FILENAME);
//        for (Map.Entry<String, String> entry : data.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
    }
}
