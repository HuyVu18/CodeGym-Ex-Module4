package com.egg_gacha.converter.impl;

import com.egg_gacha.converter.Converter;
import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.model.Pet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("petDTOConverter")
public class PetDTOConverter implements Converter<Pet, PetDTO> {
    @Override
    public Pet convert(PetDTO source) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(source,pet);
        return pet;
    }

    @Override
    public PetDTO reverse(Pet target) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(target,petDTO);
        return petDTO;
    }
}
