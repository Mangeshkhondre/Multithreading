package wait_notify;

public class UnsychProducerConsumer 
{

	private static int buffer[];
	private static int count;
	
	
	static class ProducerClass
	{
		void produce()
		{
			while(isFull(buffer)) {}
			buffer[count++]=1;
		}
	}
	
	static class ConsumerClass
	{
		void consume()
		{
			while(isEmpty(buffer)) {}
			buffer[--count]=0;
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
				producerObj.produce();
			System.out.println("Done Producing....");
		};
		
		Runnable consumerRunnable = () ->{
			for(int i=0;i<50;i++)
				consumerObj.consume();
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
