package com.java.ecommerce.app.service;

import com.java.ecommerce.app.model.Category;
import com.java.ecommerce.app.model.Image;
import com.java.ecommerce.app.repository.CategoryRepository;
import com.java.ecommerce.app.repository.ImageRepository;
import com.java.ecommerce.app.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageService imageService;
    @Autowired
    ImageRepository imageRepository;

    public Category addCategory(CategoryRequest categoryRequest) throws IOException {
        Category category = new Category();
        category.setCategoryName(category.getCategoryName());
        categoryRepository.save(category);

        Image image = new Image();
        image.setCategoryId(category.getCategoryId());
        imageService.saveImages(categoryRequest.getFile(),image);
        return  category;
    }

    public Category findById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Optional<Image> retrievedImage = imageRepository.findById(categoryId);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        category.get().setFile(img);
        return  category.get();

    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
