package com.techelevator.reservations.security.repository;

import com.techelevator.reservations.security.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

}
