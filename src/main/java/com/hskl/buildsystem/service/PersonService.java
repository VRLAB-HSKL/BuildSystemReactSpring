package com.hskl.buildsystem.service;


import com.hskl.buildsystem.data.person.Person;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SequenceGeneratorService seqService;

    List<Person> personList;

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

    @GetMapping("/api/persons/createpersons")
    public void createPersons() {
        initPersons();
    }

    @GetMapping("/api/persons/getallpersons")
    public List<Person> getPersons() {
        return  personList;
    }
}
