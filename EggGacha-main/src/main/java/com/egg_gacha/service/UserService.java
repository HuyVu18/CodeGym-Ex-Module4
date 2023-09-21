package com.egg_gacha.service;

import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.dto.UserDTO;
import com.egg_gacha.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void save(UserDTO userDTO);

    User findByUsernameAndPassword(UserDTO userDTO);

    Optional<User> findById(UUID userId);

}
