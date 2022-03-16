package com.truecoder.spring.repository.impl;

import com.truecoder.spring.entity.User;
import com.truecoder.spring.repository.UserCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {
    @Override
    public User findByName(String input) {
        return null;
    }



    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
