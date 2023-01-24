package web.controllers;

import web.models.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showUserInfo(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);

        return "all-users";
    }


    @RequestMapping("/addNewUser")
    public String getCreationForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/user-info")
    public String saveNewUser(@ModelAttribute("user") User user) {

        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getEditForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @RequestMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user,
                              @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.getUserById(id);
        return "redirect:/";
    }
}


