package com.rest.client.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rest.client.domain.City;
import com.rest.client.service.ApiService;
import com.rest.client.util.AppResources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Marko Popovic
 */
public class CityServiceImpl implements ApiService {

    List<City> cities;

    public CityServiceImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public void showElements() {
        try {
            Client client = ClientBuilder.newClient();
            String targetUrl = prepareUrl();
            WebTarget webTarget = client.target(targetUrl);
            
            String response = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
            cities = parseJsonResult(response);
            
            for (int i = 0; i < cities.size(); i++) {
                System.out.println("\t" + (i+1) + ". " + cities.get(i).getName());
            }
        } catch (IOException ex) {
            System.out.println("Greska prilikom ucitavanja podataka iz fajla:"
                    + ex.getMessage());
        }
    }

    @Override
    public Object getElementByIndex(int index) {
        return cities.get(index);
    }

    private String prepareUrl() throws IOException {
        String citiesUrl = AppResources.getInstance().getCitiesUrl();
        String citiesCountryValue = AppResources.getInstance().getCitiesCountry();
        String citiesOrderValue = AppResources.getInstance().getCitiesOrder();
        String citiesPageValue = AppResources.getInstance().getCitiesPage();

        citiesUrl = citiesUrl.replace("${country}", citiesCountryValue);
        citiesUrl = citiesUrl.replace("${order}", citiesOrderValue);
        citiesUrl = citiesUrl.replace("${page}", citiesPageValue);

        return citiesUrl;
    }

    private List<City> parseJsonResult(String response) {
        List<City> resList = new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        
        JsonObject result = gson.fromJson(response, JsonObject.class);
        JsonArray array = result.getAsJsonArray("results");

        for (JsonElement element : array) {
            JsonObject obj = (JsonObject) element;

            int id = obj.get("id").getAsInt();
            String name = obj.get("city").getAsString();
            double lon = obj.get("lon").getAsDouble();
            double lat = obj.get("lat").getAsDouble();

            City city = new City(id, name, lon, lat);
            resList.add(city);
        }
        
        return resList;
    }
}
