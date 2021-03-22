/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.Alumni.Alumni;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.EmployeeDirectory;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.Employers;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tharoon
 */
public class Helper {
    
    public List<Course> getCourseOffer(Department d , String semester)
    {
        CourseSchedule courseSchedule = d.getCourseSchedule(semester);
        List<CourseOffer> courseOffer = courseSchedule.getSchedule();
        List<Course> course = new ArrayList();
        for(CourseOffer co : courseOffer)
        {
            course.add(co.getCourse());
        }
        return course;
    }
    
    public List<CourseOffer> getCourseOfferList(Department d , String semester)
    {
        CourseSchedule courseSchedule = d.getCourseSchedule(semester);
        List<CourseOffer> courseOffer = courseSchedule.getSchedule();
        
        return courseOffer;
    }
    
    public List<StudentProfile> getStudent(Department d)
    {
        List<StudentProfile> profile = d.getStudentDirectory().getStudentlist();
        List<StudentProfile> list = new ArrayList();
        for(StudentProfile studentProfile : profile)
        {
            if(!studentProfile.getIsAlumni())
                list.add(studentProfile);
        }
        return list;
        
       
        
    }
    
        public List<StudentProfile> getAlumni(Department d)
    {
        List<Alumni> profile = d.getAlumniDirectory().getAd();
        List<StudentProfile> list = new ArrayList();
        for(Alumni studentProfile : profile)
        {
            list.add(studentProfile.getStudentProfile());
        }
        return list;
        
       
        
    }
    
     public void addStudentToAlumni(StudentProfile sp){
        Employers em = new Employers();
        em.setEmployerName("");
//        emp.add(em);
//        ed.setEmployers(emp);
       
        sp.setIsAlumni(true);
        Alumni al = new Alumni();
        al.setStudentProfile(sp);
        al.setGradutationYear(2020);
        al.setEmp(em);
        al.setPosition("");
        HashMap<String, Alumni> map = new HashMap<>();
        map.put(sp.getPerson().getPersonId(), al);
        al.setAlumniDir(map);
        ArrayList<Alumni> alu = new ArrayList();
        alu.add(al);
       // ad.setAd(alu);
       
    //    System.out.println("AS "+ ad.getAd().size());
     }
        
    public void addStudent(Department d , String studentName , String studentId , String semester , CourseOffer co)
    {
        //CourseSchedule courseschedule = d.getCourseSchedule(semester);
        StudentDirectory sd = d.getStudentDirectory();
        PersonDirectory pd = d.getPersonDirectory();
        Person person =  pd.newPerson(studentId);
        person.setName(studentName);
         
        StudentProfile student = sd.newStudentProfile(person);
        
        
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
  
        courseload.newSeatAssignment(co);
        
    }
    
    public void addProfessor(Department d , String professorName , String professorId , String semester , CourseOffer co)
    {
        //CourseSchedule courseschedule = d.getCourseSchedule(semester);
        PersonDirectory pd = d.getPersonDirectory();
        FacultyDirectory fd = d.getFacultyDirectory();
        Person person1 = pd.newPerson(professorId);
        FacultyProfile fp = fd.newStudentProfile(person1);
        co.AssignAsTeacher(fp);
        
    }
    
    
    public List<Alumni> getAlumniByDepartment(Department d){
         
        List<StudentProfile> profile = d.getStudentDirectory().getStudentlist();
        List<Alumni> list = new ArrayList();
        for(StudentProfile studentProfile : profile)
        {
            if(studentProfile.getIsAlumni())
            {
                System.out.println(studentProfile.getIsAlumni() + " "+ studentProfile.getAl());
                list.add(studentProfile.getAl());
            }
        }
        return list;
     }
    
   
    
    public List<String> getProfessors(Department d , StudentProfile sp)
    {
        List<SeatAssignment> courseId = sp.getCurrentCourseLoad().getSeatassignments();
        List <String> list = new ArrayList();
        List<String> result = new ArrayList();
        for(SeatAssignment s : courseId)
        {
            list.add(s.getSeat().getCourseoffer().getCourse().getCOurseNumber());
        }
        FacultyDirectory f = d.getFacultyDirectory();
        List<FacultyProfile> facultyProfile = f.getTeacherlist();
        for(FacultyProfile f1 : facultyProfile)
        {
            List<FacultyAssignment> facultyAssignment = f1.getFacultyassignments();
            for(FacultyAssignment f2 : facultyAssignment)
            {
            if(list.contains(f2.getCourseoffer().getCourseNumber()))
                    {
                        result.add(f2.getFacultyProfile().getPerson().getPersonId());
                    }
            }
            
        }
        
       return result; 
    }


//    public List<FacultyProfile> getProfessors(StudentProfile sp)
//    {
//        
//    }
//  public void checkAlumniRequiements(StudentProfile sp){
//       //sp.getTranscript().getCourseLoadBySemester("Fall2020").getCourseInformation();
//       int creditsTotal = 0;
//       for(SeatAssignment value1:seatassignments){
//         creditsTotal += value1.getSeat().getCourseoffer().getCourse().getCoursePrice();
//       }
//        System.out.println("The Number of Credits is :"+creditsTotal);
//        if(creditsTotal >= 4){
//            //Call Function which Sribalaji which would add for Alumni
//            new Helper().addStudentToAlumni(sp);
//        }
//        
//    }

    
}
