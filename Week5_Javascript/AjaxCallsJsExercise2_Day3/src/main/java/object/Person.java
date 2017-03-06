/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Menja
 */
public class Person {

    private String firstname;

    //constructors
    public Person() {
    }

    public Person(String firstname) {
        this.firstname = firstname;
    }

    //getters and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}
