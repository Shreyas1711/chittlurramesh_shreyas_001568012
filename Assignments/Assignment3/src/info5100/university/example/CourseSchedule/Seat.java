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
public class Seat {
    
    Boolean occupied; 
    int number;
    SeatAssignment seatassignment;

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }
    CourseOffer courseoffer;
	
	public CourseOffer getCourseoffer() {
        return courseoffer;
    }
	
    public Seat (CourseOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }

    public int getNumber() {
        return number;
    }
    
    public Boolean isOccupied(){
        return occupied;

    }
    public SeatAssignment newSeatAssignment(){
        
        seatassignment = new SeatAssignment(); //links seatassignment to seat
        seatassignment.setSeat(this);
		occupied = true;   
        return seatassignment;
    }
    
    
}
