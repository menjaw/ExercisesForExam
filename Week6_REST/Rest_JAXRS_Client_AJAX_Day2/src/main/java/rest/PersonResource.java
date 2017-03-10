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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        //tager fat i java-listen af personer som sendes fra facaden
        List<Person> persons = facade.getPersons();

        return jsonConverter.getJSONFromPerson(persons);

    }
}
