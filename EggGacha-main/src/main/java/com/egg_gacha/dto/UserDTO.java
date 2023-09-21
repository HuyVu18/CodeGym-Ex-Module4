package com.egg_gacha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull
    @Size(min = 4,max = 64)
    private String username;
    @NotNull
    @Size(min = 4,max = 64)
    private String password;
}
