package com.testwork.onlineshop.repo;

import com.testwork.onlineshop.entity.Item;
import com.testwork.onlineshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {

}
