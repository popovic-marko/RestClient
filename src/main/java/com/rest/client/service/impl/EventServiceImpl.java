package com.rest.client.service.impl;

import com.rest.client.domain.City;
import com.rest.client.domain.Event;
import com.rest.client.service.ApiService;
import com.rest.client.util.AppResources;
import com.rest.client.util.Session;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Marko Popovic
 */
public class EventServiceImpl implements ApiService{
    List<Event> events;
    
    @Override
    public void showElements() {
        try {
            Client client = ClientBuilder.newClient();
            String targetUrl = prepareUrl();
            WebTarget webTarget = client.target(targetUrl);
            
            String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
            List<Event> events = parseJsonResult(response);
            
            for (int i = 0; i < events.size(); i++) {
                System.out.println("\t" + i + 1 + ". " + events.get(i).getName());
            }
        } catch (IOException ex) {
            System.out.println("Greska prilikom ucitavanja podataka iz fajla:"
                    + ex.getMessage());
        }
    }

    @Override
    public Object getElementByIndex(int index) {
        return events.get(index);
    }
    
    private String prepareUrl() throws IOException {
        String eventsUrl = AppResources.getInstance().getEventsUrl();
        String eventsOrderValue = AppResources.getInstance().getEventsOrder();
        String eventsPageValue = AppResources.getInstance().getEventsPage();
        
        City city = (City) Session.getInstace().getMap().get("currentCity");
        String lon = String.valueOf(city.getLon());
        String lat = String.valueOf(city.getLat());
        
        eventsUrl = eventsUrl.replace("${order}", eventsOrderValue);
        eventsUrl = eventsUrl.replace("${page}", eventsPageValue);
        eventsUrl = eventsUrl.replace("${lon}", lon);
        eventsUrl = eventsUrl.replace("${lat}", lat);

        return eventsUrl;
    }
    
    private List<Event> parseJsonResult(String response) {
        // TO DO 
        return null;
    }
}
