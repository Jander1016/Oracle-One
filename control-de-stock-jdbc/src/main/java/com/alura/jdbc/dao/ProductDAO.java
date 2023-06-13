package com.alura.jdbc.dao;

import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {
  final private Connection cn;
  public ProductDAO(Connection cn){
    this.cn = cn;
  }
  public void safe(Product product){
    try {
      final PreparedStatement statement = cn.prepareStatement("INSERT INTO product(name_product, description, quantity) values (?,?, ?)", Statement.RETURN_GENERATED_KEYS);

      try(statement) {
        InsertRegister(product, statement);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  private void InsertRegister(Product product, PreparedStatement statement) throws SQLException {
    statement.setString(1, product.getName_product());
    statement.setString(2, product.getDescription());
    statement.setInt(3, product.getQuantity());
    statement.execute();

    final ResultSet rsIds = statement.getGeneratedKeys();

    try(rsIds) {
      while (rsIds.next()) {
        product.setId(rsIds.getInt(1));
        System.out.println(String.format("Insert product ID %s", product));
      }
    }
  }
  public List<Product> listing() {

    try{
      final PreparedStatement statement = cn.prepareStatement("select id, name_product, description,quantity from product");
      try(statement){
        statement.execute();
        ResultSet rs = statement.getResultSet();
        List<Product> productList = new ArrayList<>();
        while (rs.next()) {
          Product product = new Product(
                  rs.getInt("id"),
                  rs.getString("name_product"),
                  rs.getString("description"),
                  rs.getInt("quantity")
                  );
          productList.add(product);
        }
        return productList;
      }
    }catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
  public int update(String name_product, String description, Integer quantity, Integer id)  {
    try {
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
    }catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public int deleteById(Integer id){
    try{
      final PreparedStatement statement= cn.prepareStatement("delete from product where id = ?");

      try(statement) {
        statement.setInt(1, id);
        statement.execute();
        int deleteCount = statement.getUpdateCount();
        return deleteCount;
      }
    }catch(SQLException e){
      throw new RuntimeException(e);
    }
  }

}
