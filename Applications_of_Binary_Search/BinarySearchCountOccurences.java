import java.io.*;
public class BinarySearchCountOccurences {
    public static void main(String[] args)
    {
    	int a[] = {2,4,5,10,10,10,10,13,18,20};
    	int toggle=0;
    	int firstIndex = findFirst(a,10);
    	if(firstIndex==-1)
    	{
    		System.out.println("Element not found in array");
    		toggle=-1;
    	}
    	if(toggle==0)
    	{
    	  int lastIndex = findLast(a,10);
    	   System.out.println(lastIndex-firstIndex+1);
    	}
    }
    public static int findFirst(int a[],int search)
    {
    	int low = 0;
    	int high = a.length-1;
    	int result = -1;
    	int mid;
    	while(low<=high)
    	{
    		mid = (low + high)/2;
    		if(a[mid]==search)
    		{
    			result=mid;
    			high = mid -1;
    		}
    		else if(a[mid]>search)
    		{
    			high=mid-1;
    		}
    		else
    		{
    			low = mid+1;
    		}
    	}
    	return result;
    }
    public static int findLast(int a[],int search)
    {
    	int low = 0;
    	int high = a.length-1;
    	int result = -1;
    	int mid;
    	while(low<=high)
    	{
    		mid = (low + high)/2;
    		if(a[mid]==search)
    		{
    			result=mid;
    			low = mid +1;
    		}
    		else if(a[mid]>search)
    		{
    			high=mid-1;
    		}
    		else
    		{
    			low = mid+1;
    		}
    	}
    	return result;
    }
}
