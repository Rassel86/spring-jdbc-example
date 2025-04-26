package main.controllers;

import jakarta.validation.Valid;
import main.model.Person;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("persons", userService.findAllPersons());
        return "homepage";
    }

    @GetMapping("/registration")
    public String addNewUser(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "registration";
    }

    @PostMapping("/save")
    public String saveUser(@Valid Person person, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "registration";
        }
        userService.savePerson(person);
        return "redirect:/home";
    }

    @GetMapping("/update/{personId}")
    public String updatePerson(@PathVariable("personId") Long id, Model model) {
        Person person = userService.findPersonById(id);
        model.addAttribute("person", person);
        return "registration";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Long id) {
        userService.deletePerson(id);
        return "redirect:/home";
    }
}
