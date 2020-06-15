/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Course{
    String code,instructor;
    ArrayList<String> students;
    public Course(String code,String instructor){
        this.code=code;
        this.instructor=instructor;
        students=new ArrayList<String>();
    }
    public String getInstructor(){
        return this.instructor;
    }
    public String getCode(){
        return this.code;
    }
    public void setInstructor(String instructor){
        this.instructor=instructor;
    }
    public void setCode(String code){
        this.code=code;
    }
    public ArrayList<String> getStudents(){
        return this.students;
    }
    public void addStudent(String name){
        students.add(name);
    }
    public void removeStudent(String name){
        students.remove(new String(name));
    }
    public String toString(){
        String str="Course code: "+this.code+", Instructor: "+this.instructor+", students: ";
        for (int counter = 0; counter < students.size(); counter++) { 		      
            str+=students.get(counter);
            if(counter==students.size()-2){
                str+=" and ";
            }else if (counter<students.size()-2){
                str+=", ";    
            } 
        }   
        str+=".";
        return str;
    }
    
    
}

class OnlineCourse extends Course{
    String usedApplication;
    public OnlineCourse(String usedApp,String code,String instructor){
        super(code,instructor);
        this.usedApplication=usedApp;
    }
    public String getUsedApplication(){
        return this.usedApplication;
    }
    public void setUsedApplication(String usedApp){
        this.usedApplication=usedApp;
    }
    public String toString(){
        return super.toString()+" Used Application: "+this.usedApplication;
    }
}
class ClassicCourse extends Course{
    int classroomCapacity;
    public ClassicCourse(int classCap,String code,String instructor){
        super(code,instructor);
        this.classroomCapacity=classCap;
    }
    
    public int getClassroomCapacity(){
        return this.classroomCapacity;
    }
    public void setClassroomCapacity(int classCap){
        this.classroomCapacity=classCap;
    }
    public String toString(){
        return super.toString()+" Classroom capacity: "+this.classroomCapacity;
    }
}
public class Main
{
    public static ArrayList<String> getOnlineCourses(Course[] courses,String student){
        ArrayList<String> codes=new ArrayList<String>();
        for(Course course: courses){
            if(course instanceof OnlineCourse){
                if(course.students.contains(student)){
                    codes.add(course.getCode());
                }
            }
        }
        return codes;
    }
    
	public static void Classinheritance(String[] args) {
	    Course courseArray[]=new Course[6];
	    ClassicCourse tmp;
	    courseArray[0]=new OnlineCourse("Google Meet","123","Amjath");
	    courseArray[0].addStudent("Sayid");
	    courseArray[0].addStudent("Sajid");
	    
	    courseArray[1]=new ClassicCourse(50,"456","Farook");
	    courseArray[1].addStudent("Shadi");
	    courseArray[1].addStudent("Samir");
	    
	    courseArray[2]=new OnlineCourse("Google Meet","789","Zahir");
	    courseArray[2].addStudent("Hicham");
	    courseArray[2].addStudent("Sajid");
	    
	    courseArray[3]=new ClassicCourse(54,"987","Labeeb");
	    courseArray[3].addStudent("Shadi");
	    courseArray[3].addStudent("Samir");
	    
	    courseArray[4]=new OnlineCourse("Google Meet","654","Roshan");
	    courseArray[4].addStudent("Hicham");
	    courseArray[4].addStudent("Sajid");
	    
	    courseArray[5]=new ClassicCourse(55,"321","Rami");
	    courseArray[5].addStudent("Shadi");
	    courseArray[5].addStudent("Samir");
	    ArrayList<String> codes=getOnlineCourses(courseArray,"Hicham");
	    System.out.println("Online courses taken by Hicham: "+codes);
	    System.out.println("Classic courses with classroom capacity greater than 50");
	    
	    for(Course course: courseArray){
	        if(course instanceof ClassicCourse){
	            tmp=(ClassicCourse)course;
	            
	            if(tmp.getClassroomCapacity()>50){
	                System.out.println(tmp);
	            }
	            
	        }
	    }
	    
	}
}
