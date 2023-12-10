package com.java.ecommerce.app.controllers;

import com.java.ecommerce.app.model.Category;
import com.java.ecommerce.app.request.CategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryRequest categoryRequest){


    }
}
