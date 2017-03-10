package utility;

import com.google.gson.Gson;
import entity.Person;
import java.util.List;

/**
 *
 * @author menja
 */
public class JSONConverter {

    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    public Person getPersonFromJson(String js) {
        //String som kommer ind laves om til en Person
        return gson.fromJson(js, Person.class);

    }

    public String getJSONFromPerson(Person p) {
        //Person laves om til  en Json String
        return gson.toJson(p);

    }

    public String getJSONFromPerson(List<Person> persons) {

        return gson.toJson(persons);
    }

}
