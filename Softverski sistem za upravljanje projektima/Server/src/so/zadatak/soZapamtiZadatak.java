/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zadatak;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import so.ApstraktnaSO;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soZapamtiZadatak extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (obj == null) {
            throw new Exception("Projekat je null!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.dodaj(obj));
    }
    
}
