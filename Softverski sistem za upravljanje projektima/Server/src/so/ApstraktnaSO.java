/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DatabaseBroker;
import baza.DatabaseConnection;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author relja
 */
public abstract class ApstraktnaSO {

    protected DatabaseBroker dbbr;
    private Object result;

    public ApstraktnaSO() {
        dbbr = new DatabaseBroker();
    }

    public void templateExecute(OpstiDomenskiObjekat obj) throws SQLException, Exception {
        try {
            validate(obj);
            execute(obj);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }

    //mora ih implementirati svaka klasa SO
    protected abstract void validate(OpstiDomenskiObjekat obj) throws Exception;

    protected abstract void execute(OpstiDomenskiObjekat obj) throws Exception;

    protected void commit() throws SQLException {
        DatabaseConnection.getInstance().commit();
    }

    protected void rollback() throws SQLException {
        DatabaseConnection.getInstance().rollback();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    
}
