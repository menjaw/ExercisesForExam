/*
 * This class only drop and create the database
 */
package test;

import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class SchemaBuilder{
    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
    }
}
