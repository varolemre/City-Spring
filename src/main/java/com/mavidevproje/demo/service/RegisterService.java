package com.mavidevproje.demo.service;

import com.mavidevproje.demo.entity.User;
import com.mavidevproje.demo.model.UserDTO;
import com.mavidevproje.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;

    public String registerPost(UserDTO user, RedirectAttributes redirectAttributes) {

        // check if these variables are exists at DB
        Optional<User> checkUser = userRepository.findByUsername(user.getUsername());
        Optional<User> checkMail = userRepository.findByMail(user.getMail());

        return userCheck(user, checkUser, checkMail, redirectAttributes);
    }

    private String userCheck(UserDTO user, Optional<User> checkUser, Optional<User> checkMail, RedirectAttributes redirectAttributes) {
        if(user.getMail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            redirectAttributes.addAttribute("error", "");
            return "redirect:/register";
        }

        if (!checkUser.isPresent()) {
            if (!checkMail.isPresent()) {
                //then create a new user object
                User newUser = new User(user.getUsername(), user.getMail(), null);
                newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

                userRepository.save(newUser);
                redirectAttributes.addAttribute("success","registered");
                return "redirect:/register";

            } else { // if mail exist
                redirectAttributes.addAttribute("mail", "exist");
                return "redirect:/register";
            }
        } else { // if username exist
            redirectAttributes.addAttribute("username", "exist");
            return "redirect:/register";
        }
    }
}
