package com.testwork.onlineshop.repo;

import com.testwork.onlineshop.entity.Purchase;
import com.testwork.onlineshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
    List<Purchase> findByUser(User u);
}
