package com.egg_gacha.service.impl;

import com.egg_gacha.converter.Converter;
import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.dto.UserDTO;
import com.egg_gacha.model.User;
import com.egg_gacha.repository.UserRepository;
import com.egg_gacha.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Converter<User,UserDTO> userDTOConverter;

    public UserServiceImpl(UserRepository userRepository, Converter<User, UserDTO> userDTOConverter) {
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = userDTOConverter.convert(userDTO);
        userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(UserDTO userDTO) {
        return userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

}
