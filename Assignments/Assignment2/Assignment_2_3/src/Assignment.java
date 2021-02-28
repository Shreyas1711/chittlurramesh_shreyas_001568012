
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import models.City;
import models.Community;
import models.Encounter;
import models.EncounterHistory;
import models.House;
import models.Patient;
import models.PatientDirectory;
import models.Person;
import models.VitalBound;
import models.VitalSigns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author shreyascr
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    VitalBound vitalBound = new VitalBound();
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Assignment().menuDisplay();

//       
//       VitalSigns vitals = new VitalSigns();
//        EncounterHistory enounterList =new EncounterHistory();
//       
//       Encounter vs = enounterList.addEncounter();
//      vs.setVitalSigns(vitals);
//      vs.setDocName("shreyas");
//      vs.setReason("RCB Never Wins");
//      vs.setVisit(new Date());
//      p.setEncounterHistory(enounterList);
//      System.out.println(p.getEncounterHistory().encounterList.get(0).getVitalSigns().getHeartRate());
    }
    
    
    HashMap<String, ArrayList<City>> cityHash = new HashMap<>();
    HashMap<String, ArrayList<Community>> communityHash = new HashMap<>();
    public void menuDisplay() {
        System.out.println("=================================");
        System.out.println("Please enter your option:");
        System.out.println("1. New user");
        System.out.println("2. Existing User");
        System.out.println("3. Check User History");
        System.out.println("4. Check your vital");
        System.out.println("5. Data Analysis");
        System.out.println("6. Exit");
        System.out.println("=================================");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:
                menuDisplay1();
                break;
            case 2:
                encounterAgain();
                break;
            case 3:
                menuDisplay3();
                break;
            case 4:
                checkVital();
                break;   
            case 5:
                dataAnalysis();
                break;
            case 6:
                System.exit(0);
                break;
        }
        
    }

    public void menuDisplay1() {
        
        VitalSigns vitals = new VitalSigns();
        Scanner input = new Scanner(System.in);
        
        int year = 0;
        float month = 0;
        float days = 0;
        
        System.out.println("=================================");
        System.out.println("Please enter your name:");
        System.out.println("=================================");
        
        String option = input.nextLine();
        
        if (!PatientDirectory.getPatientHash().containsKey(option)) {
            Patient p = new Patient();
            Community community=new Community();
            City city1 =new City();
            p.setPersonName(option);
            EncounterHistory enounterList = new EncounterHistory();
            PatientDirectory.getPatientHash().put(option, p);
            Encounter en = new Encounter();
            System.out.println("=================================");
            System.out.println("Please enter your age:");
            System.out.println("=================================");
            System.out.println("Please enter in years:");
            year = input.nextInt();
            while (year > 140 || year < 0) {
                System.out.println("Please enter years below 140");
                year = input.nextInt();
                input.nextLine();
            }
            System.out.println("=============================");
            System.out.println("Please enter in months:");
            month = input.nextInt();
            input.nextLine();
            while (month > 12 || month < 0) {
                System.out.println("Please enter month below 12");
                month = input.nextInt();
                input.nextLine();
            }
            System.out.println("=============================");
            System.out.println("Please enter in days:");
            days = input.nextInt();
            input.nextLine();
            while (days > 31 || days < 0) {
                System.out.println("Please enter days below 31");
                days = input.nextInt();
                input.nextLine();
            }
            float age = year + (month / 12) + (days / 365);
            
            ageRange(age);
            p.setAge(age);
            
           
            System.out.println("=================================");
            System.out.println("Please enter your City):");
            System.out.println("=================================");
            String city = input.next();
            System.out.println("=================================");
            System.out.println("Please enter your Community Name:");
            System.out.println("=================================");
            
            String commName = input.next();
            
            community.setCommunityName(commName);
            city1.setCityName(city);
            if(!cityHash.containsKey(city)){
                ArrayList<City> list = new ArrayList<>();
                list.add(city1);
                cityHash.put(city, list);

            }else{
                ArrayList<City> list = cityHash.get(city);
                boolean result = true;
                for(City c : list)
                {
                    List<Community> list1 = c.getCommunity();
                    
                    for(Community c1 : list1)
                    {
                        if(c1.getCommunityName().equals(commName))
                        {
                            result=false;
                           
                            break;
                            
                            
                        }
                    }
                    if(result)
                    {
                        c.setCommunity(community);
                        cityHash.put(city, list);
                    }
                    
                }
                    
                
            }
             
            city1.setCommunity(community);
            System.out.println("=================================");
            System.out.println("Please enter your House Number: ");
            System.out.println("=================================");
            int houseNo = input.nextInt();
            House house = new House();
            
            house.setHouseNo(houseNo);
            
            community.setHouseList(house);
                        System.out.println("=================================");
            System.out.println("Please enter your Doctor Name:");
            System.out.println("=================================");
            String docName = input.next();
            System.out.println("=================================");
            System.out.println("Mention the purpose of your visit:");
            System.out.println("=================================");
            String reason = input.next();
            
            en.setDocName(docName);
            en.setReason(reason);
            Date date = new Date();
            en.setVisit(date);
            enounterList.setEncounters(en);
            p.setEncounterHistory(enounterList);
            System.out.println("=================================");
            System.out.println("Enter your vitals:");
            System.out.println("=================================");
            System.out.println("=================================");
            System.out.println("Please enter your Respiration Rate:");
            System.out.println("=================================");
            int respRate = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Heart Rate:");
            System.out.println("=================================");
            int heartRate = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Blood Pressure:");
            System.out.println("=================================");
            int bP = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Weight(Kg):");
            System.out.println("=================================");
            float wKG = input.nextFloat();
            System.out.println("=================================");
            System.out.println("Please enter your Weight(Pd):");
            System.out.println("=================================");
            float wPD = input.nextFloat();
            p.setHouse(house);
            house.setPerson(p);
            vitals.setHeartRate(heartRate);
            vitals.setRespRate(respRate);
            vitals.setbP(bP);
            vitals.setWeightKG(wKG);
            vitals.setWieghtPd(wPD);
            
            en.setVitalSigns(vitals);
            isPatientNormal(age,respRate,heartRate,bP,wKG,wPD);
            menuDisplay();
            
        } else {
            menuDisplay();
        }
        
    }

    private void ageRange(float age) {
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

//    public  void menuDisplay2() {
//         Scanner input = new Scanner(System.in);
//       String name;
//            System.out.println("Enter name");
//            name = input.nextLine();
//            if(patientHash.containsKey(name)){
//                Patient pat = patientHash.get(name);
//                for(int i=0;i<pat.getEncounterHistory().getEncounters().size();i++){
//                System.out.println("Respiratory rate:"+pat.getEncounterHistory().getEncounters().get(i).getVitalSigns().getRespRate());
//               
//                                
//    }
//            }else{
//                System.out.println("hello");
//            }
//    }
    public void menuDisplay3() {
        Scanner input = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("Enter name");
        System.out.println("=================================");
        String name = input.nextLine();
        System.out.println("=============================================================================================================================================================================");
        System.out.println("Name \t\tDoctor Name \tReason for visit \tRespiratory rate  \tHeart rate \tBlood pressure \tWeight(Kg) \tWeight(Pd) \tCreatedDate");
        System.out.println("=============================================================================================================================================================================");
        if (PatientDirectory.getPatientHash().containsKey(name)) {
            Patient p = PatientDirectory.getPatientHash().get(name);
            for (int i = 0; i < p.getEncounterHistory().getEncounters().size(); i++) {
                System.out.println("" + p.getPersonName()+ "\t\t"+" "+p.getEncounterHistory().getEncounters().get(i).getDocName()+"\t\t"+""+p.getEncounterHistory().getEncounters().get(i).getReason()+ "\t\t\t"  + "" + p.getEncounterHistory().getEncounters().get(i).getVitalSigns().getRespRate() + "\t\t\t" + "" + p.getEncounterHistory().getEncounters().get(i).getVitalSigns().getHeartRate() + "\t\t" + "   " + p.getEncounterHistory().getEncounters().get(i).getVitalSigns().getbP() + "\t\t" + "  " + (int) p.getEncounterHistory().getEncounters().get(i).getVitalSigns().getWeightKG() + "\t\t" + "    " + (int) p.getEncounterHistory().getEncounters().get(i).getVitalSigns().getWieghtPd() + "\t\t" + " " + p.getEncounterHistory().getEncounters().get(i).getVisit());
                
            }
            menuDisplay();
        } else {
            System.out.println("Name is not present");
            menuDisplay();
        }
    }

    public void encounterAgain() {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("=================================");
        System.out.println("Enter name");
        System.out.println("=================================");
        name = input.nextLine();
        if (PatientDirectory.getPatientHash().containsKey(name)) {
            Patient p = PatientDirectory.getPatientHash().get(name);
            Encounter en = new Encounter();
            VitalSigns vitals = new VitalSigns();
            System.out.println("=================================");
            System.out.println("Please enter your Doctor Name:");
            System.out.println("=================================");
            String docName = input.next();
            System.out.println("=================================");
            System.out.println("Mention the purpose of your visit:");
            System.out.println("=================================");
            String reason = input.next();
            en.setDocName(docName);
            en.setReason(reason);
            System.out.println("=================================");
            System.out.println("Enter your vitals:");
            System.out.println("=================================");
            System.out.println("=================================");
            System.out.println("Please enter your Respiration Rate:");
            System.out.println("=================================");
            int respRate = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Heart Rate:");
            System.out.println("=================================");
            int heartRate = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Blood Pressure:");
            System.out.println("=================================");
            int bP = input.nextInt();
            System.out.println("=================================");
            System.out.println("Please enter your Weight(Kg):");
            System.out.println("=================================");
            float wKG = input.nextFloat();
            System.out.println("=================================");
            System.out.println("Please enter your Weight(Pd):");
            System.out.println("=================================");
            float wPD = input.nextFloat();
            vitals.setHeartRate(heartRate);
            vitals.setRespRate(respRate);
            vitals.setbP(bP);
            vitals.setWeightKG(wKG);
            vitals.setWieghtPd(wPD);
            Date date = new Date();
            en.setVisit(date);
            p.getEncounterHistory().setEncounters(en);
            
            en.setVitalSigns(vitals);
            
            menuDisplay();
        }
    }

    public void dataAnalysis() {
        Scanner input = new Scanner(System.in);
        System.out.println("=================================");
        System.out.println("Enter City Name");
        System.out.println("=================================");
        String city = input.nextLine();
        ArrayList<City> c = cityHash.get(city);
        //System.out.println("CC "+c.size());
        
        int count=0;
           int abnormal=0;
        for(int i=0;i<c.size();i++){
           //System.out.println("*** "+c.get(i));
           City cc = c.get(i);
           
           //System.out.println(cc.getCommunity().get(0).getHouseList().get(0).getP().getName());
           //ArrayList<String> names = new ArrayList<>();
           List<Community> comm = cc.getCommunity();
           //System.out.println("Community Size "+ comm.size());
           for(Community community : comm)
           {
               
               List<House> list = community.getHouseList();
               //System.out.println("House size "+ list.size());
               for(House h : list)
               {
                   count++;
                   List<Encounter> list1 = h.getPerson().getEncounterHistory().getEncounters();
                   for(int m =0 ; m < list1.size(); m ++){
                      int BP =  list1.get(m).getVitalSigns().getbP();
                      if(!isThisVitalSignNormal1(BP)){
                         abnormal++; 
                      }
                      
                   }
               }
           }
           
           }
            System.out.println(count);
            
              System.out.println(abnormal);  
           }
          // String community = cc.getCommunity().get(0).getCommunityName();
           
           
           
          // names.add(name);
           
         //  System.out.println(names.get(i));
           
        
     public  boolean isThisVitalSignNormal(String vital, int respRate, int heartRate, int bP, float kg, float pd) {
        if (vital.equals("respiratory rate")) {
            if (respRate >= vitalBound.getRespRateLB() && respRate < vitalBound.getRespRateUB()) {
                System.out.println("Your Respiratory Rate is normal.");
                return true;
            } else {
                System.out.println("Your Respiratory Rate is not normal.");
                return false;
            }
        }
        if (vital.equals("heart rate")) {
            if (heartRate >= vitalBound.getHeartRateLB() && heartRate < vitalBound.getHeartRateUB()) {
                System.out.println("Your Heart Rate is normal.");
                return true;
            } else {
                System.out.println("Your Heart Rate is not normal.");
                return false;
            }
        }
        if (vital.equals("blood pressure")) {
            if (bP >= vitalBound.getbPLB() && bP < vitalBound.getbPUB()) {
                System.out.println("Your Blood Pressure is normal.");
                return true;
            } else {
                System.out.println("Your Blood Pressure is not normal.");
                return false;
            }
        }
        if (vital.equals("weight kg")) {
            if (kg > vitalBound.getwKgLB()&& kg<vitalBound.getwKgUB() ){
                System.out.println("Your Weight in kg is normal.");
                return true;
            } else {
                System.out.println("Your Weight in kg is not normal.");
                return false;
            }
        }
        if (vital.equals("weight pd")) {
            if (pd > vitalBound.getwPdLB() && pd<vitalBound.getwPdUB()) {
                System.out.println("Your Weight in pd is normal.");
                return true;
            } else {
                System.out.println("Your Weight in pd is not normal.");
                return false;
            }
        }
        return false;

    }
     public  boolean isThisVitalSignNormal1( int bP) {
        
            if (bP >= vitalBound.getbPLB() && bP < vitalBound.getbPUB()) {
                System.out.println("Your Blood Pressure is normal.");
                return true;
            } else {
                System.out.println("Your Blood Pressure is not normal.");
                return false;
            }
        
    }
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

    public void checkVital() {
       
        
            System.out.println("=============================");
            System.out.println("Please enter the name:");
            System.out.println("==============================");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            Patient p = PatientDirectory.getPatientHash().get(name);
            System.out.println("========================================");
            System.out.println("Please enter the vital you want to check:");
            System.out.println("=========================================");
            String vital = input.nextLine().trim().toLowerCase();
            
            if(vital.equals("respiratory rate")|| vital.equals("heart rate")||vital.equals("blood pressure")||vital.equals("weight kg")||vital.equals("weight pd")) {
                int size1= p.getEncounterHistory().getEncounters().size()-1;
            p.getEncounterHistory().getEncounters().get(size1);
            isThisVitalSignNormal(vital, p.getEncounterHistory().getEncounters().get(size1).getVitalSigns().getRespRate(),
                            p.getEncounterHistory().getEncounters().get(size1).getVitalSigns().getHeartRate(), p.getEncounterHistory().getEncounters().get(size1).getVitalSigns().getbP(),
                            p.getEncounterHistory().getEncounters().get(size1).getVitalSigns().getWeightKG(), p.getEncounterHistory().getEncounters().get(size1).getVitalSigns().getWieghtPd()
                    );

            menuDisplay();
            }else{
                System.out.println("Enter respiration rate or heart rate or blood pressure or weight kg or weight pd");
                menuDisplay();
            }
            
        } 
    
}
