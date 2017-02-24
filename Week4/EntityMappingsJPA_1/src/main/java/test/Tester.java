/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Customer;
import enums.CustomerType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class Tester {

    public static void main(String[] args) {
        runMethod();

    }

    //METHODS
    public static void runMethod() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Insert a new customer with a type
        try {
            entityManager.getTransaction().begin();
            
            //Opretter ny customer og tilføjer en customerType
            Customer customer = new Customer("Laust", "Thomsen");
            customer.setCustomerType(CustomerType.RUSTY);
            
            //
            entityManager.persist(customer);
            
            //Hobbies
            customer.addHobby("Gå ud foran busser");
            customer.addHobby("Gå ud foran toge");
            customer.addHobby("Gå ud foran lastbiler");
            customer.addHobby("Gå ud foran damptrumler");
            
            //Phones
            customer.addPhone("23456789", "Det her er en beskrivelse til et telefonnummer");
            
            

            //indsæt i databasen
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

        //Provide the customer with hobbies
       
    }
}
