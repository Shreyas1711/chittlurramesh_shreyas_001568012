/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;
/**
 *
 * @author shreyascr
 */
public class EncounterHistory {
    public ArrayList<Encounter> encounterList;
//Encounter encounter;

       public EncounterHistory() {
        this.encounterList =new ArrayList<Encounter>();
    }

    public ArrayList<Encounter> getEncounters() {
        return encounterList;
    }

    public void setEncounters(Encounter encounters) {
        encounterList.add(encounters);
    }

    

    

}
