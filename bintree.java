

	import java.io.*;
	import java.util.*;
	 class Node
	{
	    int value;
	    Node leftchild;
	    Node rightchild;
	    boolean visited;
	   
	    Node(int value,boolean toggle)
	    {
	       this.value=value;
	       this.visited=toggle;
	     }
	     Node()
	    {
	    	 
	    }
	}
	 class BinaryTree
	{
	   Node root;
	   Queue<Node> t;
	   BinaryTree()
	   {
		   t = new LinkedList<Node>();
	   }
	   void inorderTraversal(Node focusnode)
	  {
	             if(focusnode==null)
	                 return;             
	             inorderTraversal(focusnode.leftchild);
	             System.out.println(focusnode.value);
	             inorderTraversal(focusnode.rightchild);
	 }
	 void postOrderTraversal(Node focusnode)
	  {
	       if(focusnode==null)
	         return;
	         postOrderTraversal(focusnode.leftchild);
	         postOrderTraversal(focusnode.rightchild);
	        System.out.println(focusnode.value);
	  }
	 void preOrderTraversal(Node focusnode)
	  {
	       if(focusnode==null)
	           return;
	      System.out.println(focusnode.value);
	      preOrderTraversal(focusnode.leftchild);
	     preOrderTraversal(focusnode.rightchild);
	  }
	 void dfs(Node root)
	 {
		 root.visited=true;
		 System.out.println(root.value);
		 if(root.leftchild==null && root.rightchild==null )
		    return;
		 else if(root.leftchild==null)
		 {
			 if(root.rightchild.visited == false)
			 {
				 dfs(root.rightchild);
			 }
		 }
		 else if(root.rightchild==null)
		 {
		  if(root.leftchild.visited == false)
		  {
			 dfs(root.leftchild);
		  }
		 }
		 else
		 {
			 dfs(root.leftchild);
			 dfs(root.rightchild);
		 }
		 
	 }
	 void bfs(Node root)
	 {
		 while(!t.isEmpty())
		 {
		    System.out.println(t.element().value);
		    Node temp = t.remove();
		    if(temp.rightchild==null && temp.leftchild==null)
		    	continue;
		    else if(temp.leftchild==null)
		    	t.add(temp.rightchild);
		    else if(temp.rightchild==null)
		    	t.add(temp.rightchild);
		   
		    else
		    {
		    	t.add(temp.leftchild);
		    	t.add(temp.rightchild);
		    }
		 } 
		 
	 }
	 
	      
	   void addNode(int value)
	    {
	       int i=0;
	        Node newnode = new Node(value,false);
	        Node focusnode = root;
	        if(focusnode==null)
	        {
	           root=newnode;
	          
	         }
	       else
	       {
	              Node parent =root;
	              while(value < parent.value)
	               {
	                   focusnode=parent.leftchild;
	                  if(focusnode==null)
	                     {
	                        i=1;                    
	                        break;}
	                     parent=focusnode;
	                }
	               while(value>parent.value)        
	                 {
	                     focusnode =parent.rightchild;
	                     if(focusnode==null)
	                      {
	                         i=2;
	                        break;}
	                       parent=focusnode;
	                  }
	                 if(i==1)
	                          {
	                           parent.leftchild=newnode;
	                            }
	                   if(i==2)
	                      parent.rightchild=newnode;
	           }
	      }
	}
	public class bintree
	{
	    public static void main(String[] args)
	     {
	              BinaryTree a = new BinaryTree();
	              a.addNode(5);
	              a.addNode(3);
	              a.addNode(6);
	              a.addNode(7);
	              a.addNode(4);
	              a.addNode(2);
	              a.addNode(8);
	              a.t.add(a.root);
	              a.bfs(a.root);
	              //a.dfs(a.root);
	             //a.inorderTraversal(a.root);
	             //a.postOrderTraversal(a.root);
	             //a.preOrderTraversal(a.root);
	       }
	}

