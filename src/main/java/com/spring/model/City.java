package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "city")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name="name")
    private String name;

    @Column(nullable = false, name="state")
    private String state;
}
