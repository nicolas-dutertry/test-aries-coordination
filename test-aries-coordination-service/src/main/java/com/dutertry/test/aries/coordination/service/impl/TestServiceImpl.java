package com.dutertry.test.aries.coordination.service.impl;

import com.dutertry.test.aries.coordination.entities.Person;
import com.dutertry.test.aries.coordination.service.TestService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ndutertry
 */
public class TestServiceImpl implements TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);
    
    private TestRepository testRepository;

    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void create(Person person) {
        try {
            testRepository.get(person.getLastName());
            return;
        } catch(PersonNotFoundException e) {
            LOGGER.info("Person not found");
        }
        
        testRepository.create(person);
    }

    @Override
    public List<Person> list() {
        return testRepository.list();
    }
    
    @Override
    public void delete(String... names) {
        testRepository.delete(names);
    }
    
}
