package module1;

public class RuntimeExample 
{
	public static void main(String args[]) throws Exception
	{
		Runtime r = Runtime.getRuntime();
		//r.exec("notepad");
		System.out.println(r.availableProcessors());
		System.out.println(r.totalMemory());
		System.out.println(r.freeMemory());
		for(int i=1;i<=10000;i++)
			new RuntimeExample();
		System.out.println("After creating 10000 instances free time : "+r.freeMemory());
		System.gc();
		System.out.println("After calling gc() : "+r.freeMemory());
		
		r.exit(0);
		System.out.println("This line will not be printed ....");
 	}

}
