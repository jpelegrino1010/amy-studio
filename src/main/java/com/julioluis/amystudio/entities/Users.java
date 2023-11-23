package com.julioluis.amystudio.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;


@Entity
@Data
@Table(name = "user")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    @JoinColumn(name = "rol_id")
    @ManyToOne
    private Rol rol;


}
