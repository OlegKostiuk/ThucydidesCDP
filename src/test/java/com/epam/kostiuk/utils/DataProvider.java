package com.epam.kostiuk.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class DataProvider {

    public static String getValue(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/data.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
