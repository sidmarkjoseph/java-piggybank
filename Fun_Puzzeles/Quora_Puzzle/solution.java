/* Java Solution that implements problem titled "Ontology" 
Author - Siddharth Mark Joseph
email-id - sjoseph631@gmail.com */

import java.io.*;
import java.util.*;
public class solution

{
  static int number_of_topics; // Holds the first input from user
  static Node[] array_of_nodes; // Array that holds the each topic as an object of class NODE
  static Vector hold_tree_string; // Holds the flat tree string as inputed by the user in Vector form
 static int number_of_questions; // Holds the second input which is the number of questions
 static String []question_hold;  // Array holds the set of questions inputed by the user
static String topic=""; // Holds current topic
static String actual_question=""; // Holds current question
 static String topicinquery=""; // Holds current topic in query
 static String query=""; // Holds the current query
 static int count; // Holds the current count of entered query



/* Creates the tree as required using array_of_nodes[] */
  static void createTree(int i,int k)
{
      int remember=k-1;      
      while(!(hold_tree_string.get(i).equals("("))&& !(hold_tree_string.get(i).equals(")")))
     {
          
          array_of_nodes[k]= new Node((String)hold_tree_string.get(i));
          array_of_nodes[remember].nodehold.add(array_of_nodes[k]);
          k++;
          i++;

       }
     if(hold_tree_string.get(i).equals(")"))
        return;
    else if(hold_tree_string.get(i).equals("("))
       createTree(i+1,k);
      
                 
   }  

   /* Adds function under respective topic */
     static void addquestionundertopic(int i)
    {
          try{
           if(array_of_nodes[i].str.equalsIgnoreCase(topic))
          {
                array_of_nodes[i].questionhold.add(actual_question);
                return;
          }
        }
         catch(Exception e)
          {
                return;
           }
          i++;
         addquestionundertopic(i);
   }
  
   /* Function extracts topic and actual question under query */               
   static void extracttopicandquestion(int i)
   {
     
        int j=0;
        for(int k=0;k<question_hold[i].length();k++)
       {
                    
            
           if(question_hold[i].charAt(k)==':')
              {
                 topic = question_hold[i].substring(j,k);
                  j=k+2;
               }
            actual_question  = question_hold[i].substring(j,question_hold[i].length());
         } 
        
   }   
     /* Extracts topic in query and also the query itself */             
     static void extracttopicinqueryandquery(String str)
    {
       int j=0;
        for(int i=0; i<  str.length(); i++)
        {
             if(str.charAt(i)==' ')
            {
                 j=i;
                 break;
             }
          }
         topicinquery = str.substring(0,j);
         query=str.substring(j+1, str.length());
    }

    /* Returns the count value required as output */
     static int extractoutput(int g)
     {
          int note=0;
        count=0;
            for(int i=0;i<array_of_nodes.length;i++)
             {
                  try{
                   if(array_of_nodes[i].str.equalsIgnoreCase(topicinquery))
                     {
                              note=i;
                              break;
                      }
                   }
                   catch(Exception e)
                    {
                           return count;
                     }
            }
           count = recursivetree(note);
           return count;
      }


     /* Helps extract output in returning count value */
     static int recursivetree(int note)
    {
       if(note==array_of_nodes.length)
           return count;
    
       if(!(array_of_nodes[note].questionhold.isEmpty()))
        {
            try{
             Iterator it= array_of_nodes[note].questionhold.iterator();
             while(it.hasNext())
               {
                      if(((String)it.next()).contains(query))
                         count++;
                 }
              }
           catch(Exception e)
            { return count;}
             note++;
             recursivetree(note);
             return count;
          }
        else
        {
               note++;
             recursivetree(note);
            return count;
         }
   }
       
           
   public static void main(String[] args)
   { 
      Scanner in =  new Scanner(System.in);
      number_of_topics = Integer.parseInt(in.nextLine());
     array_of_nodes = new Node[number_of_topics];
      Node rootnode=null;
      hold_tree_string = new Vector();
      String flat_tree_string = in.nextLine();
      flat_tree_string=flat_tree_string + ' ';
      
      int j=0,i=0;
      /* Populating hold_tree_string */
      for(i=0;i<=flat_tree_string.length()-1;i++)
      {
        
           if(flat_tree_string.charAt(i)==' ')
             {
                  hold_tree_string.addElement(flat_tree_string.substring(j,i));
                  
                  if(j==0)
                       array_of_nodes[0] = new Node(flat_tree_string.substring(j,i));
                    j=i+1;
                  
              }
        }
       
      /* test stub-----------
      Enumeration hold_tree_string_enum = hold_tree_string.elements();
      while(hold_tree_string_enum.hasMoreElements())
           System.out.println(hold_tree_string_enum.nextElement();
     System.out.println(rootnode.str);---------*/

      createTree(2,1); // Creates the data structure

      /* test stub------
      System.out.println(((Node)array_of_nodes[2].nodehold.get(0)).str);- */

      number_of_questions = Integer.parseInt(in.nextLine());
      question_hold = new String[number_of_questions];
      for(i=0;i < number_of_questions; i++)
       {
            question_hold[i] =  new String(in.nextLine());
        }

        /* test stub
       for(i=0;i < number_of_questions; i++)
       {
            System.out.println(question_hold[i]);
        }*/

      int z=0;
      for(i=0;i<number_of_questions;i++)
      {
              extracttopicandquestion(i);
              
              
              /* test stub--System.out.println(topic);
             System.out.println(actual_question); -- */   
   
             addquestionundertopic(z);
       } 

      /*-- test stub System.out.println((String)(array_of_nodes[3].questionhold.get(0)));--*/
     
     int number_of_queries = (Integer.parseInt(in.nextLine()));
     String []hold_queries = new String[number_of_queries];
     for( i=0;i < number_of_queries; i++)
    {
         hold_queries[i] = in.nextLine();
     }
     int output[] = new int[number_of_queries];
     for(i=0; i < number_of_queries; i++)
    {
              int g=0;
               extracttopicinqueryandquery(hold_queries[i]);

              /* test stub --- System.out.println(topicinquery);
               System.out.println(query); */

               output[i]=extractoutput(g);
            
      }
    
    for(i=0;i<number_of_queries;i++)
     {
         System.out.println(output[i]);
     }            
   }
}

/* Class Node */
class Node
{

    String str;
    Vector nodehold;
    Vector questionhold;
   public Node()
   {
      this.str="";
      nodehold=new Vector();
      questionhold = new Vector();
    }
    public Node(String str)
  {
      this.str=str;
      nodehold= new Vector();
     questionhold = new Vector();
   }
}

    
   