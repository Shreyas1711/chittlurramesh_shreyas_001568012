/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.Department.Department;
import info5100.university.example.Department.DepartmentDirectory;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Faculty.Alumni.Alumni;
import info5100.university.example.Persona.Faculty.Alumni.AlumniDirectory;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.EmployeeDirectory;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.Employers;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    ArrayList<Employers> emp = new ArrayList<>();
    static AlumniDirectory ad  = new AlumniDirectory();
    static EmployeeDirectory ed = new EmployeeDirectory();
    static DepartmentDirectory dd = new DepartmentDirectory();
    

    public  DepartmentDirectory getDd() {
        return dd;
    }

    public AlumniDirectory getAd() {
        return ad;
    }
    
    public EmployeeDirectory getED(){
        return ed;
    }

    /**
     * @param args the command line arguments
     */
    static StudentDirectory sd ;
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
         PersonDirectory pd = department.getPersonDirectory();
         FacultyDirectory fd = department.getFacultyDirectory();
        Person person1 = pd.newPerson("123456");
        FacultyProfile fp = fd.newStudentProfile(person1);
        
        
        Course course = department.newCourse("app eng", "info 5100", 4);
        Course course1 = department.newCourse("dmdd", "info 6100", 5);
         
        CourseCatalog cc = new CourseCatalog(department);
        ArrayList<Course> ac = new ArrayList();
        ac.add(course);
        ac.add(course1);
        cc.setCourselist(ac);
        
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        courseoffer.AssignAsTeacher(fp);
        courseoffer.generatSeats(10);
        
        
        Person person = pd.newPerson("0112303");
         sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        SeatAssignment sa = new SeatAssignment();
        sa.assignGradeToStudent("A");
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total: " + total);
        ArrayList<CourseOffer> al1 = courseschedule.getSchedule();
        System.out.println(al1.size());
         ArrayList<String> al2 = new ArrayList();
        for(int i=0 ; i < al1.size(); i++){
            //System.out.println(al1.get(i).getFacultyProfile());
            if(al1.get(i).getFacultyProfile().getPerson().getPersonId().equals("123456")){
                al2.add(al1.get(i).getCourse().getCOurseNumber());
            }
        }
        new Info5001UniversityExample().getStudentTakenByProf(al2.get(0), sd);
        System.out.println("Total: 1" + courseoffer.getFacultyProfile().getPerson().getPersonId());
        
        
        //
        System.out.println("Test 1");
        System.out.println(sd.findStudent("0112303").getCourseLoadBySemester("Fall2020"));
        
        CourseLoad cd = sd.findStudent("0112303").getCourseLoadBySemester("Fall2020");
        //cd.newSeatAssignment(courseoffer)

       
        ArrayList<Employers> emp = new ArrayList<>();
        Employers em = new Employers();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
        
        StudentProfile sp = sd.findStudent("0112303");
       // System.out.println("");
        Alumni al = new Alumni();
        al.setStudentProfile(sp);
        al.setGradutationYear(2020);
        al.setEmp(em);
        al.setPosition("SDE");
        
        
        System.out.println("SS "+ al.getStudentProfile().getPerson().getPersonId());
        
        
        
        
    }
