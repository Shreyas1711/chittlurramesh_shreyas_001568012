/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.*;
import info5100.university.example.CourseSchedule.CourseOffer;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile {

    Person person;
    ArrayList <FacultyAssignment> facultyassignments;
    int facultyRatings;

    public int getFacultyRatings() {
        return facultyRatings;
    }

    public void setFacultyRatings(int facultyRatings) {
        this.facultyRatings = facultyRatings;
    }

    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    public FacultyProfile(Person p) {

        person = p;
        facultyassignments = new ArrayList();
    }

    public Person getPerson() {
        return person;
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        
        return fa;
    }
    
    public FacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    
    
}
