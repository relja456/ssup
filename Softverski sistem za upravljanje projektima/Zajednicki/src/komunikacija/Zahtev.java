/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import komunikacija.util.Operacija;
import java.io.Serializable;

/**
 *
 * @author relja
 */
public class Zahtev implements Serializable {

    private int operacija;
    private Object argument;

    public Zahtev() {
    }

    public Zahtev(int operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

}
