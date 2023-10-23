package com.se331.kwai3tua.security.user;

import jakarta.transaction.Transactional;

public interface UserService {
    User save(User user);
    User getUser(Long id);
    @Transactional
    User findByUsername(String username);
}