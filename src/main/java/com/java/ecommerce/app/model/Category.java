package com.java.ecommerce.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

  @NotNull
  @Column(name="category_name")
  @Size(max=50,min=1)
    private String categoryName;

  private Image file;

  public Image getFile() {
    return file;
  }

  public void setFile(Image file) {
    this.file = file;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
