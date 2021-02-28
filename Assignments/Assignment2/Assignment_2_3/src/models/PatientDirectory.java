/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;

/**
 *
 * @author shreyascr
 */
public class PatientDirectory {
    
    static HashMap<String, Patient> patientHash = new HashMap<String, Patient>();

    public static HashMap<String, Patient> getPatientHash() {
        return patientHash;
    }

    public static void setPatientHash(HashMap<String, Patient> patientHash) {
        PatientDirectory.patientHash = patientHash;
    }
    
}
