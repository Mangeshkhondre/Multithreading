package module1;
class Customer
{
	int amount=1000;
	synchronized void withraw(int amount)
	{
		if(this.amount<amount)
		{
			System.out.println("Less Balance . Waiting for Deposit......");
			try { wait();}catch(Exception e) {};
		}
		this.amount-=amount;
		System.out.println("Amount withrawed.");
	}
	synchronized void deposit(int amount)
	{
		System.out.println("Going to deposit");
		this.amount+=amount;
		System.out.println("Deposit complete");
		notify();
	
	}
	
}

public class ThreadCommunication 
{
	
	public static void main(String[] args)
	{
	
		Customer c=new Customer();
		
		new Thread() 
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				c.withraw(1200);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}.start();
		
		new Thread()
		{
			public void run()
			{
				c.deposit(500);
			}
		}.start();

	}

}
