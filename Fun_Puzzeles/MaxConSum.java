import java.util.*;
import java.math.*;
public class MaxConSum {

	public static void main(String[] args)
	{
		int a[] = {2,-5,-100,8};
		int store[] = new int[a.length];
		//ArrayList<Integer> store = new ArrayList<Integer>();
		for(int i=0; i < a.length;i++)
		{
			if(i==0)
				store[i] = a[i];
			else
			store[i] = (Math.max(a[i], a[i] + store[i-1]));
		}
		int max = store[0];
		for(int temp: store)
		{
			if(temp > max)
				max = temp;
		}
		System.out.println(max);
	}
}
