package com.egg_gacha.service;

import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.model.User;

import java.util.UUID;

public interface GachaService {

    PetDTO getRandomPetDto();

    User updateGacha(UUID id, PetDTO petDTO);
}
