package com.rest.client.injector.impl;

import com.rest.client.injector.ApiServiceInjector;
import com.rest.client.service.ServiceConsumer;
import com.rest.client.service.impl.EventServiceImpl;
import com.rest.client.service.impl.ServiceConsumerImpl;

/**
 *
 * @author Marko Popovic
 */
public class EventServiceInjector implements ApiServiceInjector{

    @Override
    public ServiceConsumer getConsumer() {
        return new ServiceConsumerImpl(new EventServiceImpl());
    }
    
}
