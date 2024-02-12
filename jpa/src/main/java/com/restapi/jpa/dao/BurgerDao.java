package com.restapi.jpa.dao;

import com.restapi.jpa.entity.Burger;

import java.util.List;

public interface BurgerDao {
     void save(Burger burger);
     Burger findById(int id);
     List<Burger> findAll();
     List<Burger> findByPrice(double price);
     List<Burger> findByBreadType(String breadType);
     List<Burger> findByContent(String contents);
     Burger update(Burger burger);
     void remove(Integer id);
}
