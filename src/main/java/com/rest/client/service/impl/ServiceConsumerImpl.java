package com.rest.client.service.impl;

import com.rest.client.service.ApiService;
import com.rest.client.service.ServiceConsumer;

/**
 *
 * @author user
 */
public class ServiceConsumerImpl implements ServiceConsumer{
    ApiService service;

    public ServiceConsumerImpl(ApiService service) {
        this.service = service;
    }
    
    @Override
    public void showElements() {
        this.service.showElements();
    }

    @Override
    public Object getElementByIndex(int index) {
        return this.service.getElementByIndex(index);
    }
    
}
