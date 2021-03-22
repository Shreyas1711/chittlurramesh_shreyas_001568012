/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.Seat;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.Arrays;

/**
 *
 * @author psrib
 */
public class Tes1 {
    
    public static void main(String args[]){
        
        // TODO code application logic here
        Department department = new Department("Information Systems");
        Course course = department.newCourse("AED", "info 5100", 4);
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        CourseOffer courseoffer1 = courseschedule.newCourseOffer("PSA 6205");
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("1");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer).assignGradeToStudent("A"); //register student in class
      //  courseload.newSeatAssignment(courseoffer1).assignGradeToStudent("A");
        
        SeatAssignment sa = new SeatAssignment();
        sa.assignGradeToStudent("A");
        
//        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total: " + total);
        
        
        //
        System.out.println("Test 1");
       // System.out.println(sd.findStudent("0112303").getCourseLoadBySemester("Fall2020"));
        
        CourseLoad cd = sd.findStudent("1").getCourseLoadBySemester("Fall2020");
        //System.out.println("cd "+ cd.getSeatassignments().get(0));
        //SeatAssignment sa1 = cd.getSeatassignments().get(0);
      //  System.out.println("SA "+cd.getSeatassignments().get(0).getGrade());
            System.out.println("SA ");
            
        
    }
    
}
