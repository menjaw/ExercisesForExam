/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restwithjaxrs_day1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Menja
 */
@Path("quote")
public class QouteResource {

    //Creates the gson object
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //Data hold on the server
    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angles");
            put(2, "Do not take life so seriously. You will never get out of it alive");
            put(3, "Behind every great Man, is a woman rolling her eyes");
        }
    };

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public QouteResource() {
    }

    /**
     * THIS METHOD RETURNS A QUOTE BY A GIVEN ID
     *
     * Retrieves representation of an instance of
     * com.mycompany.restwithjaxrs_day1.QouteResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getHtml() {
//        //Get the qoute by Id
//        return quotes.get(2);
//    }
    /**
     * THIS METHOD RETURNS A RANDOM QUOTE
     *
     * Retrieves representation of an instance of
     * com.mycompany.restwithjaxrs_day1.QouteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        Random random = new Random(quotes.hashCode());
    
        
        //Get a random qoute 
        return random.toString();
    }

    /**
     * PUT method for updating or creating an instance of QouteResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
