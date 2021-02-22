
import java.util.Scanner;
import model.VitalSign;

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

    //check isPatientNormal method
    public boolean isPatientNormal(float age, int respRate, int heartRate, int bP, float kg, float pd) {
        float age1 = (float) (30.0 / 365.0);
        if (age <= age1) {
            Boolean newBorn = (respRate >= 30 && respRate <= 50) && (heartRate >= 120 && heartRate <= 160)
                    && (bP >= 50 && bP <= 70) && (kg >= 2 && kg <= 3) && (pd >= 4.5 && pd <= 7);
            if(newBorn==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
           
        } else if (age <= 1.0 && age > age1) {
            Boolean infant = (respRate >= 20 && respRate <= 30) && (heartRate >= 80 && heartRate <= 140)
                    && (bP >= 70 && bP <= 100) && (kg >= 4 && kg <= 10) && (pd >= 9 && pd <= 22);
            if(infant==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
        } else if (age > 1.0 && age <= 3.0) {
            Boolean toddler = (respRate >= 20 && respRate <= 30) && (heartRate >= 80 && heartRate <= 130)
                    && (bP >= 80 && bP <= 110) && (kg >= 10 && kg <= 14) && (pd >= 22 && pd <= 31);
            if(toddler==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
        } else if (age > 3.0 && age <= 6.0) {
            Boolean preSchooler = (respRate >= 20 && respRate <= 30) && (heartRate >= 80 && heartRate <= 120)
                    && (bP >= 80 && bP <= 110) && (kg >= 14 && kg <= 18) && (pd >= 31 && pd <= 40);
            if(preSchooler==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
        } else if (age > 6.0 && age <= 12.0) {
            Boolean schoolAge = (respRate >= 20 && respRate <= 30) && (heartRate >= 70 && heartRate <= 110)
                    && (bP >= 80 && bP <= 120) && (kg >= 20 && kg <= 42) && (pd >= 41 && pd <= 92);
            if(schoolAge==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
        } else {
            Boolean adolescent = (respRate >= 12 && respRate <= 20) && (heartRate >= 55 && heartRate <= 105)
                    && (bP >= 110 && bP <= 120) && (kg > 50) && (pd > 110);
            if(adolescent==true){
                System.out.println("The vitals are normal");
                return true;
            }
            else {
                System.out.println("The vitals are not normal");
                return false;
            }
        }

    }

    //Main method
    public static void main(String[] args) {
        VitalSign vitals = new VitalSign();
        // TODO code application logic here
        Patient patient = new Patient();
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
            System.out.println("Please enter a valid year:");
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

        System.out.println("===================================");
        System.out.println("Please enter the following details:");
        System.out.println("===================================");
        System.out.println("Respiratory Rate:");
        int respRate = input.nextInt();
        input.nextLine();
        vitals.setRespRate(respRate);
        System.out.println("Heart Rate:");
        int heartRate = input.nextInt();
        input.nextLine();
        vitals.setHeartRate(heartRate);
        System.out.println("Blood pressure:");
        int bP = input.nextInt();
        input.nextLine();
        vitals.setbP(bP);
        System.out.println("Weight(KG):");
        int kg = input.nextInt();
        input.nextLine();
        vitals.setWeightKG(kg);
        System.out.println("Weight(Pounds):");
        int pd = input.nextInt();
        input.nextLine();
        vitals.setWieghtPd(pd);

        patient.isPatientNormal(age, vitals.getRespRate(), vitals.getHeartRate(), vitals.getbP(), vitals.getWeightKG(), vitals.getWieghtPd());
    }

}