public void getStudentTakenByProf(String courseID, StudentDirectory sd){
        
        ArrayList<StudentProfile> as = new ArrayList();
        List<StudentProfile> list = sd.getStudentlist();
        for(StudentProfile sp : list)
        {
            List<SeatAssignment> list1 = sp.getCourseLoadBySemester("Fall2020").getSeatassignments();
            for(SeatAssignment seatAssignment : list1)
            {
                if(seatAssignment.getSeat().getCourseoffer().getCourse().getCOurseNumber().equals(courseID))
                {
                    System.out.println(sp.getPerson().getPersonId());
                }
            }
        }
     
        
    }

    public void test1(){
        System.out.println("TEST 1");
        Department department = new Department("Information Systems");

        Course course = department.newCourse("app eng", "info 5100", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("01");
        Person person1 = pd.newPerson("07");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        StudentProfile student1 = sd.newStudentProfile(person1);        
        CourseLoad courseload = student.newCourseLoad("Fall2020");
        CourseLoad courseload1 = student1.newCourseLoad("Fall2021");
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
         
        
        EmployeeDirectory ed = new EmployeeDirectory();
        ArrayList<Employers> emp = new ArrayList<>();
        Employers em = new Employers();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
       
        StudentProfile sp = sd.findStudent("01");
       // System.out.println("");
        Alumni al = new Alumni();
        al.setStudentProfile(sp);
        al.setGradutationYear(2020);
        al.setEmp(em);
        al.setPosition("SDE");
        al.setSalaryRange(25000);
        al.setPromotions(2);
        HashMap<String, Alumni> map = new HashMap<>();
        map.put("01", al);
        al.setAlumniDir(map);
        StudentProfile sp1 = sd.findStudent("07");
       // System.out.println("");
        //Alumni al = new Alumni();
        Alumni al1 = new Alumni();
        al1.setStudentProfile(sp1);
        al1.setGradutationYear(2021);
        al1.setEmp(em);
        al1.setPosition("SDE2");
        al1.setSalaryRange(15000);
        al1.setPromotions(5);
        map.put("07", al1);
        al1.setAlumniDir(map);
        
        
        
        
    }
    

     public void test2(){
        Department department = new Department("Information Systems");
        Department department1 = new Department("Computer Science");
        ArrayList<Department> ad = new ArrayList<>();
        ad.add(department);
        ad.add(department1);
        dd.setDd(ad);
        
        Course course = department.newCourse("app eng", "info 5100", 4);        
        Course course1 = department1.newCourse("PDP", "cs 5010", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseSchedule courseschedule1 = department1.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        courseoffer.generatSeats(10);
        
        CourseOffer courseoffer1 = courseschedule1.newCourseOffer("cs 5010");
        courseoffer1.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person =  pd.newPerson("info1");
        Person person1 = pd.newPerson("info2");
        Person person2 = pd.newPerson("cs1");
        Person person3 = pd.newPerson("cs2");
        
        StudentDirectory sd = department.getStudentDirectory();
        StudentDirectory sd1 = department1.getStudentDirectory();

        StudentProfile student = sd.newStudentProfile(person);
        StudentProfile student1 = sd.newStudentProfile(person1);
        
        StudentProfile student2 = sd1.newStudentProfile(person2);
        StudentProfile student3 = sd1.newStudentProfile(person3);
        
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        CourseLoad courseload1 = student1.newCourseLoad("Fall2020"); 
        CourseLoad courseload2 = student2.newCourseLoad("Fall2020"); 
        CourseLoad courseload3 = student3.newCourseLoad("Fall2020"); 

        courseload.newSeatAssignment(courseoffer); //register student in class
        courseload1.newSeatAssignment(courseoffer);
        courseload2.newSeatAssignment(courseoffer1);
        courseload3.newSeatAssignment(courseoffer1);

             
    }
     
     
     
     
     //Alumni Growth Metric
     public void calculateAGM(){
        
        ArrayList<Alumni> all = ad.getAd();
        
        for(Alumni a : all){
            
        }
         
      
                 
     }
     
     
     public void addStudentToAlumni(){
        Employers em = new Employers();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
       
        StudentProfile sp = sd.findStudent("0112303");
        StudentProfile sp1 = sd.findStudent("0112304");

       // System.out.println("");
        
        
        Alumni al = new Alumni();
        al.setStudentProfile(sp);
        al.setGradutationYear(2020);
        al.setEmp(em);
        al.setPosition("SDE");
        HashMap<String, Alumni> map = new HashMap<>();
        map.put("0112303", al);
        al.setAlumniDir(map);
        ArrayList<Alumni> alu = new ArrayList();
        alu.add(al);
        //ad.setAd(alu);
        
        Alumni al1 = new Alumni();
        al1.setStudentProfile(sp1);
        al1.setGradutationYear(2021);
        al1.setEmp(em);
        al1.setPosition("SDE-2");
        HashMap<String, Alumni> map1 = al1.getAlumniDir();
        map1.put("0112304", al1);
        al1.setAlumniDir(map1);
        alu.add(al);
        ad.setAd(alu);
        System.out.println("AS "+ ad.getAd().size());
     }
     
     


}
