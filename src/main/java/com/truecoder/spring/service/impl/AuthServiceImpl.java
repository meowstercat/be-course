package com.truecoder.spring.service.impl;

import com.truecoder.spring.dic.RoleEnum;
import com.truecoder.spring.entity.Role;
import com.truecoder.spring.entity.User;
import com.truecoder.spring.pojo.RoleTypeDTO;
import com.truecoder.spring.repository.RoleRepository;
import com.truecoder.spring.repository.UserRepository;
import com.truecoder.spring.security.jwt.JwtUtils;
import com.truecoder.spring.security.payload.request.LoginRequest;
import com.truecoder.spring.security.payload.request.SignUpRequest;
import com.truecoder.spring.security.payload.response.JwtResponse;
import com.truecoder.spring.security.payload.response.MessageResponse;
import com.truecoder.spring.security.service.UserDetailsImpl;
import com.truecoder.spring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
               userDetails.getId(),
                userDetails.getEmail(),
                userDetails.getUsername(),
                roles);
    }

    @Override
    public MessageResponse register(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        String strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles != null) {
            if (!hasRole(strRoles)) {
                return new MessageResponse("Error: Role is not found.");
            }
            switch (strRoles) {
                case "ROLE_TEACHER": {
                    Role teacherRole = roleRepository.findByName(RoleEnum.ROLE_TEACHER).get();
                    roles.add(teacherRole);
                }
                case "ROLE_ADMIN": {
                    Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN).get();
                    roles.add(adminRole);
                }
            }
        } else {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_STUDENT).get();
            roles.add(userRole);
        }

        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponse("User registered successfully!");
    }

    private boolean hasRole(String strRoles) {
        boolean isHasRole = false;
        List<RoleTypeDTO> listRole = RoleEnum.getAllRoleEnum();
        for (RoleTypeDTO roleDTO : listRole) {
            if (roleDTO.getRoleName().equals(strRoles)) {
                isHasRole = true;
                break;
            }
        }
        return isHasRole;
    }
}
