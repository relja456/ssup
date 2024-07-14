/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author relja
 */
public class UlogovaniTableModel extends AbstractTableModel {

    List<Zaposleni> zaposleni = new ArrayList<>();

    public UlogovaniTableModel(List<Zaposleni> zaposleni) {
        this.zaposleni = zaposleni;
    }

    String[] kolone = {"Korisnicko ime", "Ime i prezime", "Kompanija", "Uloga"};

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public int getRowCount() {
        return zaposleni.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return zaposleni.get(rowIndex).getKorisnickoIme();
            case 1:
                return zaposleni.get(rowIndex).getImePrezime();
            case 2:
                return zaposleni.get(rowIndex).getKompanija().getNazivKompanije();
            case 3:
                return zaposleni.get(rowIndex).getUloga().getNaziv();
            default:
                throw new AssertionError();
        }
    }

}
