package main.service;

import main.dao.UserRepository;
import main.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Person> findAllPersons() {
        return userRepository.findAllPersons();
    }

    @Override
    public Person findPersonById(Long id) {
        return userRepository.findPersonById(id);
    }

    @Override
    public void savePerson(Person person) {
        userRepository.savePerson(person);
    }

    @Override
    public void deletePerson(Long id) {
        userRepository.deletePerson(id);
    }
}
