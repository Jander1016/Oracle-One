package com.alura.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
  public static void main(String[] args) throws SQLException {

      Connection cn = DriverManager.getConnection(
              "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
              "root",
              "root"
      );
      System.out.println("Satisfying connection");
      cn.close();

  }
}
