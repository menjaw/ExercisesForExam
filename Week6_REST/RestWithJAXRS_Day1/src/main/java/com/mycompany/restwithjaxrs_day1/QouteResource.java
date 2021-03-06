/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restwithjaxrs_day1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Menja
 */
@Path("quote")//overordnet resource
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
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/id/{id}")//tuborg-paranteser fortæller REST at id er en variabel
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(@PathParam("id") int id) {
        //Get the qoute by Id
        return quotes.get(id);
    }

    /**
     * THIS METHOD RETURNS A RANDOM QUOTE
     *
     * Retrieves representation of an instance of
     * com.mycompany.restwithjaxrs_day1.QouteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/random")
    @Produces(MediaType.TEXT_HTML)
    public String getRandom() {
        Random random = new Random();
        //Get a random qoute 
        int id = random.nextInt(quotes.size()) + 1;
        return quotes.get(id);
    }

    /**
     *
     *
     * @param quote
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public String postHtml(String quote) {
        //Den modtagende streng konverteres til et JSON Objekt
        JsonParser jParser = new JsonParser();
        JsonObject jOb = jParser.parse(quote).getAsJsonObject();
        String quoteValue = jOb.get("quote").getAsString();

        //Opretter et nyt id ud fra map-size og ligger 1 til det sidste element
        int id = quotes.size() + 1;
        //Tilføjer quote til map
        quotes.put(id, quoteValue);

        JsonObject result = new JsonObject();
        result.addProperty("id", id);
        result.addProperty("quote", quoteValue);
        return gson.toJson(result);

    }

    /**
     * PUT method for updating or creating an instance of QouteResource
     *
     * @param id
     * @param content representation for the resource
     */
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(@PathParam("id") int id, String content) {
        System.out.println("Test");
    }
}
