import java.util.Comparator;

public class SortBy implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student student1=null;
		Student student2=null;
		if(o1 instanceof Student){
			 student1=(Student)o1;
		}
		if(o2 instanceof Student){
			 student2=(Student)o2;
		}
		//
		/*
		 * returning 1 will store student2 first then student1
		 */
		if(student1.getCgpa() < student2.getCgpa()){
			return 1;
		}
		 if(student1.getCgpa()==student2.getCgpa()){
			/*
			 * returning 1 will store student2 then student1
			 */
			if(student1.getName().compareTo(student2.getName())>0){
				return 1;
			}
			else if(student1.getName().compareTo(student2.getName())==0){
				if(student1.getId()>student2.getId()){
					return 1;
				}
			}
		}
		
		return -1;
	}

}
