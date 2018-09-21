package com.rest.client.util;

import com.rest.client.constants.ResourceConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marko Popovic
 */
public class AppResources {
    private final Properties properties;
    private static AppResources instance;
    
    private AppResources() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("./app.properties");
        properties.load(fis);
    }
    
    public static AppResources getInstance() throws IOException {
        if(instance == null) {
            instance = new AppResources();
        }
        
        return instance;
    }
    
    public String getCitiesUrl() {
        return properties.getProperty(ResourceConst.CITIES_URL);
    }
    
    public String getCitiesCountry() {
        return properties.getProperty(ResourceConst.CITIES_COUNTRY);
    }
    
    public String getCitiesPage() {
        return properties.getProperty(ResourceConst.CITIES_PAGE);
    }
    
    public String getCitiesOrder() {
        return properties.getProperty(ResourceConst.CITIES_ORDER);
    }
    
    public String getEventsUrl() {
        return properties.getProperty(ResourceConst.EVENTS_URL);
    }
    
    public String getEventsPage() {
        return properties.getProperty(ResourceConst.EVENTS_PAGE);
    }
    
    public String getEventsOrder() {
        return properties.getProperty(ResourceConst.EVENTS_ORDER);
    }
}
