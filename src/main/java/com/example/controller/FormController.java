package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.UserEntity;
import com.example.repositories.UserRepository;

@Controller
public class FormController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String newPage(Model model) {
        model.addAttribute("title", "new");
        model.addAttribute("message", "Input your name");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createPage(@RequestParam("name") String name,
            @RequestParam(value = "gender", required = false) String gender, Model model) {
        System.out.println("name=" + name);
        System.out.println("gender=" + gender);
        model.addAttribute("title", "create");
        model.addAttribute("message", "Hello " + name + "!");

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setGender(gender);
        userRepository.save(userEntity);
        Iterable<UserEntity> userList = userRepository.findAll();
        model.addAttribute("userList", userList);

        return "form";
    }
}