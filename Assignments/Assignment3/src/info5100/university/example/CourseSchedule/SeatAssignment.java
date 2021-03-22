/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {

  Seat seat;

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
    CourseLoad courseload;
    String grade="B+";
     public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public SeatAssignment(CourseLoad cl, Seat s,String g){
        seat = s;
        courseload = cl;
        grade=g;
    }
        public SeatAssignment(){

    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public void assignGradeToStudent(String g){
        grade = g;
    }
    
}
