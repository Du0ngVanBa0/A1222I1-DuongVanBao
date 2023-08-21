package com.example.demospringboot.service;

import com.example.demospringboot.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAll();
}
