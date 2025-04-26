package main.service;

import main.model.Person;

import java.util.List;

public interface UserService {

    List<Person> findAllPersons();

    Person findPersonById(Long id);

    void savePerson(Person person);

    void deletePerson(Long id);
}
