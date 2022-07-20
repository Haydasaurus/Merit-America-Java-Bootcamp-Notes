package com.techelevator.security.repository;

import com.techelevator.security.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

}
