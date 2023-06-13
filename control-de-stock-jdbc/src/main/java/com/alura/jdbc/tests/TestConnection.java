package com.alura.jdbc.tests;

import com.alura.jdbc.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().recoveryConnection();;

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
