package com.rest.client.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rest.client.domain.City;
import com.rest.client.domain.Event;
import com.rest.client.service.ApiService;
import com.rest.client.util.AppResources;
import com.rest.client.util.Session;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.jsoup.Jsoup;

/**
 *
 * @author Marko Popovic
 */
public class EventServiceImpl implements ApiService {

    List<Event> events;

    @Override
    public void showElements() {
        try {
            Client client = ClientBuilder.newClient();
            String targetUrl = prepareUrl();
            WebTarget webTarget = client.target(targetUrl);

            String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
            List<Event> events = parseJsonResult(response);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");

            for (int i = 0; i < events.size(); i++) {
                Event event = events.get(i);
                System.out.println("Dogadjaj:" + event.getName());
                System.out.println("\t Vreme odrzavanja: " + event.getDateTime().format(formatter));
                System.out.println("\t Link: " + event.getLink());
                System.out.println("\t Opis: " + event.getDescription());
                System.out.println("\t Mesto odrzavanja: " + event.getVenueName());
                System.out.println("\t Ulica: " + event.getVenueStreet());
                System.out.println("\t Organizator: " + event.getGroupName());
                System.out.println("-----------------------------------------");
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
        List<Event> events = new ArrayList<>();
        Gson gson = new GsonBuilder().create();

        JsonObject result = gson.fromJson(response, JsonObject.class);
        JsonArray array = result.getAsJsonArray("events");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");

        for (JsonElement element : array) {
            JsonObject obj = (JsonObject) element;

            String id = obj.get("id").getAsString();
            String name = obj.get("name").getAsString();

            String date = obj.get("local_date").getAsString();
            String time = obj.get("local_time").getAsString();
            String localDateTimeString = date + " " + time;
            LocalDateTime dateTime = LocalDateTime.parse(localDateTimeString, formatter);

            String link = obj.get("link").getAsString();
            String description = obj.get("description").getAsString();
            description = Jsoup.parse(description).text();
            String venueName = obj.get("venue").getAsJsonObject().get("name").getAsString();
            String venueStreet = obj.get("venue").getAsJsonObject().get("address_1").getAsString();
            String venueCity = obj.get("venue").getAsJsonObject().get("city").getAsString();
            String groupName = obj.get("group").getAsJsonObject().get("name").getAsString();

            Event event = new Event(id, name, dateTime, link, description, venueName, venueStreet, venueCity, groupName);
            events.add(event);
        }

        return events;
    }
}
