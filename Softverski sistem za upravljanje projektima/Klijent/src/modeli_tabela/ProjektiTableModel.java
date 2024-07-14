/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli_tabela;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author relja
 */
public class ProjektiTableModel extends AbstractTableModel{

    List<Projekat> projekti;
    String[] imenaKolona = {"Naziv", "Opis", "Datum pocetka"};
    
    public ProjektiTableModel(List<Projekat> projekti) {
        this.projekti = projekti;
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }
    
    @Override
    public int getRowCount() {
        return projekti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return projekti.get(rowIndex).getNaziv();
            case 1:
                return projekti.get(rowIndex).getOpis();
            case 2:
                return projekti.get(rowIndex).getDatumPocetka();
            default:
                throw new AssertionError();
        }
    }
    
}
