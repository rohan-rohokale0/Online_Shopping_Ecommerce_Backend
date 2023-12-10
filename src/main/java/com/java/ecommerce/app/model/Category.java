package com.java.ecommerce.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name="categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

  @NotNull
  @Size(max=50,min=1)
    private String categoryName;

  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinTable(name = "category_images", joinColumns = {
          @JoinColumn(name="category_id")
  },
          inverseJoinColumns = {
          @JoinColumn(name = "image_id")
          }

  )
  private Set<Image_Model>categoryImages;

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public Set<Image_Model> getCategoryImages() {
    return categoryImages;
  }

  public void setCategoryImages(Set<Image_Model> categoryImages) {
    this.categoryImages = categoryImages;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
