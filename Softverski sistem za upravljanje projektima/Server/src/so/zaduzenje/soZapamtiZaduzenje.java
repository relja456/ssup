/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaduzenje;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import so.ApstraktnaSO;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soZapamtiZaduzenje extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (obj == null) {
            throw new Exception("Zaduzenje je null!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.dodaj(obj));
    }
    
}
