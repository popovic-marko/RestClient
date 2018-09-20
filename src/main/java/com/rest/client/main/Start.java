package com.rest.client.main;

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
        
        boolean end = false;
        
        while(!end) {
            System.out.println("Ucitavanje gradova ...");
            //showCities();
            System.out.println("Unesite redni broj grada za prikaz (za kraj rada unesite -1):");
            int number = Start.readInputNumber();
            if(number == -1) {
                end = true;
            } else {
                // City city = getObjectByKey(number);
                // showEvents(city.getLon, city.getLat);
                number = Start.readInputNumber();
                if(number == -1) {
                    end = true;
                }
            }
        }
        System.out.println("Kraj rada");
    }
    
    public static int readInputNumber() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number = -1;
        boolean validNumber = false;
        while(!validNumber) {
            try {
                System.out.println("Vas unos:");
                String input = in.readLine();
                number = Integer.parseInt(input);
                validNumber = true;
            } catch(NumberFormatException nfe) {
                System.out.println("Morate uneti broj!");
            } catch (IOException ex) {
                System.out.println("Greska prilikom unosa!");
            }
        }

        return number;
    }
}
