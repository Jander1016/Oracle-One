package com.alura.jdbc.controller;

import com.alura.jdbc.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {

  public int updateProduct(String name_product, String description, Integer quantity, Integer id) throws SQLException {
    final Connection cn = new ConnectionFactory().recoveryConnection();
    try(cn) {
      final PreparedStatement statement = cn.prepareStatement("UPDATE PRODUCT SET "
              + " name_product = ? "
              + ", description = ? "
              + ", quantity = ? "
              + " WHERE id = ?");
      try(statement) {
        statement.setString(1, name_product);
        statement.setString(2, description);
        statement.setInt(3, quantity);
        statement.setInt(4, id);
        statement.execute();

        int updateCount = statement.getUpdateCount();
        return updateCount;
      }
    }
  }

  public int deleteProductById(Integer id) throws SQLException {
    final Connection cn = new ConnectionFactory().recoveryConnection();

    try(cn){
      final PreparedStatement statement= cn.prepareStatement("delete from product where id = ?");

      try(statement) {
        statement.setInt(1, id);
        statement.execute();
        int deleteCount = statement.getUpdateCount();
        return deleteCount;
      }
    }
  }

  public List<Map<String, String>> listing() throws SQLException {
    final Connection cn = new ConnectionFactory().recoveryConnection();

    try(cn){
      final PreparedStatement statement = cn.prepareStatement("select id, name_product, description,quantity from product");
      try(statement){
        statement.execute();

        ResultSet rs = statement.getResultSet();
        List<Map<String, String>> productList = new ArrayList<>();
        while (rs.next()) {
          Map<String, String> product = new HashMap<>();
          product.put("id", String.valueOf(rs.getInt("id")));
          product.put("name_product", rs.getString("name_product"));
          product.put("description", rs.getString("description"));
          product.put("quantity", String.valueOf(rs.getInt("quantity")));
          productList.add(product);
        }
        return productList;
      }
    }
  }

  public void safeProduct(Map<String,String> product) throws SQLException {

    String nameProduct = product.get("name_product");
    String description = product.get("description");
    Integer quantity = Integer.valueOf(product.get("quantity"));
    Integer quantityMax = 50;

    final Connection cn = new ConnectionFactory().recoveryConnection();
    try(cn) {
      cn.setAutoCommit(false);

      final PreparedStatement statement = cn.prepareStatement("INSERT INTO product(name_product, description, quantity) values (?,?, ?)", Statement.RETURN_GENERATED_KEYS);

      try(statement) {
        do {
          int quantitySave = Math.min(quantity, quantityMax);
          InsertRegister(nameProduct, description, quantitySave, statement);
          quantity -= quantitySave;

        }while(quantity > 0);
        cn.commit();
      }catch (Exception e){
        cn.rollback();
      }
    }
  }

  private void InsertRegister(String nameProduct, String description, Integer quantity, PreparedStatement statement) throws SQLException {
    statement.setString(1, nameProduct);
    statement.setString(2, description);
    statement.setString(3, String.valueOf(quantity));
    statement.execute();

    final ResultSet rsIds = statement.getGeneratedKeys();

    try(rsIds) {
      while (rsIds.next()) {
        System.out.println(String.format("Insert product ID %d", rsIds.getInt(1)));
      }
    }
  }

}
