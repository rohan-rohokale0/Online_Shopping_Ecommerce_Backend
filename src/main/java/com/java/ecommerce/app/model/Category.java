package com.java.ecommerce.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

  @NotNull
  @Size(max=50,min=1)
    private String categoryName;

}
