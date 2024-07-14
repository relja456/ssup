/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zadatak;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import domen.Zadatak;
import domen.Zaduzenje;
import so.ApstraktnaSO;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soObrisiZadatak extends ApstraktnaSO {

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (!(obj instanceof Zadatak)) {
            throw new Exception("Objekat nije tipa Zadatak!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.obrisi(obj));
    }

}
