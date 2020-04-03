package controller;

import dao.PersonImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Person;

@Named(value = "basic")
@SessionScoped
public class Basic implements Serializable {

    List persons = null;
    final Person model = new model.Person();
    final PersonImpl dao = new dao.PersonImpl();

    public Basic() {
    }

    public List<Person> getPersons() {
        persons = new ArrayList();
        persons.add(new Person(1, "Jhordy Miguel", "Caceres", "Guerra", "M", new Date("07/21/2001"), "73931453"));
//        if (persons == null) {
//            persons = dao.all();
//        }
        return persons;
    }
}
