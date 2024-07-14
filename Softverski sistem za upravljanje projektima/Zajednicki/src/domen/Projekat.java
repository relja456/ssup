/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author relja
 */
public class Projekat extends OpstiDomenskiObjekat implements Serializable {

    private int idProjekat;
    private String naziv;
    private String opis;
    private LocalDate datumPocetka;
    private Kompanija kompanija;

    public Projekat() {
        idProjekat = -1;
        naziv = null;
        opis = null;
        datumPocetka = null;
        kompanija = null;
    }

    public Projekat(int idProjekat) {
        this.idProjekat = idProjekat;
    }

    public Projekat(int idProjekat, String naziv, String opis, LocalDate datumPocetka, Kompanija kompanija) {
        this.idProjekat = idProjekat;
        this.naziv = naziv;
        this.opis = opis;
        this.datumPocetka = datumPocetka;
        this.kompanija = kompanija;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public void setIdProjekat(int idProjekat) {
        this.idProjekat = idProjekat;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getIdProjekat() {
        return idProjekat;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    @Override
    public String tabela() {
        return "projekti";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        return " (naziv, opis, datumPocetka, kompanija) VALUES ('" + naziv + "','" + opis + "','" + datumPocetka + "','" + getKompanija().getPIB() + "') ";
    }

    @Override
    public void postaviPK(int pk) {
        setIdProjekat(pk);
    }

    @Override
    public String primarniKljuc() {
        return "idProjekat=" + idProjekat;
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Projekat proj = new Projekat();

        proj.setIdProjekat(rs.getInt("idProjekat"));
        proj.setNaziv(rs.getString("naziv"));
        proj.setOpis(rs.getString("opis"));
        proj.setDatumPocetka(rs.getDate("datumPocetka").toLocalDate());

        proj.setKompanija(new Kompanija(rs.getString("PIB"),
                rs.getString("nazivKompanije"),
                rs.getString("drzava"),
                rs.getString("grad"),
                rs.getDate("datumOsnivanja").toLocalDate()));

        return proj;
    }

    @Override
    public String uslovZaListu() {
        if (getNaziv() != null) {
            return " WHERE naziv LIKE '%" + getNaziv() + "%' AND kompanija='" + getKompanija().getPIB() + "'";
        } else if (getOpis() != null) {
            return " WHERE opis LIKE '%" + getOpis() + "%' AND kompanija='" + getKompanija().getPIB() + "'";
        } else if (getIdProjekat() != -1) {
            return " WHERE idProjekat=" + getIdProjekat() + " AND kompanija='" + getKompanija().getPIB() + "'";
        } else if (getDatumPocetka() != null) {
            return " WHERE datumPocetka='" + getDatumPocetka() + "' AND kompanija='" + getKompanija().getPIB() + "'";
        } else {
            return "WHERE kompanija='" + getKompanija().getPIB() + "'";
        }
    }

    @Override
    public String vrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        return " JOIN kompanije ON projekti.kompanija = kompanije.PIB ";
    }

    @Override
    public String toString() {
        return idProjekat + ": " + naziv;
    }

}
