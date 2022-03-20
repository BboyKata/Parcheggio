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
public class Motociclo extends Veicolo {
    private int nTempi;

    public Motociclo() {
        super(2);
    }

    public int getnTempi() {
        return nTempi;
    }

    public void setnTempi(int nTempi) {
        this.nTempi = nTempi;
    }
    
    @Override
    public void stampaInfo(){
        System.out.println("|MOTOCICLO| Targa: "+getTarga()+" N Tempi: "+nTempi+" Orario entrata: "+getBiglietto().getOraArrivo());
    }
    
}
