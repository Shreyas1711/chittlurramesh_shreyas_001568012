/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javax.swing.text.html.ListView;

/**
 *
 * @author shreyascr
 */
public class Patient extends Person{
    EncounterHistory encounterHistory;
    
    @Override
    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }
    @Override
    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    
    
   
}
