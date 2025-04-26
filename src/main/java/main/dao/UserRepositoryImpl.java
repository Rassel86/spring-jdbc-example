package main.dao;

import main.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAllPersons() {

        return jdbcTemplate.query("select * from users_training", new PersonRowMapper());
    }

    @Override
    public Person findPersonById(Long id) {
        String sql = "select * from users_training where id = ?";
        return jdbcTemplate.queryForObject(sql, new PersonRowMapper(), new Object[]{id});
    }

    @Override
    public void savePerson(Person person) {
        if(person.getId() != null) {
            String update = "update users_training set name = ?, email = ? where id = ?";
            Object[] args = {person.getName(), person.getEmail(), person.getId()};
            jdbcTemplate.update(update, args);
        } else {
            String insert = "insert into users_training (name, email) values (?, ?)";
            jdbcTemplate.update(insert, person.getName(), person.getEmail());
        }
    }

    @Override
    public void deletePerson(Long id) {
        String sql = "delete from users_training where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
