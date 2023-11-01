package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.UserDto;
import com.teamPhoenix.votopia.entity.User;
import com.teamPhoenix.votopia.entity.VoterIdentification;
import com.teamPhoenix.votopia.service.UserService;
import com.teamPhoenix.votopia.service.VoterIdentificationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    private final VoterIdentificationService voterIdentificationService;

    @GetMapping("/")
    public String home(Model model, Authentication authentication, @AuthenticationPrincipal User userDetails) {
        model.addAttribute("user", userDetails);
        return "index";
    }


    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        } else if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Passwords do not match");
        } else if (!voterIdentificationService.validateIdentificationNumber(user.getVoterIdentification())) {
            result.rejectValue("voterIdentification", null, "Invalid voter identification number");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/register?success";
    }
//
//    @GetMapping("/edit")
//    public String editUser(Authentication authentication, Model model) {
//        User user = userService.findByEmail(authentication.getName());
//        model.addAttribute("user", userService.convertEntityToDto(user));
//        return "edit";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@Valid @ModelAttribute("user") UserDto user,
//                           BindingResult result,
//                           Model model) {
//        User existing = userService.findByEmail(user.getEmail());
//        if (existing != null) {
//            existing.setPhone(user.getPhone());
//            existing.setFirstName(user.getFirstName());
//            existing.setLastName(user.getLastName());
//            userService.update(existing);
//        } else {
//            result.rejectValue("email", null, "There is no account registered with that email");
//        }
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "edit";
//        }
//        return "redirect:/edit?success";
//    }
}
