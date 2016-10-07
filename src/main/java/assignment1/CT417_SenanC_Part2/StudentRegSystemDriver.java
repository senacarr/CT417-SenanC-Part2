package assignment1.CT417_SenanC_Part2;

import assignment1.CT417_SenanC_Part1.Student;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.ArrayList;

public class StudentRegSystemDriver 
{
    public static void main( String[] args )
    {   	
    	ArrayList<Student> studentList = makeStudents(10);
    	for(Student s : studentList)
    	{
    		System.out.println("Name: "       + s.getStudentName()
    		                 + "\nAge: "      + s.getStudentAge()
    		                 + "\nDOB: "      + s.getStudentDOB()
    		                 + "\nID : "      + s.getStudentID()
    		                 + "\nUserName: " + s.getUsername()
    		                 + "\n\n***************************");    		
    	}
    	
    }
    
    private static ArrayList<Student> makeStudents(int num)
    {
    	if(num <= 0)
    		num = 100;
    	
    	Random r = new Random();

    	ArrayList<String> names = new ArrayList<String>();
    	while(names.size() < num)
    	{
    		names.add("I'm Creative" + r.nextInt(num));
    	}

    	ArrayList<Calendar> dates = new ArrayList<Calendar>();
    	while(dates.size() < num)
    	{
    		dates.add(new GregorianCalendar((2000 - r.nextInt(20)), r.nextInt(12), r.nextInt(28)));
    	}
    	
    	ArrayList<Student> students = new ArrayList<Student>();
    	for(int i = 0; i < num; i++)
    	{
    		try {
				students.add(new Student(names.get(i), dates.get(i)));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
    	}
    	
    	return students;
    }
}
