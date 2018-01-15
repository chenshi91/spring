/**Created	by	chenshi  at	2018年1月11日 下午5:27:47*/
package thread;

/**
 * @description:	TestThread.java
 * @packageName:	com.quanhu.thread
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ThreadDay1 {
	/**线程的5种状态:1,初始化;2可运行;3,运行状态;4阻塞状态(锁池,等待队列,一般阻塞);5结束.*/
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new ThreadA();
		
		Thread t2 = new	Thread(new	Target(t1));
		
		t1.start();
		t2.start();
		Thread.sleep(100);
		System.out.println("main主线程结束");
	}
}	

class	ThreadA extends	Thread{
	
	public void run() {
        for (int i=0; i<100; i++) {
			System.out.println("aaa"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}
    }
}

class	Target	implements Runnable{
	
	private	Thread t;
	public Target(Thread t){
		this.t=t;
	}
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("bbb"+i);
			try {
				if(i==30) t.join();
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
	
}