package model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Human extends AbstactEntity {
    private String firstName;
    private String lastName;
    private String middleNames;
    private String login;
    private String password;
    private Integer age;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.REMOVE)
    private Set<Message> messages;

    public Human(String firstName, String lastName, String middleNames, String login, String password, Integer age, Set<Message> messages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleNames = middleNames;
        this.login = login;
        this.password = password;
        this.age = age;
        this.messages = messages;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
