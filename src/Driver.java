import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
	private int numberOfStudents;
	private Scanner scanner;
	private Student student;
	private List<Student> studentList;
	
	
	Driver(){
		scanner=new Scanner(System.in);
	}
	
	public void createStudents(){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		numberOfStudents=scanner.nextInt();
		studentList=new LinkedList<>();
		for(int i=0;i<numberOfStudents;i++){
		
			student=new Student();			
			student.setId(scanner.nextInt());
			student.setName(scanner.next());			
			student.setCgpa(scanner.nextDouble());	
			studentList.add(student);
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public void sortByComparator(){
		Collections.sort(studentList,new SortBy());
	}
	
	public void sortStudents(){
		for(int i=0;i<studentList.size();i++){
			for(int j=0;j<studentList.size()-i-1;j++){
				Student student1=studentList.get(j);
			    Student	student2=studentList.get(j+1);
			    if(student1.getCgpa()==student2.getCgpa()){
			    	 if(student1.getName().compareTo(student2.getName())>0){
			    		 studentList.set(j, student2);
			    		 studentList.set(j+1, student1);
			    	 }
			    	 else if(student1.getName().compareTo(student1.getName())==0){
			    		  if(student1.getId()>student2.getId()){
			    			  studentList.set(j, student2);
					    		 studentList.set(j+1, student1);  
			    		  }
			    	 }
			    }
			    else if(student1.getCgpa()<student2.getCgpa()){
			    	 studentList.set(j, student2);
		    		 studentList.set(j+1, student1); 
			    }
			}
		}
	}
	
	public void printStudents(){
		System.out.println("---------------- Students --------------------");
      for(int i=0;i<studentList.size();i++){		
    	  System.out.println(studentList.get(i));
        }
      }
	public static void main(String[] args) {
		Driver driver=new Driver();
		driver.createStudents();
		driver.printStudents();
		//driver.sortStudents();
		driver.sortByComparator();
		driver.printStudents();
	}

}
