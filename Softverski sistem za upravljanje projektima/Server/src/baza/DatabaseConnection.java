/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;

/**
 *
 * @author relja
 */
public class DatabaseConnection {

    private Connection connection;
    private static DatabaseConnection instance;

    public DatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/projekti_baza";
        String user = "root";
        String password = "";

        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Uspesno konektovan sa bazom!");

        //iskljucujemo automatsko potvrdjivanje transakcije nakon svakog upita
        connection.setAutoCommit(false);
    }

    //singleton
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void commit() {
        try {
            connection.commit();
            System.out.println("Transakcija uspesno potvrdjena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrdjena!\n" + ex.getMessage());
        }
    }
    
    public void rollback() {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}
