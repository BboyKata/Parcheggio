/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.util.Scanner;

/**
 *
 * @author Studente
 */
public class Parcheggio {

    private Veicolo parcheggio[];
    private int cont;

    public Parcheggio(int N) {
        parcheggio = new Veicolo[N];
    }

    public boolean aggiungiVeicolo(Veicolo v, Orario oraEntrata) {
        if (cont < parcheggio.length) {
            v.daiBiglietto(oraEntrata);
            parcheggio[cont] = v;
            cont++;
            return true;
        }
        return false;

    }

    public boolean isVeicoloPresente(String targa) {
        for (int i = 0; i < cont; i++) {
            if (parcheggio[i].getTarga().equals(targa)) {
                return true;
            }
        }
        return false;
    }

    private int indiceVeicolo(String targa) {
        for (int i = 0; i < cont; i++) {
            if (parcheggio[i].getTarga().equals(targa)) {
                return i;
            }
        }
        return -1;
    }

    private void scalaVeicoli() {
        for (int j = 0; j < parcheggio.length; j++) {
            if (parcheggio[j] == null) {
                for (int k = j; k < parcheggio.length - 1; k++) {
                    if (parcheggio[k + 1] != null) {
                        parcheggio[k] = parcheggio[k + 1];
                    }
                }
            }
        }
    }

    public int getPostiDisponibili() {
        return parcheggio.length - cont;
    }

    public Veicolo rimuoviVeicolo(String targa, Orario oraUscita) {

        parcheggio[indiceVeicolo(targa)].restituisciBiglietto(oraUscita);
        Veicolo v = parcheggio[indiceVeicolo(targa)];

        parcheggio[indiceVeicolo(targa)] = null;
        scalaVeicoli();
        cont--;
        parcheggio[cont] = null;
        return v;
    }

    public Veicolo getVeicolo(String targa) {
        return parcheggio[indiceVeicolo(targa)];
    }

    public float getPrezzo(Veicolo v) {
        if (v instanceof Motociclo) {
            return (v.getBiglietto().oreTot() * 2.5f);
        } else {
            return (v.getBiglietto().oreTot() * 4);
        }
    }

    public void ordinaPerOrario() {
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < cont - i - 1; j++) {
                if (Orario.isO1majO2(parcheggio[j].getBiglietto().getOraArrivo(), parcheggio[j + 1].getBiglietto().getOraArrivo())) {
                    Veicolo temp = parcheggio[j];
                    parcheggio[j] = parcheggio[j + 1];
                    parcheggio[j + 1] = temp;
                }
            }
        }
    }

    public void ordinaPerTipo() {
        if (parcheggio[0] instanceof Motociclo) {
            for (int i = 1; i < cont; i++) {
                if (parcheggio[i] instanceof Automobile) {
                    for (int j = i; j < cont; j++) {
                        if (parcheggio[j] instanceof Motociclo) {
                            Veicolo temp = parcheggio[i];
                            parcheggio[i] = parcheggio[j];
                            parcheggio[j] = temp;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < cont; i++) {
                if (parcheggio[i] instanceof Motociclo) {
                    for (int j = i; j < cont; j++) {
                        if (parcheggio[j] instanceof Automobile) {
                            Veicolo temp = parcheggio[i];
                            parcheggio[i] = parcheggio[j];
                            parcheggio[j] = temp;
                        }
                    }
                }
            }
        }
    }

    public void stampaInformazioniParcheggio() {
        System.out.println("Posti occupati:  " + cont + " Posti disponibili: " + getPostiDisponibili());
        for (int i = 0; i < parcheggio.length; i++) {
            if (parcheggio[i] == null) {
                System.out.println("|POSTO LIBERO|");
            } else {
                parcheggio[i].stampaInfo();
            }
        }
    }

    public int stampaTipo(boolean isAuto) {
        int n = 0;
        if (isAuto) {
            for (int i = 0; i < cont; i++) {
                if (parcheggio[i] instanceof Automobile) {
                    parcheggio[i].stampaInfo();
                    n++;
                }
            }
        }else{
            for (int i = 0; i < cont; i++) {
                if (parcheggio[i] instanceof Motociclo) {
                    parcheggio[i].stampaInfo();
                    n++;
                }
            }
        }
        return n;
    }
}
