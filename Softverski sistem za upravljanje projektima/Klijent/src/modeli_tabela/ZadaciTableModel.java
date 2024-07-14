/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli_tabela;

import domen.OpstiDomenskiObjekat;
import domen.Zadatak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author relja
 */
public class ZadaciTableModel extends AbstractTableModel {

    List<Zadatak> zadaci;
    String[] imenaKolona = {"Naziv", "Opis"};

    public ZadaciTableModel(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    @Override
    public int getRowCount() {
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return zadaci.get(rowIndex).getNaziv();
            case 1:
                return zadaci.get(rowIndex).getOpis();
            default:
                throw new AssertionError();
        }
    }

}
