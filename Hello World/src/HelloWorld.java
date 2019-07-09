
public class HelloWorld {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			  System.out.println("Hello World");
			  int x= Employee.sum(5,0);
			  System.out.println(x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         }

}

class Employee
{
  static int sum(int a, int b) 
  {
	  try {
		  a=5/b;
	  }
	  catch(ArithmeticException ae)
	  {
		  return 0;
		  
	  }
	  finally
	  {
		  return a;
	  }
	  
  }
  
}