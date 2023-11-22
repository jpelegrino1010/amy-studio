package com.julioluis.amystudio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authorities")
@Data
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String authName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    @ManyToMany(mappedBy = "authorities")
    private List<Rol> roles;


}
