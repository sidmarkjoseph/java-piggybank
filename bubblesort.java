import java.io.*;
import java.util.*;
import java.lang.*;

public class bubblesort
{
   public static void main(String[] args)
     {
        int a[]= new int[10];
         int i;
          System.out.println("Enter the elements of the array\n");
          Scanner in =new Scanner(System.in);
          for(i=0;i<a.length;i++)
            a[i] = Integer.parseInt((in.nextLine()));
           bubblesort(a);
       }

     static void bubblesort(int a[])
      {
          int i,j;
          for(i=0;i<a.length;i++)
          {
             for(j=0;j<a.length-1;j++)
              {
                  if(a[j]>a[j+1])
                     {
                             int temp = a[j+1];
                              a[j+1]=a[j];
                               a[j]=temp;
                     }
                  }

              }
             for(i=0;i<a.length;i++)
               System.out.print(a[i]+" ");
         
            }
}