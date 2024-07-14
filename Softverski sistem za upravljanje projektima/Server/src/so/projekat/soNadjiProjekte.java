/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.projekat;

import domen.OpstiDomenskiObjekat;
import domen.Projekat;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import so.ApstraktnaSO;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soNadjiProjekte extends ApstraktnaSO {

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {
        if (!(obj instanceof Projekat)) {
            throw new Exception("Objekat nije tipa Projekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {

        List<Projekat> projekti = new ArrayList<>();

        List<OpstiDomenskiObjekat> odoLista = dbbr.vratiListuSvih(obj);

        for (OpstiDomenskiObjekat odo : odoLista) {
            projekti.add((Projekat) odo);
        }

        setResult(projekti);

    }

}
