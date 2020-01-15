package com.testwork.onlineshop.controller;

import com.testwork.onlineshop.entity.Purchase;
import com.testwork.onlineshop.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class PurchaseEditController {

    @Autowired
    private PurchaseRepo purchaseRepo;

    @GetMapping("/edition")
    public String deletePurchase(){
        return "purchedit";
    }


    @GetMapping("delete/{id}")
    public String deletePurchase(@PathVariable("id")Purchase p, Model model){
        model.addAttribute("delete",p);
        return "purchedit";
    }
    @GetMapping("edit/{id}")
    public String editPurchase(@PathVariable("id")Purchase p, Model model){
        model.addAttribute("edit",p);
        return "purchedit";
    }
    @PostMapping("/delete")
    public String deletePurch(@RequestParam(name = "id")Purchase p,
                              RedirectAttributes redirectAttributes){
        purchaseRepo.delete(p);
        redirectAttributes.addFlashAttribute("success","Заказ успешно удален");
        return "redirect:/edition";
    }
    @PostMapping("/edit")
    public String editPurch(@RequestParam(name = "id")Purchase p,
                              @RequestParam("count")Long count,
                              RedirectAttributes redirectAttributes){
        if(count>p.getItem().getQuantity()){
            redirectAttributes.addFlashAttribute("error","Извините,данного вида товара нет в таком количестве");
            return "redirect:/edition";
        }
        p.setCount(count);
        Long sum=p.getItem().getPrice().longValue()*count;
        p.setAmount(new BigDecimal(sum));
        purchaseRepo.save(p);
        redirectAttributes.addFlashAttribute("success","Заказ успешно обновлен");
        return "redirect:/edition";
    }
}
