
import Assignment2_2.VitalBound;
import Assignment2_2.VitalSignsHistory;
import java.util.ArrayList;
import java.util.Scanner;

import model.PediatricVitalSign;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shreyascr
 */
public class Patient {

    private float age;

    public float getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    static VitalSignsHistory vitals = new VitalSignsHistory();
    static Patient patient = new Patient();
    static VitalBound vitalBound = new VitalBound();

    /* Main method */
    public static void main(String[] args) {
        // TODO code application logic here
        menuDisplay();

    }

    /* Display menu method*/
    public static void menuDisplay() {
        System.out.println("=================================");
        System.out.println("Please select the menu option:");
        System.out.println("=================================");
        System.out.println("1. Create a new vital record");
        System.out.println("2. View vital records");
        System.out.println("3. Check Vitals");
        System.out.println("4. Exit");
        System.out.println("=================================");
        Scanner input1 = new Scanner(System.in);
        int option = input1.nextInt();
        input1.nextLine();
        while (option > 4 && option < 1) {
            System.out.println("Please enter a valid option:");
            option = input1.nextInt();
            input1.nextLine();
        }
        switch (option) {
            case 1:
                createRecord();
                break;
            case 2:
                viewRecord();
                break;
            case 3:
                checkVitals();
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
    }

    /*  Create a new record method*/
    public static void createRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("Please enter the name:");
        System.out.println("=============================");
        String name = input.nextLine();
        System.out.println("=============================");
        System.out.println("Please enter the age");
        System.out.println("=============================");

        System.out.println("Please enter in years:");
        int year = input.nextInt();
        input.nextLine();
        while (year > 140 || year < 0) {
            System.out.println("Please enter years below 140");
            year = input.nextInt();
            input.nextLine();
        }
        System.out.println("=============================");
        System.out.println("Please enter in months:");
        float month = input.nextInt();
        input.nextLine();
        while (month > 12 || month < 0) {
            System.out.println("Please enter month below 12");
            month = input.nextInt();
            input.nextLine();
        }
        System.out.println("=============================");
        System.out.println("Please enter in days:");
        float days = input.nextInt();
        input.nextLine();
        while (days > 31 || days < 0) {
            System.out.println("Please enter days below 31");
            days = input.nextInt();
            input.nextLine();
        }

        float age = year + (month / 12) + (days / 365);

        ageRange(age);
        patient.setAge((int) Math.floor(age));
        System.out.println("===================================");
        System.out.println("Please enter the following details:");
        System.out.println("===================================");
        System.out.println("Respiratory Rate:");
        int respRate = input.nextInt();
        input.nextLine();
        System.out.println("Heart Rate:");
        int heartRate = input.nextInt();
        input.nextLine();
        System.out.println("Blood pressure:");
        int bP = input.nextInt();
        input.nextLine();
        System.out.println("Weight(KG):");
        int kg = input.nextInt();
        input.nextLine();
        System.out.println("Weight(Pounds):");
        int pd = input.nextInt();
        input.nextLine();

//        patient.isPatientNormal(age,respRate,heartRate,bP,kg,pd);
        PediatricVitalSign vs = vitals.addVitals();
        vs.setName(name);
        vs.setAge((int) patient.getAge());
        vs.setRespRate(respRate);
        vs.setHeartRate(heartRate);
        vs.setbP(bP);
        vs.setWeightKG(kg);
        vs.setWieghtPd(pd);

        menuDisplay();

    }

    /*  Age comparator method*/
    private static void ageRange(float age) {
        float age1 = (float) (30.0 / 365.0);
        if (age1 > age && age > 0) {
            vitalBound.setNewBorn();

        } else if (age > age1 && age <= 1.0) {
            vitalBound.setInfant();

        } else if (age > 1.0 && age <= 3.0) {
            vitalBound.setToddler();

        } else if (age > 3.0 && age <= 6.0) {
            vitalBound.setPreschooler();

        } else if (age > 6.0 && age <= 12.0) {
            vitalBound.setSchoolAge();

        } else if (age > 13.0) {
            vitalBound.setAdolescent();

        } else {
            System.out.println("Please enter a proper age");
        }
    }

    /* Display all records*/
    public static void viewRecord() {
        System.out.println("===========================================================================================================================");
        System.out.println("Name \t\tAge(years) \tRespiratory rate  \tHeart rate \tBlood pressure \tWeight(Kg) \tWeight(Pd)");
        for (int i = 0; i < vitals.getVitalHistory().size(); i++) {

            System.out.println("" + vitals.getVitalHistory().get(i).getName() + "\t\t" + "   " + vitals.getVitalHistory().get(i).getAge() + "\t\t\t" + " " + vitals.getVitalHistory().get(i).getRespRate() + "\t\t" + "    " + vitals.getVitalHistory().get(i).getHeartRate() + "\t\t" + "     " + vitals.getVitalHistory().get(i).getbP() + "\t\t" + "    " + (int) vitals.getVitalHistory().get(i).getWeightKG() + "\t\t" + "   " + (int) vitals.getVitalHistory().get(i).getWieghtPd());
        }
        System.out.println("===========================================================================================================================");

        menuDisplay();
    }

