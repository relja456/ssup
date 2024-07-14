/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author relja
 */
public class Zaduzenje extends OpstiDomenskiObjekat implements Serializable {

    private String naziv;
    private String opis;
    private LocalDate datumPocetka;
    private Zaposleni zaposleni;
    private Zadatak zadatak;

    private String stariJMBG = "";

    public Zaduzenje() {
        this.naziv = null;
        this.opis = null;
        this.datumPocetka = null;
        this.zaposleni = null;
        this.zadatak = null;
    }

    public Zaduzenje(String naziv, String opis, LocalDate datumPocetka, Zaposleni zaposleni, Zadatak zadatak) {
        this.naziv = naziv;
        this.opis = opis;
        this.datumPocetka = datumPocetka;
        this.zaposleni = zaposleni;
        this.zadatak = zadatak;

        if (zaposleni != null) {
            stariJMBG = zaposleni.getJMBG();
        }
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
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

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
        if (stariJMBG.equals("")) {
            stariJMBG = zaposleni.getJMBG();
        }

    }

    public String getStariJMBG() {
        return stariJMBG;
    }

    public void setStariJMBG(String stariJMBG) {
        this.stariJMBG = stariJMBG;
    }

    @Override
    public String tabela() {
        return "zaduzenja";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        return " (JMBG, idProjekat, idZadatak, naziv, opis, datumPocetka) VALUES (" + "\"" + zaposleni.getJMBG() + "\"" + ","
                + "\"" + zadatak.getProjekat().getIdProjekat() + "\"" + ","
                + "\"" + zadatak.getIdZadatak() + "\"" + ","
                + "\"" + naziv + "\"" + ","
                + "\"" + opis + "\"" + ","
                + "\"" + datumPocetka + "\"" + ")";
    }

    @Override
    public void postaviPK(int pk) {
    }

    @Override
    public String primarniKljuc() {
        return "zaduzenja.JMBG=\"" + getStariJMBG() + "\" AND idProjekat=" + zadatak.getProjekat().getIdProjekat() + " AND idZadatak=" + zadatak.getIdZadatak();
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Zaduzenje zaduzenje = new Zaduzenje();

        zaduzenje.setZadatak(new Zadatak(rs.getInt("idZadatak"), new Projekat(rs.getInt("idProjekat"))));

        zaduzenje.setNaziv(rs.getString("naziv"));
        zaduzenje.setOpis(rs.getString("opis"));
        zaduzenje.setDatumPocetka(rs.getDate("datumPocetka").toLocalDate());

        zaduzenje.setZaposleni(new Zaposleni(rs.getString("JMBG"),
                rs.getString("imePrezime"),
                rs.getString("korisnickoIme"),
                null,
                new Kompanija(rs.getString("kompanija"))));

        return zaduzenje;
    }

    @Override
    public String uslovZaListu() {
        return " WHERE idProjekat=" + getZadatak().getProjekat().getIdProjekat() + " AND idZadatak=" + getZadatak().getIdZadatak();
    }

    @Override
    public String vrednostiZaIzmenu() {
        return " SET naziv=\"" + getNaziv() + "\", opis=\"" + getOpis() + "\", datumPocetka=\"" + getDatumPocetka() + "\", JMBG=\"" + getZaposleni().getJMBG() + "\"";
    }

    @Override
    public String join() {
        return " JOIN zaposleni ON zaduzenja.JMBG = zaposleni.JMBG ";
    }

    @Override
    public String toString() {
        return naziv + ": " + zaposleni.getImePrezime();
    }
}
