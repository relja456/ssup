/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author relja
 */
public class Uloga extends OpstiDomenskiObjekat implements Serializable {

    private int id;
    private String naziv;
    private List<Dozvola> dozvole;

    public Uloga() {
    }

    public Uloga(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Dozvola> getDozvole() {
        return dozvole;
    }

    public void setDozvole(List<Dozvola> dozvole) {
        this.dozvole = dozvole;
    }

    @Override
    public String tabela() {
        return "uloge";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        return "id=" + getId();
    }

    @Override
    public String uslovZaListu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void postaviPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Uloga uloga = new Uloga();

        uloga.setId(rs.getInt("id"));
        uloga.setNaziv(rs.getString("naziv"));

        return uloga;
    }

    @Override
    public String vrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        return "";
    }

}
