package com.hskl.buildsystem.data.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB Persons Schema
 */
@Document(collection = "Persons")
public class Person {

    //person_sequence
    @Transient
    public static final String SEQUENCE_NAME = "person_sequence";

    // mongodb id
    @Id
    private long id;

    //firstname
    private String firstName;

    //lastname
    private String lastName;

    //age
    private int age;

    /**
     * ctor
     */
    public Person() {

    }

    /**
     * get id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * set id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get firstname
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get lastname
     * @return lastNames
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *  set lastname
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * set age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * toString()
     * @return
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
