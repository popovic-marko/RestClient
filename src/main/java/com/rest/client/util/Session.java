package com.rest.client.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marko Popovic
 */
public class Session {
    private Map<String, Object> map;
    private static Session instance;
    
    private Session() {
        map = new HashMap<>();
    }
    
    public static Session getInstace() {
        if(instance == null) {
            instance = new Session();
        }
        
        return instance;
    }
    
    public Map<String, Object> getMap() {
        return map;
    }
}
