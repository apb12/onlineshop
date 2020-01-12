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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private PurchaseRepo purchaseRepo;

    @GetMapping
    public String showItems(Model model){
        model.addAttribute("items",itemRepo.findAll());
        return "shop";
    }
    @GetMapping("/{id}")
    public String showItemsById(@PathVariable("id") Item item, Model model){
        model.addAttribute("comp",item);
        return "pay";
    }
    @PostMapping
    public String payItem(@AuthenticationPrincipal User u,
                          @RequestParam(name = "amount")Long amount,
                          @RequestParam(name = "id")Item i,
                          RedirectAttributes redirectAttributes){
        if(amount>i.getQuantity()){
            redirectAttributes.addFlashAttribute("error","Извините,данного вида товара нет в таком количестве");
            return "redirect:/pay";
        }
        Purchase p=new Purchase();
        p.setUser(u);
        p.setItem(i);
        p.setDtime(LocalDateTime.now());
        p.setCount(amount);
        Long sum=amount*i.getPrice().longValue();
        p.setAmount(new BigDecimal(sum));
        purchaseRepo.save(p);
        redirectAttributes.addFlashAttribute("success","Поздравляем с покупкой");
        return "redirect:/pay";

    }

}
