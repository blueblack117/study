package edu.thread;

import java.util.concurrent.locks.ReentrantLock;

public class MutexSample {
	public static void main(String[] args) throws InterruptedException {
        MutexThreadClass tc1 = new MutexThreadClass("[Thread1] ");
        MutexThreadClass tc2 = new MutexThreadClass("[Thread2] ");
        tc1.start();
        tc2.start();

        MutexThreadClass.lock.lock();
    	try {
    		MutexThreadClass.PrintNums("[Main]");
    	}
    	finally
    	{
    		MutexThreadClass.lock.unlock();
    	}

        tc1.join();
        tc2.join();
    }
}

class MutexThreadClass extends Thread { // 'Thread' Class를 상속받는다

	static ReentrantLock lock = new ReentrantLock();

    String thread_name;
    public MutexThreadClass(String name) {
        this.thread_name = name;
    }

    public void run() {
    	lock.lock();
    	try {
    		PrintNums(thread_name);
    	}
    	finally {
    		lock.unlock();
    	}
    }

    static void PrintNums(String str)
    {
    	int i;

    	System.out.println(str);

    	for (i=1; i<=30; i++)
    	{
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
}