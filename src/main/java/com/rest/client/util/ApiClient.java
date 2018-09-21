package com.rest.client.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author Marko Popovic
 */
public class ApiClient {
    private final Client client;
    private static ApiClient instance;

    private ApiClient() {
        client = ClientBuilder.newClient();
    }
    
    public static ApiClient getInstance() {
        if(instance == null) {
            instance = new ApiClient();
        }
        
        return instance;
    }
    
    public Client getClient() {
        return client;
    }
}
