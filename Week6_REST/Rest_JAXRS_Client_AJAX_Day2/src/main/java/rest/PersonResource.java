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

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)//Returnerer en String med beskeden om at person er slettet
    public String deletePerson(@PathParam("id") Long id) {
        facade.deletePerson(id);
        return "Person is deleted: " + id;
    }
}
