/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.dozvola;

import domen.OpstiDomenskiObjekat;
import so.ApstraktnaSO;

/**
 *
 * @author relja
 */
public class soUcitajDozvole extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat obj) throws Exception {

    }

    @Override
    protected void execute(OpstiDomenskiObjekat obj) throws Exception {
        setResult(dbbr.vratiListuSvih(obj));
    }
    
}
