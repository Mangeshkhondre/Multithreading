package module1;

public class deadlock {

	public static void main(String[] args) 
	{
		final String resource1 = "Mangesh";
		final String resource2 = "Abhishek";
		
		Thread t1=new Thread()
		{
			 public void run() 
			 {
				 synchronized(resource1) 
				 {
					System.out.println(Thread.currentThread().getName()+" : "+resource1);
					try {Thread.sleep(500);}catch(Exception e) {}
					synchronized(resource2)
					{
						System.out.println(Thread.currentThread().getName()+" : "+resource2);
						//This line will not print as resource2 is locked with t2. 
					}
				 }
			 }
		};
		
		Thread t2=new Thread()
		{
			public void run() 
			{
				synchronized(resource2) 
				{
					System.out.println(Thread.currentThread().getName()+" : "+resource2);
					try {Thread.sleep(500);}catch(Exception e) {}
					synchronized(resource1) 
					{ 
						System.out.println(Thread.currentThread().getName()+" : "+resource1);
						//This line will not print as resource1 is locked with t1.
					}
				}
			}
		};
		
		t1.start();
		t2.start();
			
		
	}

}
