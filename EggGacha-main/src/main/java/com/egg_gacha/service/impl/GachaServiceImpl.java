package com.egg_gacha.service.impl;

import com.egg_gacha.converter.Converter;
import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.model.OwnedPet;
import com.egg_gacha.model.Pet;
import com.egg_gacha.model.User;
import com.egg_gacha.repository.PetRepository;
import com.egg_gacha.repository.UserRepository;
import com.egg_gacha.service.GachaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class GachaServiceImpl implements GachaService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;
    private final Converter<Pet, PetDTO> converter;
    private List<Pet> pets = new ArrayList<>();

    public GachaServiceImpl(PetRepository petRepository, UserRepository userRepository, Converter<Pet, PetDTO> converter) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public PetDTO getRandomPetDto() {
        if (pets.size()==0){
            pets = petRepository.findAll();
        }
        Pet pet = pets.get(new Random().nextInt(pets.size()));
        return converter.reverse(pet);
    }

    @Override
    public User updateGacha(UUID userId, PetDTO petDTO) {
        User user = userRepository.findById(userId).orElse(null);
        Pet pet = petRepository.findById(petDTO.getId()).orElse(null);
        if (user!=null&&pet!=null){
            user.setGacha(user.getGacha()-1);
            user.getOwnedPets().add(OwnedPet.builder().user(user).pet(pet).build());
            userRepository.save(user);
        }
        return user;
    }
}
