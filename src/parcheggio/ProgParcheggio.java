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
public class ProgParcheggio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Quanti posti ha il tuo parcheggio? ");
        Parcheggio parcheggio = new Parcheggio(Integer.parseInt(myObj.nextLine()));

        do {

            System.out.println("\n1) Aggiungi Automobile;\n2) Aggiungi Motociclo;\n3) Rimuovi Veicolo;\n4) Verifica disponibilità veicolo;\n5) Verifica parcheggi ancora disponibili\n6) Stampa informazioni parcheggio;\n7) Stampa informazioni veicolo;\n8) Ordina per orario di arrivo ;\n9) Ordina per tipo veicolo;\n10) Stampa solo automobili;\n11) Stampa solo motocicli\n0)Esci.");
            System.out.println("Inserire operazione: ");
            c = Integer.parseInt(myObj.nextLine());
            switch (c) {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    if (parcheggio.getPostiDisponibili() > 0) {
                        Automobile a = new Automobile();
                        System.out.println("Inserisci Targa: ");
                        String targa = myObj.nextLine();
                        if (parcheggio.isVeicoloPresente(targa)) {
                            System.out.println("Questa targa è stata già registrata");
                        } else {
                            a.setTarga(targa);

                            System.out.println("Inserisci Numero Sportelli: ");
                            a.setnSportelli(Integer.parseInt(myObj.nextLine()));

                            Orario p = new Orario();
                            System.out.println("Inserire ora entrata nel parcheggio: ");
                            p.setOre(Integer.parseInt(myObj.nextLine()));

                            System.out.println("Inserire minuti entrata nel parcheggio: ");
                            p.setMinuti(Integer.parseInt(myObj.nextLine()));
                            if (p.validaOrario()) {
                                parcheggio.aggiungiVeicolo(a, p);
                            } else {
                                System.out.println("Il formato orario non è valido");
                            }
                        }
                    } else {
                        System.out.println("Non c'è posto per poter aggiungere questa automobile");
                    }
                    break;
                case 2:
                    if (parcheggio.getPostiDisponibili() > 0) {
                        Motociclo m = new Motociclo();

                        System.out.println("Inserisci Targa: ");
                        String targa = myObj.nextLine();
                        if (parcheggio.isVeicoloPresente(targa)) {
                            System.out.println("Questa targa è stata già registrata");
                        } else {
                            m.setTarga(targa);
                            System.out.println("Inserisci NTempi: ");
                            m.setnTempi(Integer.parseInt(myObj.nextLine()));

                            Orario p = new Orario();
                            System.out.println("Inserire ora entrata nel parcheggio: ");
                            p.setOre(Integer.parseInt(myObj.nextLine()));

                            System.out.println("Inserire minuti entrata nel parcheggio: ");
                            p.setMinuti(Integer.parseInt(myObj.nextLine()));
                            if (p.validaOrario()) {
                                parcheggio.aggiungiVeicolo(m, p);
                            } else {
                                System.out.println("Il formato orario non è valido");
                            }
                        }
                    } else {
                        System.out.println("Non c'è posto per poter aggiungere questa automobile");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci targa del veicolo da rimuovere: ");
                    String t = myObj.nextLine();

                    if (parcheggio.isVeicoloPresente(t)) {
                        Orario p = new Orario();

                        System.out.println("Inserire ora uscita dal parcheggio: ");
                        p.setOre(Integer.parseInt(myObj.nextLine()));

                        System.out.println("Inserire minuti uscita dal parcheggio: ");
                        p.setMinuti(Integer.parseInt(myObj.nextLine()));

                        if (p.validaOrario()) {
                            if (Orario.isO1majO2(p, parcheggio.getVeicolo(t).getBiglietto().getOraArrivo())) {
                                Veicolo veicoloRimosso = parcheggio.rimuoviVeicolo(t, p);
                                System.out.println("Veicolo rimosso correttamente");
                                System.out.println("Ore permanenza: " + veicoloRimosso.getBiglietto().oreTot() + " Prezzo da pagare: " + parcheggio.getPrezzo(veicoloRimosso));
                            } else {
                                System.out.println("L'orario di uscita non può essere avvenuto prima dell'orario di entrata");
                            }
                        } else {
                            System.out.println("Il formato orario non è valido");
                        }
                    } else {
                        System.out.println("Questo veicolo non è presente nel parcheggio");
                    }
                    break;
                case 4:
                    System.out.println("Inserisci targa del veicolo da cercare: ");
                    String targa = myObj.nextLine();

                    if (parcheggio.isVeicoloPresente(targa)) {
                        System.out.println("Il veicolo a targa " + targa + " è presente: ");
                    } else {
                        System.out.println("Il veicolo non è presente");
                    }
                    break;
                case 5:
                    System.out.println("Sono disponibili " + parcheggio.getPostiDisponibili() + " posti");
                    break;
                case 6:
                    parcheggio.stampaInformazioniParcheggio();
                    break;
                case 7:
                    System.out.println("Inserisci targa del veicolo da visualizzare: ");
                    targa = myObj.nextLine();

                    if (parcheggio.isVeicoloPresente(targa)) {
                        parcheggio.getVeicolo(targa).stampaInfo();
                    } else {
                        System.out.println("Il veicolo non è presente");
                    }
                    break;
                case 8:
                    parcheggio.ordinaPerOrario();
                    parcheggio.stampaInformazioniParcheggio();
                    break;
                case 9:
                    parcheggio.ordinaPerTipo();
                    parcheggio.stampaInformazioniParcheggio();
                    break;
                case 10:
                    if (parcheggio.stampaTipo(true) == 0) {
                        System.out.println("Non è stata inserita alcuna macchina");
                    }
                    break;
                case 11:
                    if (parcheggio.stampaTipo(false) == 0) {
                        System.out.println("Non è stata inserita alcun motociclo");
                    }
                    break;
                default:
                    System.out.println("Errore, reinserire");
                    break;
            }

        } while (c != 0);
    }

}
