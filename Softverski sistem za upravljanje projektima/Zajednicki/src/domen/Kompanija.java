/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author relja
 */
public class Kompanija extends OpstiDomenskiObjekat implements Serializable {

    private String PIB;
    private String nazivKompanije;
    private String drzava;
    private String grad;
    private LocalDate datumOsnivanja;

    public Kompanija() {
    }

    public Kompanija(String PIB) {
        this.PIB = PIB;
    }

    public Kompanija(String PIB, String nazivKompanije) {
        this.PIB = PIB;
        this.nazivKompanije = nazivKompanije;
    }
    
    public Kompanija(String PIB, String nazivKompanije, String drzava, String grad, LocalDate datumOsnivanja) {
        this.PIB = PIB;
        this.nazivKompanije = nazivKompanije;
        this.drzava = drzava;
        this.grad = grad;
        this.datumOsnivanja = datumOsnivanja;
    }

    public LocalDate getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(LocalDate datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return nazivKompanije+": "+PIB;
    }

    @Override
    public String tabela() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaListu() {
        return "";
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