    /* Check Vitals method*/
    public static void checkVitals() {
        if (!vitals.getVitalHistory().isEmpty()) {
            System.out.println("=============================");
            System.out.println("Please enter the name:");
            System.out.println("==============================");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();

            System.out.println("========================================");
            System.out.println("Please enter the vital you want to check:");
            System.out.println("=========================================");
            String vital = input.nextLine().trim().toLowerCase();

            for (int i = 0; i < vitals.getVitalHistory().size(); i++) {
                if (name.equals(vitals.getVitalHistory().get(i).getName())) {
                    isThisVitalSignNormal(vital, vitals.getVitalHistory().get(i).getRespRate(),
                            vitals.getVitalHistory().get(i).getHeartRate(), vitals.getVitalHistory().get(i).getbP(),
                            vitals.getVitalHistory().get(i).getWeightKG(), vitals.getVitalHistory().get(i).getWieghtPd()
                    );
                }
            }

            menuDisplay();
        } else {
            System.out.println("Please enter a record.");
            menuDisplay();
        }

    }

    /* Method to check vitals */
    public static boolean isThisVitalSignNormal(String vital, int respRate, int heartRate, int bP, float kg, float pd) {
        if (vital.equals("respiratory rate")) {
            System.out.println(vitalBound.getRespRateLB());
            if (respRate >= vitalBound.getRespRateLB() && respRate < vitalBound.getRespRateUB()) {
                System.out.println("Your Respiratory Rate is normal.");
                return true;
            } else {
                System.out.println("Your Respiratory Rate is not normal.");
                return false;
            }
        }
        if (vital.equals("heart rate")) {
            System.out.println(vitalBound.getHeartRateLB());
            if (heartRate >= vitalBound.getHeartRateLB() && heartRate < vitalBound.getHeartRateUB()) {
                System.out.println("Your Heart Rate is normal.");
                return true;
            } else {
                System.out.println("Your Heart Rate is not normal.");
                return false;
            }
        }
        if (vital.equals("blood pressure")) {
            System.out.println(vitalBound.getbPLB());
            if (bP >= vitalBound.getbPLB() && bP < vitalBound.getbPUB()) {
                System.out.println("Your Blood Pressure is normal.");
                return true;
            } else {
                System.out.println("Your Blood Pressure is not normal.");
                return false;
            }
        }
        if (vital.equals("weight kg")) {
            System.out.println(vitalBound.getwKgLB());
            if (kg > vitalBound.getwKgLB()) {
                System.out.println("Your Weight in kg is normal.");
                return true;
            } else {
                System.out.println("Your Weight in kg is not normal.");
                return false;
            }
        }
        if (vital.equals("weight pd")) {
            System.out.println(vitalBound.getwPdLB());
            if (pd > vitalBound.getwPdLB()) {
                System.out.println("Your Weight in pd is normal.");
                return true;
            } else {
                System.out.println("Your Weight in pd is not normal.");
                return false;
            }
        }
        return false;

    }

    /*public void isPatientNormal(float age,int respRate,int heartRate,int bP,float kg,float pd){
       if(age<=30/365){
           Boolean newBorn = (respRate>=30 &&respRate<=50)&&(heartRate>=120 && heartRate<=160)
                &&(bP>=50 && bP<=70)  &&(kg>=2 &&  kg<=3)&& ( pd>=4.5 && pd<=7 );
            System.out.println(newBorn);
        }else if(age<=1.0 && age>30/365){
            Boolean infant = (respRate>=20 &&respRate<=30)&&(heartRate>=80 && heartRate<=140)
                &&(bP>=70 && bP<=100)  &&(kg>=4 &&  kg<=10)&& ( pd>=9 && pd<=22 );
           System.out.println(infant);
        }
        else if(age>1.0 && age<=3.0){
            Boolean toddler = (respRate>=20 &&respRate<=30)&&(heartRate>=80 && heartRate<=130)
                &&(bP>=80 && bP<=110)  &&(kg>=10 &&  kg<=14)&& ( pd>=22 && pd<=31 );
            System.out.println(toddler);
        }
        else if(age>3.0 && age<=6.0){
            Boolean preSchooler = (respRate>=20 &&respRate<=30)&&(heartRate>=80 && heartRate<=120)
                &&(bP>=80 && bP<=110)  &&(kg>=14 &&  kg<=18)&& ( pd>=31 && pd<=40 );
          System.out.println(preSchooler);
        }
         else if(age>6.0 && age<=12.0){
             Boolean schoolAge = (respRate>=20 &&respRate<=30)&&(heartRate>=70 && heartRate<=110)
                &&(bP>=80 && bP<=120)  &&(kg>=20 &&  kg<=42)&& ( pd>=41 && pd<=92 );
           System.out.println(schoolAge);
        }
         else if(age>13.0){
             Boolean adolescent = (respRate>=12 &&respRate<=20)&&(heartRate>=55 && heartRate<=105)
                &&(bP>=110 && bP<=120)  &&(kg>50)&& ( pd>110 );
            System.out.println(adolescent);
        }
       
    }*/
}
