package kdog.mail.ru.edu.threads.task1.d;

import kdog.mail.ru.edu.threads.task1.c.BaseThread;

public class ThreadManagerMain {
	
	public static void main(String[] args) throws InterruptedException {

		Thread firstThread = new BaseThread(1000L,"firstThread");
		Thread secondThread = new BaseThread(500L,"secondThread");
		Thread thirdThread = new BaseThread(200L,"thirdThread",true);

		firstThread.run();
		secondThread.run();
		thirdThread.run();


	}
}