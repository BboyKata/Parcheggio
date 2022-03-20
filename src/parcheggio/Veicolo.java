/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author Studente
 */
public class Veicolo {

    private String targa;
    private int nRuote;
    private Biglietto biglietto;

    public Veicolo(int nRuote) {
        biglietto = new Biglietto();
        this.nRuote = nRuote;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void daiBiglietto(Orario oraArrivo) {
        this.biglietto.setOraArrivo(oraArrivo);
    }

    public void restituisciBiglietto(Orario oraUscita) {
        this.biglietto.setOraUscita(oraUscita);
    }

    public void stampaInfo(){
        System.out.println("Targa: "+getTarga()+" Orario entrata: "+getBiglietto().getOraArrivo());
    }
}
