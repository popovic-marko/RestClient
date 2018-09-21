package com.rest.client.service;

/**
 *
 * @author Marko Popovic
 */
public interface ServiceConsumer {
    boolean showElements();
    
    Object getElementByIndex(int index);
}
