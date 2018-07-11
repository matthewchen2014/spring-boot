package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "user_ext_info")
@Getter
@Setter
@Accessors(chain = true)
public class UserExtInfo {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonIgnore
    @MapsId
    private User user;

    @Column(name = "identifier")
    private String identifier;
}
