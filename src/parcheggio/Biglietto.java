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
public class Biglietto {

    private Orario oraArrivo;
    private Orario oraUscita;

    public Biglietto() {
    }
    
    public Biglietto(Orario oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public Orario getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(Orario oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public Orario getOraUscita() {
        return oraUscita;
    }

    public boolean setOraUscita(Orario oraUscita) {
        if(Orario.isO1majO2(oraArrivo, oraUscita)){
            return false;
        }
        this.oraUscita = oraUscita;
        return true;
    }
    
    public float oreTot(){
        float min = oraUscita.getOre()-oraArrivo.getOre();
        min*=60;
        min+= (oraUscita.getMinuti()-oraUscita.getMinuti());
        return min/=60;
    }

}
