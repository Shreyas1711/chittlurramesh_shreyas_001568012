/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty.Alumni;

import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author psrib
 */
public class AlumniDirectory {
    

    ArrayList<Alumni> ad ;
    HashMap<String, Alumni> adm = new HashMap<>();
    Department department;
    
    public HashMap<String, Alumni> getAdm(String id) {
        
           
        return adm;
    }

    public void setAdm(HashMap<String, Alumni> adm) {
        this.adm = adm;
    }

    public ArrayList<Alumni> getAd() {
        return ad;
    }

    public void setAd(ArrayList<Alumni> ad) {
        this.ad = ad;
    }
     
     
     
}
