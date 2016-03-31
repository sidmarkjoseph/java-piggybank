import java.io.*;

public class frog
{
  public static void main(String[] args) 
   {
       int A[]={3,53,10,15},D=5,X=20;
      int N=A.length-1;
       int result=solution(A,D,N,X);
      System.out.println(result);
    }
   public static int solution(int A[],int D, int N,int X)
   {
      int time=0,i=0;
     if(X<=D)
       return 0;
      if(i==N)
      return -1;
      for(i=0;i<=N;i++)
      {
          if(A[i]<=D && X-A[i]<=D)
         {
             time=i;
             break;
            
          }
          else if(X-A[i]<=D)
           {
               time=solution(A,D,i,A[i]);
               if(time==-1)
                  break;
               else
                 {
                       time=i;
                       break;
                  }


            }
           else
              time=-1; 
        }
        
      return time;
    }
}
   
                           
             
  
      