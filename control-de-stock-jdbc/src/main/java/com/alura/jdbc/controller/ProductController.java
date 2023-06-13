package com.alura.jdbc.controller;

import com.alura.jdbc.dao.ProductDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.model.Product;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class ProductController {

  private ProductDAO productDAO;
  public ProductController (){
    this.productDAO = new ProductDAO(new ConnectionFactory().recoveryConnection());
  };

  public int updateProduct(String name_product, String description, Integer quantity, Integer id)  {
    return productDAO.update(name_product, description, quantity, id);
  }

  public int deleteProductById(Integer id){
    return productDAO.deleteById(id);
  }

  public List<Product> listingProduct()  {
    return productDAO.listing();
  }

  public void safeProduct(Product product) {
    productDAO.safe(product);
  }



}
