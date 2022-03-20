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
public class Orario {
    private int ore;
    private int minuti;

    public Orario() {
        this.ore = 0;
        this.minuti = 0;
    }  
    
    public Orario(int ore, int minuti) {
        this.ore = ore;
        this.minuti = minuti;
    }

    public static boolean isO1majO2(Orario o1, Orario o2){
        if(o1.ore > o2.ore){
            return true;
        }else if(o1.ore == o2.ore){
            if(o1.minuti>o2.minuti){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static boolean validaOrario(int ore, int minuti){
        if(ore < 0 || ore >= 24 || minuti < 0 || minuti >= 60){
            return false;
        }
        return true;
    }
    
    public boolean validaOrario(){
        if(this.ore < 0 || this.ore >= 24 || this.minuti < 0 || this.minuti >= 60){
            return false;
        }
        return true;
    }
    
    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    @Override
    public String toString() {
        return ore+":"+minuti;
    }
    
}
