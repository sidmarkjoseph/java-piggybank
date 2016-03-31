
interface A
{
	 public void display();
	 
}
class B implements A
{
	public void display()
	{
		System.out.println("Displaying B's contents");
	}
}
class C implements A
{
	public void display()
	{
		System.out.println("Displaying C's contents");
	}
}
public class inheritance {
   public static void main(String[] args)
   {
	   A obj = new B();
	   obj.display();
	   obj = new C();
	   obj.display();
   }
}
