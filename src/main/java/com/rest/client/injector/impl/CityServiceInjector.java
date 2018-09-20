package com.rest.client.injector.impl;

import com.rest.client.injector.ApiServiceInjector;
import com.rest.client.service.ServiceConsumer;
import com.rest.client.service.impl.CityServiceImpl;
import com.rest.client.service.impl.ServiceConsumerImpl;
import java.util.ArrayList;

/**
 *
 * @author Marko Popovic
 */
public class CityServiceInjector implements ApiServiceInjector{

    @Override
    public ServiceConsumer getConsumer() {
        return new ServiceConsumerImpl(new CityServiceImpl(new ArrayList()));
    }
    
}
