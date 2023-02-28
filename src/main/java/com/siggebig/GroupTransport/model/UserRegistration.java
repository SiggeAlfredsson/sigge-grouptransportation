package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime addedToGroupAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("registrations")
    private User user;

    @ManyToOne
    @JoinColumn(name="group_id")
    @JsonIgnoreProperties("registrations")
    private Group group;


}
