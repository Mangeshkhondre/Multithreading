package module1;

public class multi1 extends Thread
{
	public void run()
	{
		if(Thread.currentThread().isDaemon())
			System.out.println(Thread.currentThread().getName()+" is Daemon.");
		else
			System.out.println(Thread.currentThread().getName()+" is NOT Daemon.");
		for(int i=1;i<=5;i++)
		System.out.println(Thread.currentThread().getName()+":"+i);
		
			
				
	}
	
	public static void main(String[] args) 
	{
		multi1 t1 = new multi1();
		multi1 t2 = new multi1();
		multi2 m3 = new multi2();
		Thread t3=new Thread(m3);
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.setName("hulk");
		
		System.out.println(t1.getName()+":"+t1.getPriority());
		System.out.println(t3.getName()+":"+t3.getPriority());
		
		t3.setPriority(MAX_PRIORITY);
		
		t2.setDaemon(true);
		t1.start();
		try{t1.join();}catch(Exception e){System.out.println(e);}
		t2.start();
		t3.start();
		
		
		
	}

}