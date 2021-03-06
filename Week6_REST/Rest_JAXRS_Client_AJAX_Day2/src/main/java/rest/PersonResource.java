/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Facade;
import entity.Person;
import interfaces.IPersonFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Menja
 */
@Path("person")
public class PersonResource {

    private IPersonFacade facade = new Facade();
    private JSONConverter jsonConverter = new JSONConverter();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
    }

    /**
     * Recieve a List from Java and convert it to JSON
     *
     * @return a String whit all the persons
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)//MediaType = Den type "tekst" som returneres
    public String getPersons() {
        //tager fat i java-listen af personer som sendes fra facaden
        List<Person> persons = facade.getPersons();
        //Konverterer Java-listen om til json
        return jsonConverter.getJSONFromPerson(persons);
    }

    /**
     * Recieves an int as id
     *
     * @param id
     * @return a String with a person from a given id
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)//MediaType = Den type "tekst" som returneres
    public String getPerson(@PathParam("id") Long id) {
        //Tager fat i Java-personen ud fra det givne id
        Person person = facade.getPerson(id);
        //Konverter Java-personen til JSON
        return jsonConverter.getJSONFromPerson(person);
    }

    /***
     * Delete a person from the database 
     * @param id
     * @return 
     */

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)//Returnerer en String med beskeden om at person er slettet
    public String deletePerson(@PathParam("id") Long id) {
        facade.deletePerson(id);
        return "Person is deleted: " + id;
    }

    /***
     * Add a new person to the database
     * @param jsonString
     * @return 
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPerson(String jsonString) {
        
        //Konverter JSON til Java-personen 
        Person person = jsonConverter.getPersonFromJson(jsonString);
        //Tilføjer personen til databsen
        facade.addPerson(person);
        return jsonString;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(String jsonString){
        //Modtager og gemmer et Json-objekt som skal konverteres om til java
        //Først vil jeg have fat i editPerson-metoden fra facaden og derfter konvertere den modtagende jsonString om til en Java-person
        Person person = facade.editPerson(jsonConverter.getPersonFromJson(jsonString));
        
        //Konvertere java-Person om til JsonObjekt og returner
        return jsonConverter.getJSONFromPerson(person);        
    }
}
