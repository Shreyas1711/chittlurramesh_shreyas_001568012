/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author shreyascr
 */
public class PediatricVitalSign {
    
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
   
    private int respRate;
    private int heartRate;
    private int bP;
    private float weightKG;
    private float wieghtPd;

   
    
 

   

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

    public void setWeightKG(int weightKG) {
        this.weightKG = weightKG;
    }

    public float getWieghtPd() {
        return wieghtPd;
    }

    public void setWieghtPd(int wieghtPd) {
        this.wieghtPd = wieghtPd;
    }

   
}
