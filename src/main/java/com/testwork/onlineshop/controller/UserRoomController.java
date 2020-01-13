package com.testwork.onlineshop.controller;

import com.testwork.onlineshop.entity.Item;
import com.testwork.onlineshop.entity.Purchase;
import com.testwork.onlineshop.entity.User;
import com.testwork.onlineshop.repo.ItemRepo;
import com.testwork.onlineshop.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ur")
public class UserRoomController {
    @Autowired
    private PurchaseRepo purchaseRepo;

    @GetMapping
    public String showPurchase(@AuthenticationPrincipal User u,
                               Model model){
        List<Purchase>purchaseList=purchaseRepo.findByUser(u);
        if(purchaseList.isEmpty()){
            model.addAttribute("error","У вас пока нет покупок");
            return "ur";
        }
        model.addAttribute("purchase",purchaseList);
        return "ur";

    }
}
