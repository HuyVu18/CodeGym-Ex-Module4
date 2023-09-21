package com.egg_gacha.converter.impl;

import com.egg_gacha.converter.Converter;
import com.egg_gacha.dto.UserDTO;
import com.egg_gacha.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userDTOConverter")
public class UserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public User convert(UserDTO source) {
        User user = new User();
        BeanUtils.copyProperties(source,user);
        return user;
    }

    @Override
    public UserDTO reverse(User target) {
        return null;
    }
}
