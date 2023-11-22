package com.julioluis.amystudio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String rolName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    @OneToMany(mappedBy = "rol")
    private List<User> users;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "rol_auth",
            joinColumns = @JoinColumn(name = "rol_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"
                    ,referencedColumnName = "id"))
    private List<Authority> authorities;


}
