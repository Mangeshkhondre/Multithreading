package wait_notify;

public class SynchProducerConsumer 
{
	
	 static SynchProducerConsumer lock = new SynchProducerConsumer();
	
	private static int buffer[];
	private static int count;
	
	
	static class ProducerClass
	{
		void produce() throws InterruptedException
		{
			synchronized(lock) 
			{
				if(isFull(buffer)) 
				{
					lock.wait();
				}
				buffer[count++]=1;
				lock.notify();

			}
		}
	}
	
	static class ConsumerClass
	{
		void consume() throws InterruptedException
		{
			synchronized(lock)
			{
				if(isEmpty(buffer))
				{
					lock.wait();
				}
				buffer[--count]=0;
				lock.notify();
			}
		}
	}
	
		
	public static boolean isFull(int[] buffer) 
	{
		return count == buffer.length;
	}

	public static boolean isEmpty(int[] buffer) 
	{
		return count == 0;
	}
	
	
	// main method
	public static void main(String[] args) throws InterruptedException 
	{
		buffer = new int[10];
		count = 0;
		
		ProducerClass producerObj = new ProducerClass();
		ConsumerClass consumerObj = new ConsumerClass();
		
		Runnable producerRunnable = () ->{
			for(int i=0;i<50;i++)
			{
				try {
					producerObj.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Done Producing....");
		};
		
		Runnable consumerRunnable = () ->{
			for(int i=0;i<50;i++)
			{
				try {
					consumerObj.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Done Consuming....");
		};
		
		
		Thread producerThread = new Thread(producerRunnable);
		Thread consumerThread = new Thread(consumerRunnable);
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();
		
		System.out.println("data in buffer = "+count); // Ideally, should be zero.

	}

}
