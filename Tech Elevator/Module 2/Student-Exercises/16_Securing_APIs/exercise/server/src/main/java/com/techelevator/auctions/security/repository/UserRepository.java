package com.techelevator.auctions.security.repository;

import com.techelevator.auctions.security.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);

}
