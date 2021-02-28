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
public class PersonDirectory {
    
    static HashMap<String, Person> personHash = new HashMap();

    public static HashMap<String, Person> getPersonHash() {
        return personHash;
    }

    public static void setPersonHash(HashMap<String, Person> personHash) {
        PersonDirectory.personHash = personHash;
    }

    
    
}
