package com.example.demodatajpa.service;

import com.example.demodatajpa.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAll();
}
