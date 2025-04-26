package main.dao;

import main.model.Person;

import java.util.List;

public interface UserRepository {

    List<Person> findAllPersons();

    Person findPersonById(Long id);

    void savePerson(Person person);

    void deletePerson(Long id);
}
