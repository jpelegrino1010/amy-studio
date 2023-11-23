package com.julioluis.amystudio.repository;

import com.julioluis.amystudio.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByEmail(String email);
}
