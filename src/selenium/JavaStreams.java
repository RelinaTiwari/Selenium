package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name = "";
		String storedname = "";
		int count = 0;
		//creating 1st list
		ArrayList<String> names1 = new ArrayList<String>();
		for (int i =0;i<3;i++)
		{
			System.out.println("Enter name : ");
			name = sc.nextLine();
			names1.add(name);
		}
		System.out.println(names1.size());
		//creating 2nd list
		ArrayList<String> names2 = new ArrayList<String>();
		for (int i =0;i<3;i++)
		{
			System.out.println("Enter name : ");
			name = sc.nextLine();
			names2.add(name);
		}
		System.out.println(names2.size());
		for(int i =0;i<names1.size();i++)
		{
			
			storedname = names1.get(i);
			if(storedname.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println("number of names starting with A "+count);
		JavaStreams st = new JavaStreams();
		st.streamFilter(names1);
		st.streamlimits(names1);
		st.streamMaps(names1);
		st.streamSort(names1);
		st.streamConcat(names1 , names2);
		
	}
	//Using streams counting names starting with "A"
	public void streamFilter(ArrayList<String> store)
	{
		long cc = store.stream().filter(s-> s.startsWith("A")).count();
		System.out.println(cc);
	}
	//using streams printing all names
	public void streamlimits(ArrayList<String> store)
	{
		store.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	}
	//Print names ending with a and in upaaer case
	public void streamMaps(ArrayList<String> store)
	{
		store.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	public void streamSort(ArrayList<String> store)
	{
		store.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	//concatinate 2 lists
	public void streamConcat(ArrayList<String> names1 , ArrayList<String> names2)
	{
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		newStream.forEach(s->System.out.println(s));
		//match function
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	//get values in list after manupulatio
	public void streamCollect(ArrayList<String> names1)
	{
		List<String> names3 = names1.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
	}
	
	
}
