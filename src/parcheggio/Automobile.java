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
public class Automobile extends Veicolo {

    private int nSportelli;

    public Automobile() {
        super(4);
    }

    public int getnSportelli() {
        return nSportelli;
    }

    public void setnSportelli(int nSportelli) {
        this.nSportelli = nSportelli;
    }

    @Override
    public void stampaInfo(){
        System.out.println("|AUTOMOBILE| Targa: "+getTarga()+" Sportelli: "+nSportelli+" Orario entrata: "+getBiglietto().getOraArrivo());
    }
}
