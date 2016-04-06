import java.io.*;
import java.util.*;
import java.lang.*;
public class PlayDataStructures {
	static int[] getArrayFromUsers()
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter the number of numbers");
		int len = Integer.parseInt(in.nextLine());
		int a[] = new int[len];
		for(int i=0; i <a.length; i++ )
		{
			a[i]= Integer.parseInt(in.nextLine());
			
		}
		return a;
	}
   static void display(int[] a)
   {
	   for(int i=0; i< a.length; i++)
		   System.out.println(a[i]);
   }
   static void playHashMapOne()
   {
	   Scanner in = new Scanner(System.in);
	   System.out.println("Enter String");
	  String str= in.nextLine();
	  HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
	  int i;
	  for(i=0;i < str.length();i++)
	  {
		if(hm.containsKey(str.charAt(i)))
				{
			       hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
				}
		else
		{
		   hm.put(str.charAt(i),1);
		}
	  }
		   
		   for(Map.Entry<Character,Integer> entry :hm.entrySet())
		   {
			   if(entry.getValue() > 1)
			   {
				   System.out.println(entry.getKey() + "is repeated" + entry.getValue() + "times \n");
			   }
		   }
	  
	  
   }
   public static void playwithTreeMap()
   {
	   TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
	   tm.put(5,0);
	   tm.put(3,0);
	   tm.put(2,0);
	   tm.put(1, 0);
	   tm.put(4,0);
	  
	   Set<Integer> a = tm.keySet();
	   for(int temp : a)
	   {
		   System.out.println(temp + "=" + tm.get(temp));
		   
	   }
   }
   static void playwithSet(Set<String> set)
   {
	   for(String temp: set)
	   {
		   System.out.println(temp);
	   }
   }
  
  
   public static void main(String[] args)
   {
	   int b[] = getArrayFromUsers();
	   display(b);
	   playHashMapOne();
	     playwithTreeMap();
	   ArrayList<String> c= new ArrayList<>(Arrays.asList("foo","bar","popsod"));
	   Collections.sort(c);
	   
	   for(String temp:c)
	   {
		   System.out.println(temp);
	   }
	   Set<String> set = new HashSet<String>();
	   set.add("foo");
	   set.add("bar");
	   set.add("foo");
	   playwithSet(set);
	   LinkedList<String> ll = new LinkedList<String>();
	   //enqueue("Siddharth", ll);
	   //enqueue("nayan",ll);
	   LinkedSid a = new LinkedSid();
	   a.enqueue("Siddharth");
	   a.enqueue("nayan");
	   for(String temp : a.ll)
	   {
		   System.out.println(temp);
	   }
	   String s =a.dequeue();
	   System.out.println(a.ll);
   }
}
class LinkedSid
{
	   LinkedList<String> ll;
	   LinkedSid()
	   {
	      ll = new LinkedList<String>();
	   }
	   void enqueue(String temp)
	   {
		   ll.addFirst(temp);
		   //System.out.println(ll);
	   }
	   String dequeue()
	   {
		   String temp = ll.getLast();
		   ll.removeLast();
		   //System.out.println(ll);
		   return temp;
	   }
}
