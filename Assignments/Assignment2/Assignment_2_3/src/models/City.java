/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shreyascr
 */
public class City {
    String cityName;
 static Map<String, List<Community>> map = new HashMap(); 
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    ArrayList<Community> communityList;

   

    public City() {
        this.communityList = new ArrayList<Community>();
    }
    
    public List<Community> getCommunity()
    {
        return map.getOrDefault(this.getCityName() , new ArrayList());
    }
    
    public void setCommunity(Community community)
    {
        List<Community> list = map.getOrDefault(this.getCityName(), new ArrayList());
        list.add(community);
        map.put(this.getCityName(), list);
    }
}
