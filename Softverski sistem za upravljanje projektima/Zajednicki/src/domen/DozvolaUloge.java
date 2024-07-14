/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author relja
 */
public class DozvolaUloge extends OpstiDomenskiObjekat implements Serializable {

    private Dozvola dozvola;
    private Uloga uloga;

    public DozvolaUloge() {

    }

    public DozvolaUloge(Dozvola dozvola, Uloga uloga) {
        this.dozvola = dozvola;
        this.uloga = uloga;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Dozvola getDozvola() {
        return dozvola;
    }

    public void setDozvola(Dozvola dozvola) {
        this.dozvola = dozvola;
    }

    @Override
    public String tabela() {
        return "dozvoleuloga";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaListu() {
        return " WHERE idUloga=" + getUloga().getId();
    }

    @Override
    public void postaviPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Dozvola dozvola = new Dozvola();
        
        dozvola.setId(rs.getInt("idDozvola"));
        dozvola.setNaziv(rs.getString("naziv"));
        
        return dozvola;
    }

    @Override
    public String vrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        return " JOIN dozvole ON dozvole.id = dozvoleuloga.idDozvola ";
    }

}
