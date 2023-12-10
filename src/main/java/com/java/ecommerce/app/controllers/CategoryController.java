package com.java.ecommerce.app.controllers;

import com.java.ecommerce.app.model.Category;
import com.java.ecommerce.app.model.Image;
import com.java.ecommerce.app.request.CategoryRequest;
import com.java.ecommerce.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryRequest categoryRequest) throws IOException {
        Category savedCategory = categoryService.addCategory(categoryRequest);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping(path = { "{categoryId}" })
    public Category getImage(@PathVariable("categoryId") Long categoryId) throws IOException {

         Category category = categoryService.findById(categoryId);

        return category;
    }
}