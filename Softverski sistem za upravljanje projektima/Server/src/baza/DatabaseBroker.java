/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domen.Kompanija;
import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import domen.Zadatak;
import domen.Zaduzenje;
import domen.Zaposleni;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author relja
 */
public class DatabaseBroker {

    public OpstiDomenskiObjekat vrati(OpstiDomenskiObjekat odo) throws SQLException {
        try {
            String query = "SELECT * FROM " + odo.tabela() + odo.join() + " WHERE " + odo.primarniKljuc();
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);

            //izvsi upit
            ResultSet rs = statement.executeQuery();

            //pristup rezultatima upita
            if (rs.next()) {
                odo = odo.postaviVrednostiAtributa(rs);
                return odo;
            }

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekta " + odo.getClass().getSimpleName() + " iz baze!");

        } catch (SQLException ex) {
            System.out.println("Objekat " + odo.getClass().getSimpleName() + " nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
        return null;
    }

    public OpstiDomenskiObjekat dodaj(OpstiDomenskiObjekat odo) throws SQLException {
        try {
            String query = "INSERT INTO " + odo.tabela() + odo.naziviIVrednostiAtributa();

            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            //izvsi upit
            int result = statement.executeUpdate();
            System.out.println("Result = " + result);
            System.out.println("Objekat " + odo.getClass().getName() + " uspesno dodat u bazu!");

            //pristup generisanom kljucu
            ResultSet rsID = statement.getGeneratedKeys();
            if (rsID.next()) {
                odo.postaviPK(rsID.getInt(1));
            }
            rsID.close();
            statement.close();

            return odo;
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw ex;
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta " + odo.getClass().getName() + " u bazu!\n" + ex.getMessage());
            throw ex;
        }
    }

    public List<OpstiDomenskiObjekat> vratiListuSvih(OpstiDomenskiObjekat odo) {
        try {
            List<OpstiDomenskiObjekat> list = new ArrayList<>();
            String query = "SELECT * FROM " + odo.tabela() + odo.join() + odo.uslovZaListu();
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            //izvsi upit
            ResultSet rs = statement.executeQuery(query);

            //pristup rezultatima upita
            while (rs.next()) {
                odo = odo.postaviVrednostiAtributa(rs);
                list.add(odo);
            }
            
            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata " + odo.getClass().getSimpleName() + " iz baze!");

            return list;
        } catch (SQLException ex) {
            System.out.println("Objekti " + odo.getClass().getSimpleName() + " nisu uspesno ucitani iz baze!");
            ex.printStackTrace();
        }
        return null;
    }


    public boolean obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        try {
            String query = "DELETE FROM " + odo.tabela() + " WHERE " + odo.primarniKljuc();
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);

            //izvsi upit
            int results = statement.executeUpdate();
            System.out.println(results);

            statement.close();
            System.out.println("Uspesno brisanje objekta " + odo.getClass().getSimpleName() + " iz baze!");

            return true;
        } catch (SQLException ex) {
            System.out.println("Objekat " + odo.getClass().getSimpleName() + " nije uspesno obrisan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        try {
            String query = "UPDATE " + odo.tabela() + odo.vrednostiZaIzmenu() + " WHERE " + odo.primarniKljuc();
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);

            //izvsi upit
            int results = statement.executeUpdate();
            System.out.println(results);

            statement.close();
            System.out.println("Uspesna izmena objekta Zaduzenje u bazi!");

            return true;
        } catch (SQLException ex) {
            System.out.println("Objekat Zaduzenje nije uspesno izmenjen u bazi!");
            ex.printStackTrace();
            throw ex;
        }
    }

}
