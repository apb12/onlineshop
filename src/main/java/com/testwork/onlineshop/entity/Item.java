package com.testwork.onlineshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String proc;
    private String ram;
    private String hdd;
    private String name;
    private BigDecimal price;
    private Long quantity;
    @OneToMany(mappedBy = "item")
    private List<Purchase>purchases;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
