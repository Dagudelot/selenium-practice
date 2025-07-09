package utils;

import java.util.Properties;

public class ConfigReader {

    protected static Properties properties;

    static {
        properties = new Properties();
        String env = System.getProperty("env", "qa"); // Default to 'qa' if not specified
        String envFilePath = String.format("config.%s.properties", env);
        System.out.println("Loading configuration from: " + envFilePath);
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream(envFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties");
        }
    }

    public static String get(String key, String defaultValue){
        return properties.getProperty(key, defaultValue); // Returns an empty string if the key is not found
    }

    public static Long getLong(String key, String defaultValue){
        return Long.valueOf(properties.getProperty(key, defaultValue)); // Returns an empty string if the key is not found
    }

    public static boolean getBoolean(String remote, boolean b) {
        return Boolean.parseBoolean(properties.getProperty(remote, String.valueOf(b))); // Returns false if the key is not found or if the value is not a valid boolean
    }
}
