package com.rest.client.injector;

import com.rest.client.service.ServiceConsumer;
import com.rest.client.service.impl.CityServiceImpl;
import com.rest.client.service.impl.ServiceConsumerImpl;

/**
 *
 * @author Marko Popovic
 */
public class CityServiceInjector implements ApiServiceInjector{

    @Override
    public ServiceConsumer getConsumer() {
        return new ServiceConsumerImpl(new CityServiceImpl());
    }
    
}
