package com.restapi.jpa.controller;

import com.restapi.jpa.dao.BurgerDao;
import com.restapi.jpa.entity.Burger;
import com.restapi.jpa.entity.BurgerDaoImpl;
import com.restapi.jpa.exceptions.BurgerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/workintech/burgers")
@RestController
public class BurgerController {
    private BurgerDaoImpl burgerDao;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDao) {
        this.burgerDao = burgerDao;
    }
    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Integer id) {
        Burger burger = burgerDao.findById(id);
        if (burger == null) {
            throw new BurgerNotFoundException("Burger not found with id: " + id);
        }
        return burger;
    }
    @PostMapping
    public void saveBurger(@RequestBody Burger burger) {
        burgerDao.save(burger);
    }
    @PutMapping("/{id}")
    public void updateBurger(@PathVariable Integer id, @RequestBody Burger newBurger) {
        Burger existingBurger = burgerDao.findById(id);
        if (existingBurger == null) {
            throw new BurgerNotFoundException("Burger not found with id: " + id);
        }

        existingBurger.setName(newBurger.getName());
        existingBurger.setPrice(newBurger.getPrice());
        existingBurger.setBreadType(newBurger.getBreadType());
        existingBurger.setContents(newBurger.getContents());

        burgerDao.update(existingBurger);
    }
    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable Integer id) {
        Burger existingBurger = burgerDao.findById(id);
        if (existingBurger == null) {
            throw new BurgerNotFoundException("Burger not found with id: " + id);
        }
        burgerDao.remove(id);
    }


    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestParam double price) {
        return burgerDao.findByPrice(price);
    }


    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestParam String breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestParam String content) {
        return burgerDao.findByContent(content);
    }
}
