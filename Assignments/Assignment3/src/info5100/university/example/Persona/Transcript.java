/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {
    
    
    HashMap<String, CourseLoad> courseloadlist;
    
    CourseLoad currentcourseload;
    Double gpa;

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
    public Transcript(){
        
        courseloadlist = new HashMap<String, CourseLoad>();
        
    }
    public CourseLoad getAllcourses(){
        return currentcourseload;
    }
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCourseLoad(String sem)
    {
        return courseloadlist.get(sem);
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
	//CourseLoad courseload;
	public double calculateGpa(){
            double gpa=0.0;
            for(CourseLoad value: courseloadlist.values()){
                System.out.println("The semester is "+ value.getSemester());
                
                gpa += value.iterateSeatAssignments();
//                if(grade.equals("M")){
//                    gpa=10;
//                }else{
//                    gpa=15;
//                }
            }
            //System.out.println("Transcript Class: "+gpa);
            
            setGpa(gpa);
            return gpa;
        }
}
