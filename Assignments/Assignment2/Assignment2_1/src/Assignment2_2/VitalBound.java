/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_2;

/**
 *
 * @author shreyascr
 */


public class VitalBound {
     private static int respRateLB;
    private static int respRateUB;
    private static int heartRateLB;
    private static int heartRateUB;
    private static int bPLB;
    private static int bPUB;
    private static float wKgLB;
    private static float wKgUB;
    private static float wPdLB;
    private static float wPdUB;

    public static int getHeartRateLB() {
        return heartRateLB;
    }

    public static int getRespRateLB() {
        return respRateLB;
    }

    public static int getRespRateUB() {
        return respRateUB;
    }

    public static int getHeartRateUB() {
        return heartRateUB;
    }

    public static int getbPLB() {
        return bPLB;
    }

    public static int getbPUB() {
        return bPUB;
    }

    public static float getwKgLB() {
        return wKgLB;
    }

    public static float getwKgUB() {
        return wKgUB;
    }

    public static float getwPdLB() {
        return wPdLB;
    }

    public static float getwPdUB() {
        return wPdUB;
    }

    
    public void setNewBorn(){
        respRateLB = 30;
        respRateUB=50;
        heartRateLB=120;
        heartRateUB=160;
        bPLB=50;
        bPUB=70;
        wKgLB=2;
        wKgUB=3;
        wPdLB=(float) 4.5;
        wPdUB=7;
    }
    public void setInfant(){
        respRateLB = 20;
        respRateUB=30;
        heartRateLB=80;
        heartRateUB=140;
        bPLB=70;
        bPUB=100;
        wKgLB=4;
        wKgUB=10;
        wPdLB= 9;
        wPdUB=22;
    }
    public void setToddler(){
        respRateLB = 20;
        respRateUB=30;
        heartRateLB=80;
        heartRateUB=130;
        bPLB=80;
        bPUB=110;
        wKgLB=10;
        wKgUB=14;
        wPdLB= 22;
        wPdUB=31;
    }
    public void setPreschooler(){
        respRateLB = 20;
        respRateUB=30;
        heartRateLB=80;
        heartRateUB=120;
        bPLB=80;
        bPUB=110;
        wKgLB=14;
        wKgUB=18;
        wPdLB= 31;
        wPdUB=40;
    }
    public void setSchoolAge(){
        respRateLB = 20;
        respRateUB=30;
        heartRateLB=70;
        heartRateUB=110;
        bPLB=80;
        bPUB=120;
        wKgLB=20;
        wKgUB=42;
        wPdLB= 41;
        wPdUB=92;
    }
    public void setAdolescent(){
        respRateLB = 12;
        respRateUB=20;
        heartRateLB=55;
        heartRateUB=105;
        bPLB=110;
        bPUB=120;
        wKgLB=51;
        wKgUB=500;
        wPdLB= 110;
        wPdUB=1000;
    }
}
