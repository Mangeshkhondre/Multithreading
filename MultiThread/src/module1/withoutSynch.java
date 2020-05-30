package module1;
class Tablet
{
	void printTable(int n) // use "synchronized" keyword
	{
		for(int i=1;i<=5;i++)
		System.out.println(n*i);
	}
}
class MyThread1 extends Thread
{
	Tablet t;
	MyThread1(Tablet t)
	{
		this.t=t;
	}
	public void run()
	{
		t.printTable(1);
	}
}
class MyThread2 extends Thread
{
	Tablet t;
	MyThread2(Tablet t)
	{
		this.t=t;
	}
	public void run()
	{
		t.printTable(100);
	}
}
public class withoutSynch {

	public static void main(String[] args) 
	{
		Tablet t=new Tablet();
		//Table t2=new Table();
		MyThread1 m1=new MyThread1(t);
		MyThread2 m2=new MyThread2(t);
		m1.start();
		m2.start();

	}

}
