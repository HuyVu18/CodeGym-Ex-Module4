package com.egg_gacha.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "owned_pet")
@Builder
public class OwnedPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private LocalDateTime owned;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @ManyToOne
    private Pet pet;

    public OwnedPet() {
        this.owned = LocalDateTime.now();
    }
}
