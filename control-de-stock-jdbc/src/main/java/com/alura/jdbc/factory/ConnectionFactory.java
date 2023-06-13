package com.alura.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

  private final DataSource dataSource;
  public ConnectionFactory() {
    var pooledDataSource = new ComboPooledDataSource();
    pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
    pooledDataSource.setUser("root");
    pooledDataSource.setPassword("root");
    pooledDataSource.setMaxPoolSize(10);

    this.dataSource = pooledDataSource;
  }

  public Connection recoveryConnection()  {
    try {
      return this.dataSource.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
