/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Dozvola;
import domen.DozvolaUloge;
import domen.Projekat;
import domen.Uloga;
import domen.Zadatak;
import domen.Zaduzenje;
import domen.Zaposleni;
import komunikacija.Receiver;
import komunikacija.Sender;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import komunikacija.Zahtev;
import komunikacija.Odgovor;
import komunikacija.util.Operacija;

/**
 *
 * @author relja
 */
public class KlijentKontroler {

    Socket socket;
    Sender sender;
    Receiver receiver;

    Zahtev zahtev;
    Odgovor odgovor;

    private Zaposleni zaposleni;

    static KlijentKontroler instance;

    public KlijentKontroler() throws IOException {
        socket = new Socket("127.0.0.1", 9090);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static KlijentKontroler getInstance() throws IOException {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    //-----------------LOGOUT---------------------
    public void logout() {
        zahtev = new Zahtev(Operacija.LOGOUT, null);
        sender.send(zahtev);
    }
    //-------------------------------------------

    //----------------ZAPOSLENI-------------------
    public Zaposleni login(Zaposleni zaposleni) throws Exception {
        zahtev = new Zahtev(Operacija.LOGIN, zaposleni);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Zaposleni) odgovor.getData();
    }

    public List<Zaposleni> vratiListuSvihZaposlenih(Zaposleni zaposleni) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_LISTU_SVIH_ZAPOSLENIH, zaposleni);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Zaposleni>) odgovor.getData();
    }
    //-------------------------------------------------

    //--------------------PROJEKAT-----------------------
    public Projekat ucitajProjekat(Projekat projekat) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_PROJEKAT, projekat);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Projekat) odgovor.getData();
    }

    public List<Projekat> vratiListuSvihProjekata(Projekat projekat) throws Exception {
        Zahtev request = new Zahtev(Operacija.UCITAJ_LISTU_SVIH_PROJEKATA, projekat);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Projekat>) odgovor.getData();
    }

    public List<Projekat> pretraziProjekte(Projekat projekat) throws Exception {
        Zahtev request = new Zahtev(Operacija.PRETRAZI_PROJEKTE, projekat);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Projekat>) odgovor.getData();
    }

    public void obrisiProjekat(Projekat projekat) throws Exception {
        Zahtev request = new Zahtev(Operacija.OBRISI_PROJEKAT, projekat);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }

    public void zapamtiProjekat(Projekat projekat) throws Exception {
        Zahtev request = new Zahtev(Operacija.ZAPAMTI_PROJEKAT, projekat);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }
    //-------------------------------------------------

    ////---------------------ZADATAK-----------------------
    public Zadatak ucitajZadatak(Zadatak zadatak) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_ZADATAK, zadatak);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Zadatak) odgovor.getData();
    }

    public List<Zadatak> vratiListuSvihZadataka(Zadatak zadatak) throws Exception {
        Zahtev request = new Zahtev(Operacija.UCITAJ_LISTU_SVIH_ZADATAKA, zadatak);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Zadatak>) odgovor.getData();
    }

    public void obrisiZadatak(Zadatak zadatak) throws Exception {
        Zahtev request = new Zahtev(Operacija.OBRISI_ZADATAK, zadatak);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }

    public void izmeniZadatak(Zadatak zadatak) throws Exception {
        Zahtev request = new Zahtev(Operacija.IZMENI_ZADATAK, zadatak);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }

    public void zapamtiZadatak(Zadatak zadatak) throws Exception {
        Zahtev request = new Zahtev(Operacija.ZAPAMTI_ZADATAK, zadatak);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }
    //-------------------------------------------------

    //------------------ZADUZENJE-------------------------------
    public Zaduzenje ucitajZaduzenje(Zaduzenje zaduzenje) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_ZADUZENJE, zaduzenje);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Zaduzenje) odgovor.getData();
    }

    public List<Zaduzenje> vratiListuSvihZaduzenja(Zaduzenje zaduzenje) throws Exception {
        Zahtev request = new Zahtev(Operacija.UCITAJ_LISTU_SVIH_ZADUZENJA, zaduzenje);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Zaduzenje>) odgovor.getData();
    }

    public void izmeniZaduzenje(Zaduzenje zaduzenje) throws Exception {
        Zahtev request = new Zahtev(Operacija.IZMENI_ZADUZENJE, zaduzenje);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }

    public void zapamtiZaduzenje(Zaduzenje zaduzenje) throws Exception {
        Zahtev request = new Zahtev(Operacija.ZAPAMTI_ZADUZENJE, zaduzenje);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }

    public void obrisiZaduzenje(Zaduzenje zaduzenje) throws Exception {
        Zahtev request = new Zahtev(Operacija.OBRISI_ZADUZENJE, zaduzenje);
        sender.send(request);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
    }
    //--------------------------------------------------------------

    public Uloga ucitajUlogu(Uloga uloga) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_ULOGU, uloga);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (Uloga) odgovor.getData();
    }

    public List<Dozvola> ucitajDozvoleZaUlogu(DozvolaUloge dozvolaUloge) throws Exception {
        zahtev = new Zahtev(Operacija.UCITAJ_DOZVOLE, dozvolaUloge);
        sender.send(zahtev);
        odgovor = (Odgovor) receiver.receive();
        if (odgovor.getException() != null) {
            throw odgovor.getException();
        }
        return (List<Dozvola>) odgovor.getData();
    }
}
