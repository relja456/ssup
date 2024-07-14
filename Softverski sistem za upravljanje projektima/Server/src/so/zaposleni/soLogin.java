/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soLogin extends ApstraktnaSO {

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (!(obj instanceof Zaposleni)) {
            throw new Exception("Objekat nije tipa Zaposleni!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult((Zaposleni) dbbr.vrati(obj));
    }

}
