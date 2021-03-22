/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestData;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Department.DepartmentDirectory;
import info5100.university.example.Persona.Faculty.Alumni.Alumni;
import info5100.university.example.Persona.Faculty.Alumni.AlumniDirectory;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.EmployeeDirectory;
import info5100.university.example.Persona.Faculty.Alumni.CompanyEmployers.Employers;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author shreyascr
 */
public class TestData {

    static TestData testData;
    
    public  static TestData getInstance()
    {
        if(testData==null)
        {
            testData = new TestData();
        }
        
        return testData;
        
    }
    
    ArrayList<Employers> emp = new ArrayList<>();
    AlumniDirectory ad  = new AlumniDirectory();
    EmployeeDirectory ed = new EmployeeDirectory();
    DepartmentDirectory dd = new DepartmentDirectory();

    

    StudentDirectory sd ;
    HashMap<String, Alumni> map;


    public  DepartmentDirectory getDd() {
        return dd;
    }

    public AlumniDirectory getAd() {
        return ad;
    }
    
    public EmployeeDirectory getED(){
        return ed;
    }

    public StudentDirectory getSd() {
        return sd;
    }

    public HashMap<String, Alumni> getMap() {
        return map;
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
         
        
        
        
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
        em.setEmployerName("");
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
        
        Course courseinfo1 = department.newCourse("Application Engineering", "Info 5100", 4); 
        courseinfo1.setRating(10);
        Course courseinfo2 = department.newCourse("DataScience", "Info 5101", 4);
        courseinfo2.setRating(2);
        Course courseinfo3 = department.newCourse("Web Design", "Info 6203", 4);
        courseinfo3.setRating(5);
        Course courseinfo4 = department.newCourse("DataWarehouse", "Info 7546", 4);
        courseinfo4.setRating(4);
        Course courseinfo5 = department.newCourse("Web Tools", "Info 6100", 4); 
        courseinfo5.setRating(6);
        Course courseinfo6 = department.newCourse("Cloud", "Info 7101", 4);
        courseinfo6.setRating(8);
        Course courseinfo7 = department.newCourse("DMDB", "Info 6353", 4);
        courseinfo7.setRating(9);
        Course courseinfo8 = department.newCourse("AdvanceDataScience", "Info 7106", 4);
        courseinfo8.setRating(10);
        Course coursecsc1 = department1.newCourse("PDP", "CS 5010", 4);
        coursecsc1.setRating(7);
        Course coursecsc2 = department1.newCourse("NLP", "CS 5204", 4);
        coursecsc2.setRating(9);
        Course coursecsc3 = department1.newCourse("AI", "CS 7010", 4);
        coursecsc3.setRating(10);
        Course coursecsc4 = department1.newCourse("Network", "CS 6284", 4);
        coursecsc4.setRating(8);
        
        
        

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseSchedule courseschedule1 = department1.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("Info 5100");
        courseoffer.generatSeats(10);
        
        CourseOffer courseoffer2 = courseschedule.newCourseOffer("Info 5101");
        courseoffer2.generatSeats(10);
        
        CourseOffer courseoffer3 = courseschedule.newCourseOffer("Info 6203");
        courseoffer3.generatSeats(10);
        
        CourseOffer courseoffer4 = courseschedule.newCourseOffer("Info 7546");
        courseoffer4.generatSeats(10);
        
        CourseOffer courseoffer5 = courseschedule.newCourseOffer("Info 6100");
        courseoffer5.generatSeats(10);
        
        CourseOffer courseoffer6 = courseschedule.newCourseOffer("Info 7101");
        courseoffer6.generatSeats(10);
        
        CourseOffer courseoffer7 = courseschedule.newCourseOffer("Info 6353");
        courseoffer7.generatSeats(10);
        
        CourseOffer courseoffer8 = courseschedule.newCourseOffer("Info 7106");
        courseoffer8.generatSeats(10);
        CourseOffer courseoffer1 = courseschedule1.newCourseOffer("CS 5010");
        courseoffer1.generatSeats(10);
        
        CourseOffer courseoffer9 = courseschedule1.newCourseOffer("CS 6284");
        courseoffer9.generatSeats(10);
        
        CourseOffer courseoffer10 = courseschedule1.newCourseOffer("CS 5204");
        courseoffer10.generatSeats(10);
        
        CourseOffer courseoffer11 = courseschedule1.newCourseOffer("CS 7010");
        courseoffer11.generatSeats(10);


        
        PersonDirectory pd = department.getPersonDirectory();
      //  PersonDirectory pd1 = department1.getPersonDirectory();

        Person person =  pd.newPerson("Personinfo1");
        Person person1 = pd.newPerson("Personinfo2");
        Person person2 = pd.newPerson("Personinfo3");
        Person person3 = pd.newPerson("Personinfo4");
        Person person4 =  pd.newPerson("Personinfo5");
        Person person5 = pd.newPerson("Personinfo6");
        Person person6 = pd.newPerson("Personinfo7");
        Person person7 = pd.newPerson("Personinfo8");
        Person person8 =  pd.newPerson("Personinfo9");
        Person person9 = pd.newPerson("Personinfo10");
        Person person10 = pd.newPerson("Personinfo11");
        Person person11 = pd.newPerson("Personinfo12");
        Person person12 =  pd.newPerson("Personinfo13");
        Person person13 = pd.newPerson("Personinfo14");
        Person person14 = pd.newPerson("Personinfo15");
        Person person15 = pd.newPerson("Personinfo16");
        Person person16 =  pd.newPerson("Personcs1");
        Person person17 = pd.newPerson("Personcs2");
        Person person18 = pd.newPerson("Personcs3");
        Person person19 = pd.newPerson("Personcs4");
        Person person20 = pd.newPerson("Personcs5");
        Person person21 = pd.newPerson("Personcs6");
        Person person22 = pd.newPerson("Personcs7");
        Person person23 = pd.newPerson("Personcs8");
        
        
        sd = department.getStudentDirectory();
        StudentDirectory sd1 = department1.getStudentDirectory();

        StudentProfile student = sd.newStudentProfile(person);
        StudentProfile student1 = sd.newStudentProfile(person1);
        StudentProfile student2 = sd.newStudentProfile(person2);
        StudentProfile student3 = sd.newStudentProfile(person3);
        StudentProfile student4 = sd.newStudentProfile(person4);
        StudentProfile student5 = sd.newStudentProfile(person5);
        StudentProfile student6= sd.newStudentProfile(person6);
        StudentProfile student7 = sd.newStudentProfile(person7);
        StudentProfile student8= sd.newStudentProfile(person8);
        StudentProfile student9 = sd.newStudentProfile(person9);
        StudentProfile student10 = sd.newStudentProfile(person10);
        StudentProfile student11 = sd.newStudentProfile(person11);
        StudentProfile student12= sd.newStudentProfile(person12);
        StudentProfile student13= sd.newStudentProfile(person13);
        StudentProfile student14= sd.newStudentProfile(person14);
        StudentProfile student15= sd.newStudentProfile(person15);
        StudentProfile student16= sd1.newStudentProfile(person16);
        StudentProfile student17= sd1.newStudentProfile(person17);
        StudentProfile student18= sd1.newStudentProfile(person18);
        StudentProfile student19 = sd1.newStudentProfile(person19);
        StudentProfile student20 = sd1.newStudentProfile(person20);
        StudentProfile student21 = sd1.newStudentProfile(person21);
        StudentProfile student22 = sd1.newStudentProfile(person22);
        StudentProfile student23 = sd1.newStudentProfile(person23);
        
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        CourseLoad courseload1 = student1.newCourseLoad("Fall2020"); 
        CourseLoad courseload2 = student2.newCourseLoad("Fall2020"); 
        CourseLoad courseload3 = student3.newCourseLoad("Fall2020");
        CourseLoad courseload4 = student4.newCourseLoad("Fall2020");
        CourseLoad courseload5 = student5.newCourseLoad("Fall2020");
        CourseLoad courseload6 = student6.newCourseLoad("Fall2020");
        CourseLoad courseload7 = student7.newCourseLoad("Fall2020");
        CourseLoad courseload8 = student8.newCourseLoad("Fall2020");
        CourseLoad courseload9 = student9.newCourseLoad("Fall2020");
        CourseLoad courseload10 = student10.newCourseLoad("Fall2020");
        CourseLoad courseload11 = student11.newCourseLoad("Fall2020");
        CourseLoad courseload12= student12.newCourseLoad("Fall2020");
        CourseLoad courseload13 = student13.newCourseLoad("Fall2020");
        CourseLoad courseload14 = student14.newCourseLoad("Fall2020");
        CourseLoad courseload15 = student15.newCourseLoad("Fall2020");
        CourseLoad courseload16 = student16.newCourseLoad("Fall2020");
        CourseLoad courseload17 = student17.newCourseLoad("Fall2020");
        CourseLoad courseload18 = student18.newCourseLoad("Fall2020");
        CourseLoad courseload19 = student19.newCourseLoad("Fall2020");
        CourseLoad courseload20 = student20.newCourseLoad("Fall2020");
        CourseLoad courseload21 = student21.newCourseLoad("Fall2020");
        CourseLoad courseload22 = student22.newCourseLoad("Fall2020");
        CourseLoad courseload23 = student23.newCourseLoad("Fall2020");
        
        FacultyDirectory fd = department.getFacultyDirectory();
       
        FacultyDirectory fd1 = department1.getFacultyDirectory();

        
        Person prof1 = pd.newPerson("prof");
        Person prof2 = pd.newPerson("prof1");
        Person prof3 = pd.newPerson("prof2");
        Person prof4 = pd.newPerson("prof3");
        Person prof5 = pd.newPerson("prof4");
        Person prof6 = pd.newPerson("prof5");
        Person prof7 = pd.newPerson("prof6");
        Person prof8 = pd.newPerson("prof7");
        Person prof9 = pd.newPerson("prof8");
        Person prof10 = pd.newPerson("prof9");
        Person prof11 = pd.newPerson("prof10");
        Person prof12 = pd.newPerson("prof11");
        
        
        

        FacultyProfile fp = fd.newStudentProfile(prof1);
        fp.setFacultyRatings(10);

        FacultyProfile fp1 = fd1.newStudentProfile(prof2);
      //  fp1.setFacultyRatings(9);
        FacultyProfile fp2 = fd.newStudentProfile(prof3);
        fp2.setFacultyRatings(1);
        FacultyProfile fp3 = fd.newStudentProfile(prof4);
        fp3.setFacultyRatings(7);
        
        FacultyProfile fp4 = fd.newStudentProfile(prof5);
        fp4.setFacultyRatings(4);

        FacultyProfile fp5 = fd.newStudentProfile(prof6);
        fp5.setFacultyRatings(8);

        FacultyProfile fp6 = fd.newStudentProfile(prof7);
        FacultyProfile fp7 = fd.newStudentProfile(prof8);
        FacultyProfile fp8 = fd1.newStudentProfile(prof9);
        FacultyProfile fp9 = fd1.newStudentProfile(prof10);
        FacultyProfile fp10 = fd1.newStudentProfile(prof11);
        FacultyProfile fp11 = fd1.newStudentProfile(prof12);
        
        

        
        
        courseoffer.AssignAsTeacher(fp);
        fp.AssignAsTeacher(courseoffer);
        courseoffer1.AssignAsTeacher(fp1);

        fp1.AssignAsTeacher(courseoffer1);

        courseoffer2.AssignAsTeacher(fp2);
        courseoffer3.AssignAsTeacher(fp3);
        courseoffer4.AssignAsTeacher(fp4);
        courseoffer5.AssignAsTeacher(fp5);
        courseoffer6.AssignAsTeacher(fp6);
        courseoffer7.AssignAsTeacher(fp7);
        courseoffer8.AssignAsTeacher(fp8);
        courseoffer9.AssignAsTeacher(fp9);
        courseoffer10.AssignAsTeacher(fp10);
        courseoffer11.AssignAsTeacher(fp11);

        
        

        courseload.newSeatAssignment(courseoffer); //register student in class
        courseload1.newSeatAssignment(courseoffer);
        courseload2.newSeatAssignment(courseoffer2); //register student in class
        courseload3.newSeatAssignment(courseoffer2);
        courseload4.newSeatAssignment(courseoffer3);
        courseload5.newSeatAssignment(courseoffer3);
        courseload6.newSeatAssignment(courseoffer4); //register student in class
        courseload7.newSeatAssignment(courseoffer4);
        courseload8.newSeatAssignment(courseoffer5);
        courseload9.newSeatAssignment(courseoffer5);
        courseload10.newSeatAssignment(courseoffer6); //register student in class
        courseload11.newSeatAssignment(courseoffer6);
        courseload12.newSeatAssignment(courseoffer7);
        courseload13.newSeatAssignment(courseoffer7);
        courseload14.newSeatAssignment(courseoffer8); //register student in class
        courseload15.newSeatAssignment(courseoffer8);
        courseload16.newSeatAssignment(courseoffer1);
        courseload17.newSeatAssignment(courseoffer1);
        courseload18.newSeatAssignment(courseoffer9);
        courseload19.newSeatAssignment(courseoffer9);
        courseload20.newSeatAssignment(courseoffer10); //register student in class
        courseload21.newSeatAssignment(courseoffer10);
        courseload22.newSeatAssignment(courseoffer11);
        courseload23.newSeatAssignment(courseoffer11);


        
        rankProfessorByDepartment(department);
        EmployeeDirectory ed = new EmployeeDirectory();
        ArrayList<Employers> emp = new ArrayList<>();
        Employers em = new Employers();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
        
        StudentProfile sp = sd.findStudent("Personinfo1");
        sp.setIsAlumni(true);
        
        //AlumniDirectory ad = new AlumniDirectory();
        ArrayList<Alumni> all = new ArrayList<>();
        AlumniDirectory ad1 = new AlumniDirectory();
        
        Alumni al = new Alumni();
        al.setStudentProfile(sp);
        al.setGradutationYear(2020);
        al.setEmp(em);
        al.setPosition("SDE");
        al.setSalaryRange(25000);
        al.setPromotions(2);
        al.calculateAMG();
        al.careerSuccessMetric();
        sp.setAl(al);
        
        HashMap<String, Alumni> map = new HashMap<>();
        map.put("Personinfo1", al);
        al.setAlumniDir(map);
        all.add(al);
        
        
        StudentProfile sp1 = sd.findStudent("Personinfo2");
        sp1.setIsAlumni(true);
       // System.out.println("");
        //Alumni al = new Alumni();
        Alumni al1 = new Alumni();
        al1.setStudentProfile(sp1);
        al1.setGradutationYear(2021);
        al1.setEmp(em);
        al1.setPosition("SDE2");
        al1.setSalaryRange(15000);
        al1.setPromotions(5);
        al1.calculateAMG();
        al1.careerSuccessMetric();
        map.put("Personinfo2", al1);
        al1.setAlumniDir(map);
        sp1.setAl(al1);
        
        all.add(al1);
        StudentProfile sp2 = sd1.findStudent("Personcs1");
        sp2.setIsAlumni(true);
       // System.out.println("");
        //Alumni al = new Alumni();
        Alumni al2 = new Alumni();
        al2.setStudentProfile(sp2);
        al2.setGradutationYear(2021);
        al2.setEmp(em);
        al2.setPosition("SDE1");
        al2.setSalaryRange(20000);
        al2.setPromotions(5);
        al2.calculateAMG();
        al2.careerSuccessMetric();
        
        map.put("Personcs1", al2);
        al2.setAlumniDir(map);
        sp2.setAl(al2);
        all.add(al2);
        
        StudentProfile sp3 = sd1.findStudent("Personcs2");
        sp3.setIsAlumni(true);
       // System.out.println("");
        //Alumni al = new Alumni();
        Alumni al3 = new Alumni();
        al3.setStudentProfile(sp3);
        al3.setGradutationYear(2021);
        al3.setEmp(em);
        al3.setPosition("SDE2");
        al3.setSalaryRange(25000);
        al3.setPromotions(5);
        al3.calculateAMG();
        al3.careerSuccessMetric();
        map.put("Personcs2", al3);
        al3.setAlumniDir(map);
        sp3.setAl(al3);
        all.add(al3);
        
        ad1.setAd(all);
             
         System.out.println("A LL "+ al.careerSuccessMetric());
    }
     
     
     
     
     //Alumni Growth Metric
     public void calculateAGM(){
        
        ArrayList<Alumni> all = ad.getAd();
        
        for(Alumni a : all){
            
        }
         
      
                 
     } 
     
        public void rankProfessorByDepartment(Department d){
        
        ArrayList<FacultyProfile> fp = d.getFacultyDirectory().getTeacherlist();
        for(FacultyProfile f : fp)
            System.out.println("BEfore Sorted form "+ f.getFacultyRatings());
        Collections.sort(fp,new Comparator<FacultyProfile>() {
            @Override
            public int compare(FacultyProfile o1, FacultyProfile o2) {
               
                return o2.getFacultyRatings() - o1.getFacultyRatings();
            }
        } );
        for(FacultyProfile f : fp)
            System.out.println("Sorted form "+ f.getFacultyRatings());

                
        
    }
    
}
