package com.hskl.buildsystem.service;


import com.hskl.buildsystem.data.person.Person;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the REST interfaces for the later registration service.
 * The rest of the interfaces currently only return predefined people,
 * and there is currently no communication with the database
 */
@RestController
public class PersonService {

    //sequence service for mongodb
    @Autowired
    SequenceGeneratorService seqService;

    //contains all test persons
    List<Person> personList;

    /**
     * init test persons
     */
    private void initPersons() {
        personList = new ArrayList<Person>();
        Person a = new Person();
        a.setId(seqService.generateSequence(Person.SEQUENCE_NAME));
        a.setFirstName("Harald");
        a.setLastName("Horn");
        a.setAge(47);

        Person b = new Person();
        b.setId(seqService.generateSequence(Person.SEQUENCE_NAME));
        b.setFirstName("Mali");
        b.setLastName("Bu");
        b.setAge(36);

        Person c = new Person();
        c.setId(seqService.generateSequence(Person.SEQUENCE_NAME));
        c.setFirstName("captain");
        c.setLastName("morgan");
        c.setAge(21);

        personList.add(a);
        personList.add(b);
        personList.add(c);

    }

    /**
     * creates hard codes persons for testing
     */
    @GetMapping("/api/persons/createpersons")
    public void createPersons() {
        initPersons();
    }

    /**
     * return a list with all test persons. No data stored in monog db yet.
     * @return List with all Persons.
     */
    @GetMapping("/api/persons/getallpersons")
    public List<Person> getPersons() {
        return  personList;
    }
}
