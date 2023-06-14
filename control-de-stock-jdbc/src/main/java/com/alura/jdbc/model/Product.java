package com.alura.jdbc.model;

public class Product {
  private int id;
  private String name_product;
  private String description;
  private int quantity;
  private int category_id;
  public Product(int id, String name_product, String description, int quantity, int idCategory) {
    this.id =id;
    this.name_product = name_product;
    this.description = description;
    this.quantity = quantity;
    this.category_id = idCategory;
  }
  public Product(String name_product, String description, int quantity, int idCategory) {
    this.name_product = name_product;
    this.description = description;
    this.quantity = quantity;
    this.category_id = idCategory;
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
  public int getId() {
    return id;
  }

  public int getCategory_id() {
    return category_id;
  }

  public void setCategory_id(int category_id) {
    this.category_id = category_id;
  }

  @Override
  public String toString() {
    return String.format(
            "{id: %d, name: %S, description: %s, quantity: %d}",
            this.id, this.name_product, this.description, this.quantity
    );
  }
}
