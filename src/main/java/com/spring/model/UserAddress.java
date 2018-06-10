package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="user_address")
@Getter
@Setter
@Accessors(chain = true)
public class UserAddress {
    @EmbeddedId
    private CompositeKey compositeKey;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="id", referencedColumnName = "id")
    @MapsId("id")
    private User user;

    @Column(name="address")
    private String address;

    @Embeddable
    @Getter
    @Setter
    public static class CompositeKey implements Serializable{
        @Column(name="id")
        private Integer id;
        @Column(name="seq")
        private Integer seq;
    }
}
