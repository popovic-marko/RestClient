package com.rest.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Marko Popovic
 */
public class Helper {
    public static int readInputNumber() {
        BufferedReader in = InputReader.getInstance().getReader();
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
