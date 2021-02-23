/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_2;

import java.util.ArrayList;
import model.PediatricVitalSign;

/**
 *
 * @author shreyascr
 */
public class VitalSignsHistory {

    private ArrayList<PediatricVitalSign> vitalHistory;

    public VitalSignsHistory() {
        this.vitalHistory = new ArrayList<PediatricVitalSign>();
    }
    
   
    public ArrayList<PediatricVitalSign> getVitalHistory() {
        return vitalHistory;
    }

   

    public void setVitalHistory(ArrayList<PediatricVitalSign> vitalHistory) {
        this.vitalHistory = vitalHistory;
    }
    public PediatricVitalSign addVitals(){
       PediatricVitalSign newVitals = new PediatricVitalSign();
        vitalHistory.add(newVitals);
        return newVitals;
    } 
    
   
}
