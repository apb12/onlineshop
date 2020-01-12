package com.testwork.onlineshop.controller;

import com.testwork.onlineshop.config.ControllerUtils;
import com.testwork.onlineshop.entity.User;
import com.testwork.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(
            @RequestParam("password2")String passwordConfim,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {

        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfim);
        if(isConfirmEmpty){
            model.addAttribute("password2Error","Подтвердите пароль");
        }
        if(!user.getPassword().equals(passwordConfim)){
            model.addAttribute("password2Error","Пароли не совпадают");
            return "registration";


        }
        if(isConfirmEmpty|| bindingResult.hasErrors()){
            Map<String,String> errors= ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        if (userService.addUser(user)) {
            model.addAttribute("usernameError", "пользователь с таким логином существует");

            return "registration";
        }

        return "redirect:/";
    }


}
