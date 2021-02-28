/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author shreyascr
 */
public class Encounter {
    public String docName;
    public Date visit;
    public String reason;
    VitalSigns vitalSigns;

    public Encounter(String docName, Date visit, String reason, VitalSigns vitalSigns) {
        this.docName = docName;
        this.visit = visit;
        this.reason = reason;
        this.vitalSigns = vitalSigns;
    }

    public Encounter() {
    }

   

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
   
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Date getVisit() {
        return visit;
    }

    public void setVisit(Date visit) {
        this.visit = visit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
