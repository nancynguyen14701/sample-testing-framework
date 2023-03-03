package com.itgirls.FW.common.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * This class contains configuration data loading from systems as well as the .properties file
 * It also provides several methods to work with config data
 */
public class ConfigUtil {

    public static final String DIR_PATH = System.getProperty("user.dir");
    public static final String BROWSER_NAME = System.getProperty("browser").toUpperCase();
    private static String propertiesFilePath = "/src/test/resources/testdata/testsettings.properties";
    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;


    public static void loadPropertiesFile() {
        properties = new Properties();
        try {
            fileIn = new FileInputStream(DIR_PATH + propertiesFilePath);
            properties.load(fileIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertiesValue(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public static void setPropertiesValue(String propertyKey, String propertyValue) {
        try {
            fileOut = new FileOutputStream(DIR_PATH + propertiesFilePath);
            properties.setProperty(propertyKey, propertyValue);
            properties.store(fileOut, "Set new value in properties file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
