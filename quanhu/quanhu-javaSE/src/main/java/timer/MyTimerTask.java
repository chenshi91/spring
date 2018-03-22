/**Created	by	chenshi  at	2018年3月21日 上午8:46:40*/
package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @description:	MyTimer.java
 * @packageName:	timer
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyTimerTask extends TimerTask{

	private String name;
	
	private Integer count=0;
	
	/**
	 * @param name
	 */
	public MyTimerTask(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		if(count<3){
			//打印当前的内容
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d H:m:s");
			Calendar calendar = Calendar.getInstance();
			String format = dateFormat.format(calendar.getTime());
			System.out.println("Current exec name is"+name+",当前时间："+format);
			count++;
		}else{
			//取消当前任务
			cancel();
			System.out.println("Take cancel!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
