package com.java.ecommerce.app.repository;

import com.java.ecommerce.app.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository  extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}
