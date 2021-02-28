/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author shreyascr
 */
public class VitalSigns {
 int respRate;
     int heartRate;
     int bP;
     float weightKG;
     float wieghtPd;
    public int getRespRate() {
        return respRate;
    }

    public void setRespRate(int respRate) {
        this.respRate = respRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getbP() {
        return bP;
    }

    public void setbP(int bP) {
        this.bP = bP;
    }

    public float getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(float weightKG) {
        this.weightKG = weightKG;
    }

    public float getWieghtPd() {
        return wieghtPd;
    }

    public void setWieghtPd(float wieghtPd) {
        this.wieghtPd = wieghtPd;
    }

    public VitalSigns(int respRate, int heartRate, int bP, float weightKG, float wieghtPd) {
        this.respRate = respRate;
        this.heartRate = heartRate;
        this.bP = bP;
        this.weightKG = weightKG;
        this.wieghtPd = wieghtPd;
    }

    public VitalSigns() {
    }

    

   

    
}
