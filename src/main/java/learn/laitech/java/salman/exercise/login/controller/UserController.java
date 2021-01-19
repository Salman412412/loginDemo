package learn.laitech.java.salman.exercise.login.controller;

import learn.laitech.java.salman.exercise.login.domain.Entity.User;
import learn.laitech.java.salman.exercise.login.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@Controller
public class UserController {


    UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/save")
    public String saveUser(User user, Model model) {
        try {
            userRepository.save(user);
            model.addAttribute("error", "Saved Successfully");
        } catch (Exception exception) {
            model.addAttribute("error", "There were some errors...");
        }
        return "/login";
    }

    @RequestMapping("/check-user")
    public String CheckUser(User user, Model model) {
        User foundUser;
        if ((foundUser = userRepository.findUserByUsername(user.getUsername())) != null) {
            if (foundUser.getPassword().equals(user.getPassword())) {
                model.addAttribute("user", foundUser);
                return "/profile";
            } else {
                model.addAttribute("error", "Password is incorrect");
                return "/login";
            }
        } else {
            model.addAttribute("error", "Username not found");
            return "/login";
        }
    }

    @RequestMapping("/update")
    public String UpdateUser(User user, Model model) {
        try {
            userRepository.save(user);
            model.addAttribute("Message", "Updated Successfully");
        } catch (Exception exception) {
            model.addAttribute("Message", "There were some errors...");
        } finally {
            model.addAttribute("user", user);
        }
        return "/profile";
    }
}