/**Created	by	chenshi  at	2018年1月14日 上午11:55:09*/
package Chp13_Thread;

/**
 * @description:	ThreadWaitNotify.java
 * @packageName:	com.quanhu.thread
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ThreadWaitNotifyDay3 {
	
	/**wait(),notify()/notifyAll()只能写在同步代码块里面,代表正在运行的线程进入和离开等待队列状态(阻塞)
	 * 1,wait()表示线程进入等待队列状态并释放线程所有的锁标记和cpu,
	 * 2,notify()/notifyAll()表示释放对象等待队列里面一个/全部线程进入锁池状态,不释放锁标记*/
	public static void main(String[] args) throws InterruptedException {
		Object object = new Object();
		Thread subThread = new SubThread(object);
		subThread.start();
		synchronized(object){
			System.out.println("Main 1");
//			Thread.sleep(1000);
			object.wait();
			System.out.println("Main 2");
		}
	}

}

class	SubThread	extends	Thread{
	private	Object object;
	
	public SubThread(Object object){
		this.object=object;
	}
	
	public 	void run(){
		synchronized (object) {
			System.out.println("sub 1");
			object.notify();
			System.out.println("sub 2");
		}
	}
}

