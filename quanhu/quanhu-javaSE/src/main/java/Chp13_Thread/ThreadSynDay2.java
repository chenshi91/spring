/**Created	by	chenshi  at	2018年1月11日 下午10:56:22*/
package Chp13_Thread;

/**
 * @description:	ThreadSyn.java
 * @packageName:	com.quanhu.thread
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ThreadSynDay2 {
	/**为了保持多线程对临界资源(同一对象)的原子操作,synchronized(临界资源){}代码块加锁
	 * synchronized修饰的方法叫做同步方法
	 * hashMap里面的方法不是同步方法,所以线程不安全.hashTable里面全部是同步方法,所以线程安全,但牺牲了性能速度*/
	public static void main(String[] args) throws InterruptedException {
		Stack stack = new	Stack();
		Thread thread1 = new Thread1(stack);
		Thread thread2 = new Thread2(stack);
		stack.syso();
		thread1.start();
		thread2.start();
		Thread.sleep(1000);
		stack.syso();
	}
}

class	Stack{
	char[] data={'a','b','x','x','x'};
	int	index=1;
	
	public void add(char x){
		System.out.println("add "+x);
		index++;
		data[index]=x;
	}
	
	public	void	delete(){
		System.out.println("delete "+data[index]);
		data[index]=' ';
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		index--;
	}
	
	public	void	syso(){
		for (char c : data) {
			System.out.print(c+" ");
		}
		System.out.println();
	}
}

class	Thread1 extends	Thread{
	private	Stack	stack;
	
	public	Thread1(Stack stack){
		this.stack=stack;
	}
	public void run(){
		synchronized (stack) {
			stack.add('c');
		}
	}
}

class	Thread2 extends	Thread{
	private	Stack	stack;
	
	public	Thread2(Stack stack){
		this.stack=stack;
	}
	public void run(){
		synchronized (stack) {
			stack.delete();
		}
	}
}
