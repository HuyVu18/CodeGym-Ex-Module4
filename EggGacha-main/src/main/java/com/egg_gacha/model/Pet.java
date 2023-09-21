package com.egg_gacha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    private Long id;
    private String name;
    private String rarity;
    @OneToMany(mappedBy = "pet")
//    @JoinTable(name = "owned_pet",
//            joinColumns = @JoinColumn(name = "pet_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<OwnedPet> ownedPets;
}
