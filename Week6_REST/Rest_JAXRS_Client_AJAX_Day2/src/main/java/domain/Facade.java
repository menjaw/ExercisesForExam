/*
*This class obtain all the methods that a used in the PersonResource Class
*It is the layer between the Database and the REST
 */
package domain;

import entity.Person;
import interfaces.IPersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
        EntityManager em = getEntityManager();

        //Opretter hvilken metode som vil benyttes til den kommende handling
        TypedQuery<Person> result = em.createNamedQuery("Person.findById", Person.class); //("Name på query som benyttes", hvilken class man referer til)
        //Tager fat i den enkelte person
        Person person = result.setParameter("id", id).getSingleResult();

        //Udfører handlingen - fjerner personen og committer til databasen - 
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
        em.close();

        return person;
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

        EntityManager em = getEntityManager();
        TypedQuery<Person> result = em.createNamedQuery("Person.findAll", Person.class);//returnerer hele listen med personer
        List<Person> persons = result.getResultList();
        return persons;
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = getEntityManager();

        TypedQuery<Person> result = em.createNamedQuery("Person.findById", Person.class);
        Person personToUpdate = result.setParameter("id", p.getId()).getSingleResult();

        //Udfør ændringerne i databasen
        em.getTransaction().begin();
        //Tag fat i personToUpdate-variablen og set de forskellige værdier
        personToUpdate.setFName(p.getFName());
        personToUpdate.setLName(p.getLName());
        personToUpdate.setPhone(p.getPhone());
        em.getTransaction().commit();
        em.close();

        //Returner den opdateret person
        return personToUpdate;
    }

//
//    public static void main(String[] args) {
//
//        Facade facade = new Facade();
//        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("PU"));
//        
//        //Sørger for at der altid er en person i databasen
//        Person p = new Person("Henriette", "Hansen", "45454545");
//        p = facade.addPerson(p);
//        System.out.println("person: " + p.getId());
//        
//        //Tager fat i en person fra DB ud fra givent id
//        Person person = facade.getPerson(4L);
//        System.out.println(person.toString());
//        
//        
//    }
}
