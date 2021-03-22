/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Persona.Faculty.Alumni.Alumni;
import info5100.university.example.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author psrib
 */
public class Employers  {
    
    String employerName;
    Person person;
   // ArrayList<CourseOffer> relevantcourseoffers;
    ArrayList<Course> relevantcourses;

    public ArrayList<Course> getRelevantcourses() {
        return relevantcourses;
    }

    public void setRelevantcourses(ArrayList<Course> relevantcourses) {
        this.relevantcourses = relevantcourses;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    
    public void test(){
        
         EmployeeDirectory ed = new info5100.university.example.Info5001UniversityExample().getED();
         System.out.println("EDD "+ ed.getEmployers());
         
        
    }
    
    
    
}
