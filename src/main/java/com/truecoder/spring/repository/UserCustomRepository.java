package com.truecoder.spring.repository;

import com.truecoder.spring.entity.User;

import java.util.Optional;

public interface UserCustomRepository{
    User findByName(String input);

    boolean existsByEmail(String email);
}
