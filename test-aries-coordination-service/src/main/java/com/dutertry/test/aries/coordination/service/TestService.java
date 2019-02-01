package com.dutertry.test.aries.coordination.service;

import com.dutertry.test.aries.coordination.entities.Person;
import java.util.List;

/**
 *
 * @author ndutertry
 */
public interface TestService {    
    List<Person> list();
    void create(Person person);
    void delete(String... names);
}
