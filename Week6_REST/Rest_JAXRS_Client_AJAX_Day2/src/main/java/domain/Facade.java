/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entity.Person;
import interfaces.IPersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class Facade implements IPersonFacade {

    EntityManagerFactory emf;

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(p); //adds the person the DB
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public Person deletePerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Person getPerson(Long id) {

        EntityManager em = getEntityManager();
        //em.getTransaction().begin(); BRUGES KUN NÅR DER ÆNDRES I DATABASEN
        // em.getTransaction().commit(); BRUGES KUN NÅR DER ÆNDRES I DATABASEN

        Person person = em.find(Person.class, id);  //find returnerer objektet
        em.close();

        return person;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList();

        EntityManager em = getEntityManager();

        em.find(Person.class, persons);
        em.close();
        return persons;
    }

    @Override
    public Person editPerson(Person p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
        
        //Sørger for at der altid er en person i databasen
        Person p = new Person("Henriette", "Hansen", "45454545");
        p = facade.addPerson(p);
        System.out.println("person: " + p.getId());
        
        //Tager fat i en person fra DB ud fra givent id
        Person person = facade.getPerson(4L);
        System.out.println(person.toString());
        
        
    }
}
