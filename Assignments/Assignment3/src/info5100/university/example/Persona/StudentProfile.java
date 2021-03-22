/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import info5100.university.example.Persona.Faculty.Alumni.Alumni;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    Boolean isAlumni = false;

    public Boolean getIsAlumni() {
        return isAlumni;
    }

    public void setIsAlumni(Boolean isAlumni) {
        this.isAlumni = isAlumni;
    }
    
    public Transcript getTranscript() {
        return transcript;
    }
    EmploymentHistroy employmenthistory;
    Alumni al;
    
    public Alumni getAl() {
        return al;
    }

    public void setAl(Alumni al) {
        this.al = al;
    }

    public Person getPerson() {
        return person;
    }
    
    
    public double getGpa(){
        return transcript.calculateGpa();
    }

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript();
        employmenthistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    public CourseLoad getallTranscript(){
        return transcript.getAllcourses();
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }
	//CourseLoad courseload;
	public double studentPerformanceMetric(){
        
        double gpa = transcript.calculateGpa();
        
        double calcGPGA = (gpa * 2 ) + 2;
        System.out.println("Inside SPM: "+calcGPGA);
        //courseload.check();
        return calcGPGA;
    }   
        //call this function when Professor updates the grade
//        public void checkStudentIsAlumni(){
//            
//        }

}
