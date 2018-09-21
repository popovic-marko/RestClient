package com.rest.client.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Marko Popovic
 */
public class InputReader {
    private final BufferedReader in;
    private static InputReader instance;
    
    private InputReader() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static InputReader getInstance() {
        if(instance == null) {
            instance = new InputReader();
        }
        
        return instance;
    }
    
    public BufferedReader getReader() {
        return in;
    }
}
