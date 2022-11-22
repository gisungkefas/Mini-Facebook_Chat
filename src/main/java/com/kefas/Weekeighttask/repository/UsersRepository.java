package com.kefas.Weekeighttask.repository;


import com.kefas.Weekeighttask.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByEmail(String email);
    Users findByEmailAndPassword(String username, String password);
}
