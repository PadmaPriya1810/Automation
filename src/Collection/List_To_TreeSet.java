package Collection;


//Converting List To TreeSet

//To Remove Duplicates 
//Sorted To Ascending Order
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class List_To_TreeSet 
{

	public static void main(String[] args)
	{
		//Create a List
		List<String> al=new ArrayList();
		al.add("Priya");
		al.add("Banu");
		al.add("Priya");
		al.add("Akshu");
		al.add("Sai");
		al.add("Banu");
		
		System.out.println(al);//[Priya, Banu, Priya, Akshu, Sai, Banu]
		
		
		//Creating TreeSet to Remove Duplicates & Ascending Order
		TreeSet s=new TreeSet();
		
		//ArrayList Elements added to TreeSet-So that Duplicates Removed, Sorted in Ascending Order
		s.addAll(al);
		
		//Clearing ArrayList(al)- B'Coz Again we need to store the Elements from Set To ArrayList
		al.clear();//If You Don't Clear ArrayList Elements also Present along with TreeSet Elements
		
		
		//Adding All the Elements From TreeSet To ArrayList
		al.addAll(s);
		
		System.out.println(al);//[Akshu, Banu, Priya, Sai]-Duplicates Removed & Sorted in Ascending Order
	
		for(String ele:al)
		{
			System.out.println(ele);
		}
	}
}

