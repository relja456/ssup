/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Dozvola;
import domen.DozvolaUloge;
import domen.Projekat;
import domen.Uloga;
import domen.Zadatak;
import domen.Zaduzenje;
import domen.Zaposleni;
import java.io.IOException;
import komunikacija.Receiver;
import komunikacija.Zahtev;
import komunikacija.Sender;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.util.Operacija;
import logika.ServerKontroler;

/**
 *
 * @author relja
 */
public class KlijentskaNit extends Thread {

    Socket socket;

    Sender sender;
    Receiver receiver;

    Zahtev zahtev;
    Odgovor odgovor;

    Zaposleni zaposleni;

    public KlijentskaNit(Socket socket) throws IOException {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);

        start();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                if (prijem()) {

                    odgovor = new Odgovor();

                    try {
                        switch (zahtev.getOperacija()) {
                            case Operacija.LOGOUT -> {

                                ServerKontroler.getInstance().logout(this, this.zaposleni);
                                ServerKontroler.getInstance().getServerForma().popuniTabelu();
                                interrupt();

                            }
                            case Operacija.LOGIN -> {

                                Zaposleni zaposleni = (Zaposleni) zahtev.getArgument();
                                zaposleni = (Zaposleni) ServerKontroler.getInstance().login(zaposleni);

                                if (zaposleni == null) {
                                    throw new Exception("Ne postoji korisnik sa ovim kredencijalima!");
                                }
                                
                                //uspesno logovanje
                                if (!ServerKontroler.getInstance().vecUlogovan(zaposleni, this)) {

                                    Uloga uloga = (Uloga) ServerKontroler.getInstance().ucitajUlogu(zaposleni.getUloga());

                                    DozvolaUloge dozvolaUloge = new DozvolaUloge(null, uloga);
                                    List<Dozvola> dozvole = (List<Dozvola>) ServerKontroler.getInstance().ucitajDozvole(dozvolaUloge);
                                    
                                    zaposleni.setUloga(uloga);
                                    zaposleni.getUloga().setDozvole(dozvole);

                                    odgovor.setData(zaposleni);
                                    this.zaposleni = zaposleni;
                                    
                                    ServerKontroler.getInstance().dodajNitDodajZaposlenog(this, zaposleni);
                                    ServerKontroler.getInstance().getServerForma().popuniTabelu();
                                    
                                } else {
                                    throw new Exception("Vec je ulogovan ovaj korisnik");
                                }
                            }
                            case Operacija.UCITAJ_LISTU_SVIH_ZAPOSLENIH -> {

                                Zaposleni zap = (Zaposleni) zahtev.getArgument();
                                List<Zaposleni> zaposleni = (List<Zaposleni>) ServerKontroler.getInstance().vratiSveZaposlene(zap);
                                odgovor.setData(zaposleni);

                            }
                            case Operacija.UCITAJ_PROJEKAT -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Projekat projekat = (Projekat) zahtev.getArgument();
                                    projekat = (Projekat) ServerKontroler.getInstance().ucitajProjekat(projekat);
                                    odgovor.setData(projekat);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.UCITAJ_LISTU_SVIH_PROJEKATA -> {

                                Projekat projekat = (Projekat) zahtev.getArgument();
                                List<Projekat> projekti = (List<Projekat>) ServerKontroler.getInstance().vratiSveProjekte(projekat);
                                odgovor.setData(projekti);

                            }
                            case Operacija.PRETRAZI_PROJEKTE -> {

                                Projekat projekat = (Projekat) zahtev.getArgument();
                                List<Projekat> projekti = (List<Projekat>) ServerKontroler.getInstance().pretraziProjekte(projekat);
                                odgovor.setData(projekti);

                            }
                            case Operacija.OBRISI_PROJEKAT -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Projekat projekat = (Projekat) zahtev.getArgument();
                                    ServerKontroler.getInstance().obrisiProjekat(projekat);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.ZAPAMTI_PROJEKAT -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Projekat projekat = (Projekat) zahtev.getArgument();
                                    ServerKontroler.getInstance().zapamtiProjekat(projekat);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.UCITAJ_ZADATAK -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zadatak zadatak = (Zadatak) zahtev.getArgument();
                                    zadatak = (Zadatak) ServerKontroler.getInstance().ucitajZadatak(zadatak);
                                    odgovor.setData(zadatak);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.IZMENI_ZADATAK -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zadatak zadatak = (Zadatak) zahtev.getArgument();
                                    ServerKontroler.getInstance().izmeniZadatak(zadatak);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.UCITAJ_LISTU_SVIH_ZADATAKA -> {

                                Zadatak zadatak = (Zadatak) zahtev.getArgument();
                                List<Zadatak> zadaci = (List<Zadatak>) ServerKontroler.getInstance().vratiSveZadatke(zadatak);
                                odgovor.setData(zadaci);

                            }
                            case Operacija.OBRISI_ZADATAK -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zadatak zadatak = (Zadatak) zahtev.getArgument();
                                    ServerKontroler.getInstance().obrisiZadatak(zadatak);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.ZAPAMTI_ZADATAK -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zadatak zadatak = (Zadatak) zahtev.getArgument();
                                    ServerKontroler.getInstance().zapamtiZadatak(zadatak);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.UCITAJ_ZADUZENJE -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zaduzenje zaduzenje = (Zaduzenje) zahtev.getArgument();
                                    zaduzenje = (Zaduzenje) ServerKontroler.getInstance().ucitajZaduzenje(zaduzenje);
                                    odgovor.setData(zaduzenje);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.UCITAJ_LISTU_SVIH_ZADUZENJA -> {

                                Zaduzenje zaduzenje = (Zaduzenje) zahtev.getArgument();
                                List<Zaduzenje> zaduzenja = (List<Zaduzenje>) ServerKontroler.getInstance().vratiSvaZaduzenja(zaduzenje);
                                odgovor.setData(zaduzenja);

                            }
                            case Operacija.IZMENI_ZADUZENJE -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zaduzenje zaduzenje = (Zaduzenje) zahtev.getArgument();
                                    ServerKontroler.getInstance().izmeniZaduzenje(zaduzenje);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.ZAPAMTI_ZADUZENJE -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zaduzenje zaduzenje = (Zaduzenje) zahtev.getArgument();
                                    ServerKontroler.getInstance().zapamtiZaduzenje(zaduzenje);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                            case Operacija.OBRISI_ZADUZENJE -> {

                                if (this.zaposleni.imaDozvolu(zahtev.getOperacija())) {
                                    Zaduzenje zaduzenje = (Zaduzenje) zahtev.getArgument();
                                    ServerKontroler.getInstance().obrisiZaduzenje(zaduzenje);
                                } else {
                                    throw new Exception("Nemate dozvolu za ovom operacijom!");
                                }

                            }
                        }
                    } catch (Exception e) {
                        odgovor.setException(e);
                    }

                    sender.send(odgovor);
                }
            } catch (Exception ex) {
                Logger.getLogger(KlijentskaNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean prijem() throws Exception {
        zahtev = (Zahtev) receiver.receive();
        return zahtev != null;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void logout() {
        sender.send(new Zahtev(Operacija.LOGOUT, null));
    }

}
