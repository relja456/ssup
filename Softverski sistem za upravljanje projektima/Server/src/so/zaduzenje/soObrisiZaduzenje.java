/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaduzenje;

import domen.OpstiDomenskiObjekat;
import domen.Zaduzenje;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soObrisiZaduzenje extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (!(obj instanceof Zaduzenje)) {
            throw new Exception("Objekat nije tipa zaduzenje!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.obrisi(obj));
    }
    
}
