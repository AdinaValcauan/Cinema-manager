package bll;

import java.util.ArrayList;
import java.util.List;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.PersonDAO;
import model.Person;

public class PersonBLL {
    private List<Validator<Person>> validators;

    public PersonBLL() {
        validators = new ArrayList<Validator<Person>>();
        validators.add(new EmailValidator());
    }

    /*public Person findPersonById(int id) {
        Person person = Person.findById(id);
        if (person == null) {
            throw new NoSuchElementException("The person with id =" + id + " was not found!");
        }
        return person;
    }*/

    public int insertStudent(Person person) {
        for (Validator<Person> v : validators) {
            v.validate(person);
        }
        return PersonDAO.insert(person);
    }
}
