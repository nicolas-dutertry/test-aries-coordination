package com.dutertry.test.aries.coordination.service.impl;

import com.dutertry.test.aries.coordination.entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author ndutertry
 */
public class TestRepository {
    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;

    @Transactional
    public void create(Person person) {
        entityManager.persist(person);
    }

    public Person get(String name) throws PersonNotFoundException {
        Person person = entityManager.find(Person.class, name);
        if(person == null) {
            throw new PersonNotFoundException();
        }
        return person;
    }
    
    public List<Person> list() {
        TypedQuery<Person> query = entityManager.createQuery(
            "select p from Person p order by p.lastName",
            Person.class);
        
        return new ArrayList<>(query.getResultList());
    }
    
    @Transactional
    public void delete(String... names) {
        for (String name : names) {
            Person person = entityManager.find(Person.class, name);
            entityManager.remove(person);
        }
    }
}
