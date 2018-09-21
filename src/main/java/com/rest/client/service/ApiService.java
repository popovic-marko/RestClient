package com.rest.client.service;

/**
 *
 * @author Marko Popovic
 */
public interface ApiService {
    
    boolean showElements();
    
    Object getElementByIndex(int index);
}
