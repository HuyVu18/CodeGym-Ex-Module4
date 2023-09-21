package com.egg_gacha.controller;

import com.egg_gacha.dto.PetDTO;
import com.egg_gacha.model.User;
import com.egg_gacha.service.GachaService;
import com.egg_gacha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/gacha/pets")
@SessionAttributes("user")
public class GachaController {
    @Autowired
    private HttpServletRequest request;
    private final GachaService gachaService;
    private final UserService userService;

    public GachaController(GachaService gachaService, UserService userService) {
        this.gachaService = gachaService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<PetDTO> gacha(@ModelAttribute("user") User user) {
        Optional<User> userOptional = userService.findById(user.getId());
        if (userOptional.isPresent()) {
            User savedUser = userOptional.get();
            if (savedUser.getGacha() >= 1) {
                PetDTO petDTO = gachaService.getRandomPetDto();
                gachaService.updateGacha(user.getId(), petDTO);
                return new ResponseEntity<>(petDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/remain")
    public ResponseEntity<Integer> getRemainGacha(@ModelAttribute("user") User user){
        User user1 = userService.findById(user.getId()).orElse(new User());
        return new ResponseEntity<>(user1.getGacha(),HttpStatus.OK);
    }
}
