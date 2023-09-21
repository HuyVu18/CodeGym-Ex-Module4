package com.egg_gacha.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private Integer gacha = 25;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OwnedPet> ownedPets;
    @Override
    public String toString() {
        return "User: " + username;
    }
}
