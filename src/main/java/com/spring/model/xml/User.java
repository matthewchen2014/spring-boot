package com.spring.model.xml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

@XmlType(propOrder = {"age", "userName", "role", "birthDay"})
@XmlRootElement(name = "user", namespace = "http://www.w3school.com")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class User implements Serializable{
    private String userName;
    private int age;
    private String role;
    private String bibi;

    private LocalDate birthDay;

    public User() {
    }

    public User(String userName, int age, String role, String bibi, LocalDate birthDay) {
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.bibi = bibi;
        this.birthDay = birthDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlAttribute
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", bibi='" + bibi + '\'' +
                ", birthday=" + birthDay + "\'" +
                '}';
    }
}
