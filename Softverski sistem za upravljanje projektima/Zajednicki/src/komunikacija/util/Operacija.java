/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package komunikacija.util;

/**
 *
 * @author relja
 */
public interface Operacija {

    public static final int LOGOUT = 0;
    public static final int LOGIN = 1;
    
    public static final int UCITAJ_PROJEKAT = 2;
    public static final int UCITAJ_ZADATAK = 3;
    public static final int UCITAJ_ZADUZENJE = 4;
    
    public static final int OBRISI_PROJEKAT = 5;
    public static final int OBRISI_ZADATAK = 6;
    public static final int OBRISI_ZADUZENJE = 7;
    
    public static final int IZMENI_ZADATAK = 8;
    public static final int IZMENI_ZADUZENJE = 9;
    
    public static final int ZAPAMTI_PROJEKAT = 10;
    public static final int ZAPAMTI_ZADATAK = 11;
    public static final int ZAPAMTI_ZADUZENJE = 12;
    
    public static final int UCITAJ_LISTU_SVIH_PROJEKATA = 13;
    public static final int UCITAJ_LISTU_SVIH_ZADATAKA = 14;
    public static final int UCITAJ_LISTU_SVIH_ZADUZENJA = 15;
    public static final int UCITAJ_LISTU_SVIH_ZAPOSLENIH = 16;
    
    public static final int PRETRAZI_PROJEKTE = 17;
    
    public static final int UCITAJ_ULOGU = 18;
    public static final int UCITAJ_DOZVOLE = 19;

}
