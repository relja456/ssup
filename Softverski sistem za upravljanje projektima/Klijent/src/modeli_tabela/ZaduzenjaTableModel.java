/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli_tabela;

import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author relja
 */
public class ZaduzenjaTableModel extends AbstractTableModel {

    List<Zaduzenje> zaduzenja;
    String[] imenaKolona = {"Ime i prezime", "Naziv", "Opis", "Datum pocetka"};

    public ZaduzenjaTableModel(List<Zaduzenje> zaduzenja) {
        this.zaduzenja = zaduzenja;
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    @Override
    public int getRowCount() {
        return zaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ((Zaduzenje) zaduzenja.get(rowIndex)).getZaposleni().getImePrezime();
            case 1:
                return ((Zaduzenje) zaduzenja.get(rowIndex)).getNaziv();
            case 2:
                return ((Zaduzenje) zaduzenja.get(rowIndex)).getOpis();
            case 3:
                return ((Zaduzenje) zaduzenja.get(rowIndex)).getDatumPocetka();
            default:
                throw new AssertionError();
        }
    }

}
