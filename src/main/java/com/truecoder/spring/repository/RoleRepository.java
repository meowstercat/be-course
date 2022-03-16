package com.truecoder.spring.repository;

import com.truecoder.spring.dic.RoleEnum;
import com.truecoder.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleEnum name);
}
