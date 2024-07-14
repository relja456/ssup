/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import baza.DatabaseBroker;
import domen.Projekat;
import domen.Zadatak;
import domen.Zaduzenje;
import domen.Zaposleni;
import forme.ServerForma;
import java.util.ArrayList;
import java.util.List;
import niti.KlijentskaNit;
import so.projekat.soNadjiProjekte;
import so.projekat.soObrisiProjekat;
import so.projekat.soUcitajListuSvihProjekata;
import so.projekat.soUcitajProjekat;
import so.projekat.soZapamtiProjekat;
import so.zadatak.soIzmeniZadatak;
import so.zadatak.soObrisiZadatak;
import so.zadatak.soUcitajListuSvihZadataka;
import so.zadatak.soUcitajZadatak;
import so.zadatak.soZapamtiZadatak;
import so.zaduzenje.soIzmeniZaduzenje;
import so.zaduzenje.soObrisiZaduzenje;
import so.zaduzenje.soUcitajListuSvihZaduzenja;
import so.zaduzenje.soUcitajZaduzenje;
import so.zaduzenje.soZapamtiZaduzenje;
import so.zaposleni.soLogin;
import so.zaposleni.soUcitajListuSvihZaposlenih;

/**
 *
 * @author relja
 */
public class ServerKontroler {

    public static ServerKontroler instance;
    DatabaseBroker db;

    List<Zaposleni> ulogovani = new ArrayList<>();
    List<KlijentskaNit> povezaneNiti = new ArrayList<>();

    private ServerForma serverForma;

    public ServerKontroler() {
        db = new DatabaseBroker();
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public boolean vecUlogovan(Zaposleni zaposleni, KlijentskaNit kn) {
        if (ulogovani == null || ulogovani.isEmpty()) {
            ulogovani.add(zaposleni);
            povezaneNiti.add(kn);
            return false;
        }
        for (Zaposleni z : ulogovani) {
            if (z.equals(zaposleni)) {
                return true;
            }
        }
        ulogovani.add(zaposleni);
        povezaneNiti.add(kn);
        return false;
    }

    public void logout(KlijentskaNit kn, Zaposleni zaposleni) {
        for (int i = 0; i < povezaneNiti.size(); i++) {
            if (kn.equals(povezaneNiti.get(i))) {
                povezaneNiti.remove(i);
            }
        }
        for (int i = 0; i < ulogovani.size(); i++) {
            if (zaposleni.equals(ulogovani.get(i))) {
                ulogovani.remove(i);
            }
        }
    }

    public Object login(Zaposleni zaposleni) throws Exception {
        soLogin so = new soLogin();
        so.templateExecute(zaposleni);
        return so.getResult();
    }

    public Object vratiSveZaposlene(Zaposleni zaposleni) throws Exception {
        soUcitajListuSvihZaposlenih so = new soUcitajListuSvihZaposlenih();
        so.templateExecute(zaposleni);
        return so.getResult();
    }

    public Object ucitajProjekat(Projekat projekat) throws Exception {
        soUcitajProjekat so = new soUcitajProjekat();
        so.templateExecute(projekat);
        return so.getResult();
    }

    public Object vratiSveProjekte(Projekat projekat) throws Exception {
        soUcitajListuSvihProjekata so = new soUcitajListuSvihProjekata();
        so.templateExecute(projekat);
        return so.getResult();
    }

    public Object pretraziProjekte(Projekat projekat) throws Exception {
        soNadjiProjekte so = new soNadjiProjekte();
        so.templateExecute(projekat);
        return so.getResult();
    }

    public void obrisiProjekat(Projekat projekat) throws Exception {
        soObrisiProjekat so = new soObrisiProjekat();
        so.templateExecute(projekat);
    }

    public void zapamtiProjekat(Projekat projekat) throws Exception {
        soZapamtiProjekat so = new soZapamtiProjekat();
        so.templateExecute(projekat);
    }

    public Object ucitajZadatak(Zadatak zadatak) throws Exception {
        soUcitajZadatak so = new soUcitajZadatak();
        so.templateExecute(zadatak);
        return so.getResult();
    }

    public Object vratiSveZadatke(Zadatak zadatak) throws Exception {
        soUcitajListuSvihZadataka so = new soUcitajListuSvihZadataka();
        so.templateExecute(zadatak);
        return so.getResult();
    }

    public void obrisiZadatak(Zadatak zadatak) throws Exception {
        soObrisiZadatak so = new soObrisiZadatak();
        so.templateExecute(zadatak);
    }

    public void izmeniZadatak(Zadatak zadatak) throws Exception {
        soIzmeniZadatak so = new soIzmeniZadatak();
        so.templateExecute(zadatak);
    }

    public void zapamtiZadatak(Zadatak zadatak) throws Exception {
        soZapamtiZadatak so = new soZapamtiZadatak();
        so.templateExecute(zadatak);
    }

    public Object ucitajZaduzenje(Zaduzenje zaduzenje) throws Exception {
        soUcitajZaduzenje so = new soUcitajZaduzenje();
        so.templateExecute(zaduzenje);
        return so.getResult();
    }

    public Object vratiSvaZaduzenja(Zaduzenje zaduzenje) throws Exception {
        soUcitajListuSvihZaduzenja so = new soUcitajListuSvihZaduzenja();
        so.templateExecute(zaduzenje);
        return so.getResult();
    }

    public void izmeniZaduzenje(Zaduzenje zaduzenje) throws Exception {
        soIzmeniZaduzenje so = new soIzmeniZaduzenje();
        so.templateExecute(zaduzenje);
    }

    public void zapamtiZaduzenje(Zaduzenje zaduzenje) throws Exception {
        soZapamtiZaduzenje so = new soZapamtiZaduzenje();
        so.templateExecute(zaduzenje);
    }

    public void obrisiZaduzenje(Zaduzenje zaduzenje) throws Exception {
        soObrisiZaduzenje so = new soObrisiZaduzenje();
        so.templateExecute(zaduzenje);
    }

    public List<KlijentskaNit> getPovezaneNiti() {
        return povezaneNiti;
    }

    public List<Zaposleni> getUlogovani() {
        return ulogovani;
    }

    public ServerForma getServerForma() {
        return serverForma;
    }

    public void setServerForma(ServerForma serverForma) {
        this.serverForma = serverForma;
    }

    public void izlogujSve() {
        if (povezaneNiti != null && !povezaneNiti.isEmpty()) {
            for (KlijentskaNit kn : povezaneNiti) {
                kn.logout();
            }
        }
    }

}
