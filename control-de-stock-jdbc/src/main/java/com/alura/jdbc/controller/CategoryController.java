package com.alura.jdbc.controller;

import com.alura.jdbc.dao.CategoryDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {

  private CategoryDAO categoryDAO;

  public CategoryController(){
    this.categoryDAO = new CategoryDAO(new ConnectionFactory().recoveryConnection());
  }
	public List<Category> categoryList() {
		// TODO
		return categoryDAO.categoryList();
	}

  public List<Category> loadReport() {
      // TODO
      return new ArrayList<>();
  }

}
