/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty.Alumni;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.Employers;
import info5100.university.example.Persona.StudentAccount;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author psrib
 */
public class Alumni {
String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    StudentProfile studentProfile;
    Employers emp;
   
    int promotions;
    int salaryRange;
    int gradutationYear;
    String position;
    int workExp;

    public int getWorkExp() {
        return workExp;
    }

    public void setWorkExp(int workExp) {
        this.workExp = workExp;
    }
    static HashMap<String, Alumni> alumniDir;

    HashMap<String, Double> map = new HashMap();
    Double AGM;
    Double careerSuccess;

    public Double getCareerSuccess() {
        return careerSuccess;
    }

    public void setCareerSuccess(Double careerSuccess) {
        this.careerSuccess = careerSuccess;
    }
    public Double getAGM() {
        return AGM;
    }

    public void setAGM(Double AGM) {
        this.AGM = AGM;
    }
    
    public HashMap<String, Alumni> getAlumniDir() {
        return alumniDir;
    }

//    public Alumni getAlumniDir(String id) {
//                System.out.println("ALm1 "+ alumniDir.);
//
//        return alumniDir.get(id);
//    }

    public void setAlumniDir(HashMap<String, Alumni> alumniDir) {
        
        this.alumniDir = alumniDir;
        System.out.println("ALm "+ alumniDir.size());
    }
    
       
    
    public StudentProfile getStudentProfile() {
        
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Employers getEmp() {
        return emp;
    }

    public void setEmp(Employers emp) {
        this.emp = emp;
    }

    public int getPromotions() {
        return promotions;
    }

    public void setPromotions(int promotions) {
        this.promotions = promotions;
    }

    public int getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(int salaryRange) {
        this.salaryRange = salaryRange;
    }

    public int getGradutationYear() {
        return gradutationYear;
    }

    public void setGradutationYear(int gradutationYear) {
        this.gradutationYear = gradutationYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public double calculateAMG(){
        
       setAGM((getSalaryPoints() + getPromotionPoints() + getWorkExpPoints())/3);
       return (getSalaryPoints() + getPromotionPoints()+ getWorkExpPoints()) /3;
    }
    
    public double getSalaryPoints(){
         Double points =0.0;
         if(getSalaryRange()>70000 && getSalaryRange() <80000 ){
            points = 2.5;
        }else if(getSalaryRange()>= 80000 && getSalaryRange() <90000){
            points = 5.0;
        }else if(getSalaryRange()>= 90000 && getSalaryRange() < 130000){
            points = 7.5;
        }else if(getSalaryRange() >= 130000){
            points =10.0;
        }
       return points;
    }
    
    
    public double getPromotionPoints(){
        Double points =0.0;
         if(getPromotions() == 0){
            points = 2.5;
        }else if(getPromotions()==1){
            points = 5.0;
        }else if(getPromotions()==2){
            points = 7.5;
        }else if(getPromotions()==3){
            points = 10.0;
        }
       return points;
    }
    
    public double getWorkExpPoints(){
        
        Double points = 0.0;
        if(workExp > 0 && workExp < 2)
            points = 2.5;
        else if(workExp > 3 && workExp < 5)
            points = 5.0;
        else if(workExp > 5 && workExp < 8)
            points = 7.5;
        else 
            points = 10.0;
        
        return points;
       
    }
    
    //To Calcuate the Career Success Metric which is a combination of Professional & Academic Performance
    public double careerSuccessMetric(){
        
        Double careerMetric = getAGM();
        System.out.println("COOOO "+ AGM);
        
        Double alumniCGPA = getStudentProfile().studentPerformanceMetric();
        System.out.println("CM ccc "+ alumniCGPA);
        if(alumniCGPA < 8.4 && careerMetric > 5.0 ){
            System.out.println("Having a below average CGPA doesnt affect the student's Industry Performance!!");
        } else if(alumniCGPA > 8.4 && careerMetric < 5.0){
            System.out.println("Having a very good CGPA doesnt guarantee Industry Success!!");
        }
        
        System.out.println("Career Success Value: "+ (careerMetric + alumniCGPA) / 2);
        setCareerSuccess((careerMetric + alumniCGPA )/ 2);
        //System.out.println("Course Information---> "+getStudentProfile().getCourseLoadBySemester("Fall2020").getCourseInformation().get(0));
        return (careerMetric + alumniCGPA )/ 2;
    }
    
//    public void rateCourses(){
//        double value = calculateAMG();
//        ArrayList<String> al  = getStudentProfile().getTranscript().getCourseLoadBySemester("Fall2020").getCourseInformation();
//       
//        for(String a : al){
//             Course c =  a;
//        }
//        getStudentProfile().getTranscript().getCourseLoad("Fall2020").g
//        
//        if(value > ){
//            getStudentProfile().getCourseLoadBySemester("Fall2020").getCourseInformation;
//        }
//       
    
    
   
}
