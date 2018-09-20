package com.rest.client.main;

import com.rest.client.domain.City;
import com.rest.client.injector.ApiServiceInjector;
import com.rest.client.injector.impl.CityServiceInjector;
import com.rest.client.injector.impl.EventServiceInjector;
import com.rest.client.service.ServiceConsumer;
import com.rest.client.util.Helper;
import com.rest.client.util.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marko Popovic
 */
public class Start {

    public static void main(String[] args) {
        try {
            Start.runApp();
        } catch (IOException ex) {
            System.out.println("Greska:" + ex.getMessage());
        }
    }

    public static void runApp() throws IOException {
        ApiServiceInjector injector = null;
        ServiceConsumer consumer = null;
        boolean end = false;
        int number = -1;
        
        while (!end) {
            System.out.println("Ucitavanje gradova ...");

            injector = new CityServiceInjector();
            consumer = injector.getConsumer();
            consumer.showElements();

            System.out.println("Unesite redni broj grada za prikaz dogadjaja:");
            City city = null;
            while(city == null) {
                number = Helper.readInputNumber();
                city = (City) consumer.getElementByIndex(number - 1);
                if(city == null) 
                    System.out.println("Morate uneti odgovarajuci redni broj!");
            }
            Session.getInstace().getMap().put("currentCity", city);

            injector = new EventServiceInjector();
            consumer = injector.getConsumer();
            consumer.showElements();

            System.out.println("Za kraj rada unesite -1, za prikaz svih gradova bilo koji broj:");
            number = Helper.readInputNumber();
            if (number == -1) {
                end = true;
            }
        }
        System.out.println("Kraj rada");
    }
}
