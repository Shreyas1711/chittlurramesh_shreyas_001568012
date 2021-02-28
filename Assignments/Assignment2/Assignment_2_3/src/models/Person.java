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
public class Person {
    //public String name;
    public float age;
    House house;
    String personName;
    
    public House getHouse() {
        return house;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    public Person() {
       // this.name = name;
      this.age = age;
      this.house=house;
    }
    
    public String getPersonName(){
        return personName;
    }
    

//    public Person(String name, float age, int SSN, String insuraceID) {
//        this.name = name;
//        this.age = age;
//        this.SSN = SSN;
//        this.insuraceID = insuraceID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public EncounterHistory getEncounterHistory() {
        return null;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
       
    }

    
}
