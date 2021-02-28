/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author shreyascr
 */
public class Community {
    String communityName;
    static HashMap<String, List<House>> cmap = new HashMap();

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    

   

    public static HashMap<String, List<House>> getCmap() {
        return cmap;
    }
    

    

    public List<House> getHouseList() {
        return cmap.get(this.getCommunityName());
    }

    
    public void setHouseList(House house) {
        //System.out.println(this.getCommunityName());
       List<House> list = cmap.getOrDefault(this.getCommunityName(), new ArrayList());
       list.add(house);
       //System.out.println(cmap);
       cmap.put(this.getCommunityName(), list);
       
    }

    

}
