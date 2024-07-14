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
public class Zadatak extends OpstiDomenskiObjekat implements Serializable {

    private int idZadatak;
    private String naziv;
    private String opis;
    private Projekat projekat;

    public Zadatak() {
    }

    public Zadatak(int idZadatak, Projekat projekat) {
        this.idZadatak = idZadatak;
        this.projekat = projekat;
    }

    public Zadatak(int idZadatak, String naziv, String opis, Projekat projekat) {
        this.idZadatak = idZadatak;
        this.naziv = naziv;
        this.opis = opis;
        this.projekat = projekat;
    }

    public Zadatak(String naziv, String opis, Projekat projekat) {
        this.naziv = naziv;
        this.opis = opis;
        this.projekat = projekat;
    }

    public Projekat getProjekat() {
        return projekat;
    }

    public void setProjekat(Projekat projekat) {
        this.projekat = projekat;
    }

    public int getIdZadatak() {
        return idZadatak;
    }

    public void setIdZadatak(int idZadatak) {
        this.idZadatak = idZadatak;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return idZadatak + " " + naziv + " " + opis;
    }

    @Override
    public String tabela() {
        return "zadaci";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        return " (idProjekat, naziv, opis) VALUES (" + "\"" + projekat.getIdProjekat() + "\"" + "," + "\"" + naziv + "\"" + "," + "\"" + opis + "\"" + ")";
    }

    @Override
    public void postaviPK(int pk) {
        setIdZadatak(pk);
    }

    @Override
    public String primarniKljuc() {
        return "idZadatak=" + idZadatak + " AND idProjekat=" + projekat.getIdProjekat();
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Zadatak zad = new Zadatak();
        zad.setIdZadatak(rs.getInt("idZadatak"));
        zad.setNaziv(rs.getString("naziv"));
        zad.setOpis(rs.getString("opis"));
        zad.setProjekat(new Projekat(rs.getInt("idProjekat"), null, null, null, null));
        return zad;
    }

    @Override
    public String uslovZaListu() {
        return " WHERE idProjekat=" + projekat.getIdProjekat();
    }

    @Override
    public String vrednostiZaIzmenu() {
        return " SET naziv=\"" + getNaziv() + "\", opis=\"" + getOpis()+"\"";
    }

    @Override
    public String join() {
        return "";
    }

}
