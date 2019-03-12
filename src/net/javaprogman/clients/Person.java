package net.javaprogman.clients;

import java.util.Date;

public abstract class Person {


    private String name;
    private String passport;
    private Date birthdate;
    private Sex sex;


    Person(String Name, Date birthdate, Sex sex, String passport) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Sex getSex() {
        return sex;
    }

    public String getPassport() {
        return passport;
    }
}
