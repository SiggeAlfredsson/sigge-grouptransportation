package com.siggebig.GroupTransport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "groups")
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;


    @OneToMany(mappedBy = "group")
    @JsonIgnoreProperties("group")
    Set<UserRegistration> registrations;

    @OneToMany(mappedBy = "group")
    @JsonIgnoreProperties("group")
    Set<RouteRegistration> registrations2;





}
