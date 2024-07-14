/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.projekat;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import so.ApstraktnaSO;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soObrisiProjekat extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        //TODO videti za validaciju kada, kako i gde ide!!!!
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.obrisi(obj));
    }
    
}
