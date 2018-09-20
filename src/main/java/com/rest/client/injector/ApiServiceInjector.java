package com.rest.client.injector;

import com.rest.client.service.ServiceConsumer;

/**
 *
 * @author Marko Popovic
 */
public interface ApiServiceInjector {
    ServiceConsumer getConsumer();
}
