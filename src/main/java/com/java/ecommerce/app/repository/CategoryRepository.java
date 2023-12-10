package com.java.ecommerce.app.repository;

import com.java.ecommerce.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
