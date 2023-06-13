package com.alura.jdbc.model;

public class Product {
  private int id;
  private String name_product;
  private String description;
  private int quantity;
  public Product(int id, String name_product, String description, int quantity) {
    this.id = id;
    this.name_product = name_product;
    this.description = description;
    this.quantity = quantity;
  }

  public String getName_product() {
    return name_product;
  }

  public void setName_product(String name_product) {
    this.name_product = name_product;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setId(int id) {
    this.id = id;
  }



}
