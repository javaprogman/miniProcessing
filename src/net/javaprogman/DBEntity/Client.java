package net.javaprogman.DBEntity;


//import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {

    private Integer id;
    private String name;
    private String passport;
    private Date birthdate;
    private Sex sex;
    //private List<Integer> card_id;

    public Client(Integer id, String name, String passport, Date birthdate, Sex sex) {
        this.id = id;
        this.name = name;
        this.passport = passport;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", birthdate=" + birthdate +
                ", sex=" + sex.name() +
                '}';
    }
}
