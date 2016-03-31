import java.io.*;
import java.util.*;
import java.lang.*;
public class vector
{
   Vector e;
  vector()
   {
       e= new Vector();
   }
  void addElementToVector(int obj)
   {
        e.addElement(obj);
     }
     void displayElements()
      {
          Enumeration num = e.elements();
         while(num.hasMoreElements())
          {
                 
                System.out.println(num.nextElement());
           }
       }
     public static void main(String[] args)
   {
      vector v = new vector();
     v.addElementToVector(new Integer(2));
     v.addElementToVector(new Integer(3));
     v.displayElements();
}}


