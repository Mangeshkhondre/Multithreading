package module1;

class tableclass
{
	synchronized void print(int n)
	{
		for(int i=1;i<=5;i++)
			System.out.println(i*n);
	}
}


public class withSynch 
{
	public static void main(String srg[])
	{
		final tableclass obj = new tableclass();
		
		Thread t1=new Thread() {
			public void run() {
				obj.print(1);
			}
		};
		
		Thread t2=new Thread() {
			public void run() {
				obj.print(100);
			}
		};
		
		t1.start();
		t2.start();
		
	}

}
