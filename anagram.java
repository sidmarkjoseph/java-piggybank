
import java.io.*;
import java.util.*;
public class anagram {
    String str1;
    String str2;
    void acceptStrings(String a,String b)
    {
    	str1=a;
    	str2=b;
    }
    boolean isAnagram()
    {
    	int flag=0;
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
    	for(int i=0;i<str1.length();i++)
    	{
    		if(hm.containsKey(str1.charAt(i)))
    			hm.put(str1.charAt(i),hm.get(str1.charAt(i))+1);
    		else
    			hm.put(str1.charAt(i),1);
    		
    			
    	}
    	for(int i=0;i<str2.length();i++)
    	{
    		if(hm.containsKey(str2.charAt(i)))
    		{
    			hm.put(str2.charAt(i),hm.get(str2.charAt(i))-1);
    		}
    		else if(!hm.containsKey(str2.charAt(i)))
    		{
    			flag=1;
    		}
    	}
    	if(flag==1)
    		return false;
    	for (Map.Entry<Character, Integer> entry : hm.entrySet())
    	{
    		if(entry.getValue()==0)
    			continue;
    		else
    		{
    			flag=1;
    			break;
    		}
    	}
    	if(flag==1)
    		return false;
    	else
    		return true;
    }
    public static void main(String[] args)
    {
    	anagram a = new anagram();
    	a.acceptStrings("rain","sid");
    	boolean toggle = a.isAnagram();
    	if(toggle==true)
    		System.out.println("Anagrams");
    	else
    		System.out.println("Not anagrams");
    }
}
