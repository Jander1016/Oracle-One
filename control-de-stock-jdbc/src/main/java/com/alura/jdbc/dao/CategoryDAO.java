package com.alura.jdbc.dao;

import com.alura.jdbc.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
  final private Connection cn;
  public CategoryDAO(Connection cn){
    this.cn = cn;
  }

  public List<Category> categoryList(){
    try {
      final PreparedStatement statement= cn.prepareStatement("Select * from Category");

      try(statement){
        final ResultSet resultSet = statement.executeQuery();
        try(resultSet){
          List<Category> listCategories = new ArrayList<>();

          while (resultSet.next()){
            Category category = new Category(
                    resultSet.getInt("Id_category"),
                    resultSet.getString("name_category")
            );
            listCategories.add(category);
          }
          return listCategories;
        }
      }

    }catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
}
