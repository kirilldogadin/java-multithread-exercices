package kdog.mail.ru.edu.threads.task1;

public class AdditionalThread extends Thread
{
	@Override
	public void run()	//Этот метод будет выполнен в побочном потоке
	{
		System.out.println("Побочный поток");
		//setName("Побочный поток");
	}


}