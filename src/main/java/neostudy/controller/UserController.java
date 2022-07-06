package neostudy.controller;

import lombok.RequiredArgsConstructor;
import neostudy.entity.User;
import neostudy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @RequestMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @RequestMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit-user";
    }

    @RequestMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        System.out.println(bindingResult);
        if(bindingResult.hasErrors()) {
            return "new-user";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/{id}/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @RequestMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
