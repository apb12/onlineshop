package com.testwork.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayContoller {
    @GetMapping("/pay")
    public String pay(){
        return "pay";
    }
}
