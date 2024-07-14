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
public abstract class OpstiDomenskiObjekat implements Serializable{
    
    public abstract String tabela();
    public abstract String naziviIVrednostiAtributa();
    public abstract String primarniKljuc();
    public abstract String uslovZaListu();
    public abstract void postaviPK(int pk);
    public abstract OpstiDomenskiObjekat postaviVrednostiAtributa(ResultSet rs) throws SQLException;
    public abstract String vrednostiZaIzmenu();
    public abstract String join();
}
