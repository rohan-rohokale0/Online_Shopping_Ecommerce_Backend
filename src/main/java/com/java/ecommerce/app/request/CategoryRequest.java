package com.java.ecommerce.app.request;

import org.springframework.web.multipart.MultipartFile;

public class CategoryRequest {
    private String categoryName;

    private MultipartFile file;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
