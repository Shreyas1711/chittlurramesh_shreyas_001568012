/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import helper.Helper;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {

    String semester;
    ArrayList<SeatAssignment> seatassignments;

    public ArrayList<SeatAssignment> getSeatassignments() {
        return seatassignments;
    }

    public void setSeatassignments(ArrayList<SeatAssignment> seatassignments) {
        this.seatassignments = seatassignments;
    }
     
    public String getSemester() {
        return semester;
    }
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment();
        sa.setSeat(seat);
        
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
	
//	public Iterable<SeatAssignment> getSeatassignments() {
//       
//        return seatassignments; //To change body of generated methods, choose Tools | Templates.
//    }

    public double iterateSeatAssignments(){
        String grade= "";
        double gpa = 0.0;
        for(SeatAssignment value1:seatassignments){
            System.out.println("The Course Name is: "+value1.getSeat().getCourseoffer().getCourse().getName());
            grade=value1.getGrade();
            switch(grade){
                case "A": 
                    gpa+=4.0;
                    break;
                case "A-": 
                    gpa+= 3.7;
                    break;
                case "B+": 
                    gpa+= 3.5;
                    break;
                case "B": 
                    gpa+= 3.3;
                    break;
                case "B-": 
                    gpa+= 3.0;
                    break;
                
                default: gpa = 0.0;
                
            }
            System.out.println("The Grade Received is: "+grade);
           // System.out.println("The Seat Assignment Size: "+seatassignments.size());
        }
        //check();
        return gpa/seatassignments.size();
    }
    
    //To display the Course Name and Course Grade in a table in UI
    public ArrayList getCourseInformation(){
        ArrayList courseGradeList = new ArrayList();
        for(SeatAssignment value1:seatassignments){
            courseGradeList.add(value1.getSeat().getCourseoffer().getCourse().getName());
            courseGradeList.add(value1.getGrade());
        }
        System.out.println("Arraykist: "+courseGradeList.get(0));
        return courseGradeList;
        
        
    }
    
    //Transcript transcript;
  
}
