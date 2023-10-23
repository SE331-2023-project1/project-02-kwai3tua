package com.se331.kwai3tua.security.user;

public interface UserDao {
    User findByUsername(String username);
    User save(User user);
    User getUser(Long id);
}