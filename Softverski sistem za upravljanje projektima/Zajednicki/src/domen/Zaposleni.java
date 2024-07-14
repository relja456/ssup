/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author relja
 */
public class Zaposleni extends OpstiDomenskiObjekat implements Serializable {

    private String JMBG;
    private String imePrezime;
    private String korisnickoIme;
    private String lozinka;
    private Kompanija kompanija;

    public Zaposleni() {
    }

    public Zaposleni(String JMBG) {
        this.JMBG = JMBG;
    }

    public Zaposleni(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Zaposleni(String JMBG, String imePrezime, String korisnickoIme, String lozinka, Kompanija kompanija) {
        this.JMBG = JMBG;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.kompanija = kompanija;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return imePrezime + " : " + kompanija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        return Objects.equals(this.JMBG, other.JMBG);
    }

    @Override
    public String tabela() {
        return "zaposleni";
    }

    @Override
    public String naziviIVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void postaviPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        return "korisnickoIme='" + korisnickoIme + "' AND lozinka='" + lozinka + "'";
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException {
        Zaposleni z = new Zaposleni();
        
        z.setJMBG(rs.getString("JMBG"));
        z.setImePrezime(rs.getString("imePrezime"));
        z.setKorisnickoIme(rs.getString("korisnickoIme"));
        z.setLozinka(rs.getString("lozinka"));
        
        z.setKompanija(new Kompanija(rs.getString("PIB"), 
                rs.getString("nazivKompanije"), 
                rs.getString("drzava"), 
                rs.getString("grad"), 
                rs.getDate("datumOsnivanja").toLocalDate()));
        
        return z;
    }

    @Override
    public String uslovZaListu() {
        return " WHERE PIB='" + getKompanija().getPIB() + "'";
    }

    @Override
    public String vrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        return " zaposleni JOIN kompanije ON zaposleni.kompanija = kompanije.PIB ";
    }
}
