package Collection;

//Converting List To LinkedHashSet

//To Remove Duplicates 
//Maintain Insertion Order
//Index Based

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class List_To_LinkedHashSet 
{
	public static void main(String[] args)
	{
		List<String> al=new ArrayList();
		al.add("Priya");
		al.add("Banu");
		al.add("Priya");
		al.add("Akshu");
		al.add("Sai");
		al.add("Banu");
		
		
		//STORING ELEMENTS IN LIST
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
//			Priya
//			Banu
//			Priya
//			Akshu
//			Sai
//			Banu
		}
		
		//CONVERTING TO SET So That It Won't Allow Duplicates
		//Use LinkedHashSet- Don't allow Duplicates & Insertion Order Maintained
		LinkedHashSet<String> set=new LinkedHashSet();
		
		//OR //Set<String> set=new LinkedHashSet();
		
		//Adding ArrayList Elements to Set
		set.addAll(al);
		
		//First Clearing ArrayList
		al.clear();
		
		//Next Adding All the Elements From Set to ArrayList
		al.addAll(set);
		
		System.out.println(al);//[Priya, Banu, Akshu, Sai]-Displays as List
		
		for(String s:al)
		{
			System.out.println(s); //Prints in NextLine
//			Priya
//			Banu
//			Akshu
//			Sai

		}
	}

}
