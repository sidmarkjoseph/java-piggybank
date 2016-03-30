import java.io.*;
public class SortedArrayRotBinSearch {
   public static void main(String[] args)
   {
	   int a[]={11,12,2,3,5,8};
	   int count = binSearch(a);
	   System.out.print("The number of times the array has been rotated circularly = ");
	   System.out.println(count);
   }
   public static int binSearch(int a[])
   {
	   int low=0,high=a.length-1,result=0;
	   while(low<=high)
	   {
		   int mid=(low+high)/2;
		   int next=(mid+1)%a.length;
		   int prev = (mid+a.length-1)%a.length; 
		   if(a[low]<=a[high])
		   {
			   result=low;
			   break;
		   }
		   else if(a[mid]<a[next] && a[mid]<a[prev])
		   {
			   result=mid;
			   break;
		   }
		   else if(a[low]<a[mid])
			   low=mid+1;
		   else
			   high=mid-1;
		   
	   }
	   return result;
   }
}
