package com.java.ecommerce.app.controllers;

import com.java.ecommerce.app.model.Category;
import com.java.ecommerce.app.model.Image_Model;
import com.java.ecommerce.app.request.CategoryRequest;
import com.java.ecommerce.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = {"add"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Category addCategory(@RequestPart("category") Category category,
                                @RequestPart("imageFile")MultipartFile[] file)
    {
        //return CategoryService.addCategory(category);
        try {
         Set<Image_Model> images=uploadImage(file);
            category.setCategoryImages(images);
           return categoryService.addCategory(category);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<Image_Model> uploadImage(MultipartFile[] multipartFiles) throws IOException
    {
        Set<Image_Model> imageModels=new HashSet<>();
        for (MultipartFile file:multipartFiles)
        {
            Image_Model imageModel=new Image_Model(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModel.add(imageModel);
        }

        return imageModel;
    }

}
