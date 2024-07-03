package com.cliet_tableaux.api.users.services;

import com.cliet_tableaux.api.users.dtos.UserDto;
import com.cliet_tableaux.api.users.entities.UserEntity;
import com.cliet_tableaux.api.users.mappers.UserMapper;
import com.cliet_tableaux.api.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    @Lazy
    AuthenticationManager authManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto signUpUser(UserDto userDto) throws Exception {
        UserEntity userEntity = userMapper.userDtoToEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        UserEntity savedUser = userRepository.save(userEntity);

        if (savedUser.getId() != null) {
            return userMapper.userEntityToDto(savedUser);
        } else {
            throw new Exception("Prolème avec l'authentitification");
        }
    }

    public UserDto loginUser(UserDto userDto) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

        UserEntity user = (UserEntity) loadUserByUsername(userDto.getUsername());

        return userMapper.userEntityToDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }
}
