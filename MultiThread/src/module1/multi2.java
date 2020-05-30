package module1;

public class multi2 implements Runnable 
{

	@Override
	public void run()
	{
		for(int i=10;i<=50;i+=10)
			System.out.println(Thread.currentThread().getName()+":"+i);

	}

	public static void main(String[] args) 
	{
		multi2 m1=new multi2();   // object of this class
		Thread t1=new Thread(m1); // object of Thread class
		t1.start();

	}

}
