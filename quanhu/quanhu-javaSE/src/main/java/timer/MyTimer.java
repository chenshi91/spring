/**Created	by	chenshi  at	2018年3月21日 上午8:50:38*/
package timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @description:	MyTimer.java
 * @packageName:	timer
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class MyTimer {
	public static void main(String[] args) throws ParseException {
		//1,创建一个timer实例
		Timer timer = new Timer();
		//2，创建一个MyTimerTask实例
		MyTimerTask myTimerTask = new MyTimerTask("No.1");
		//3，通过timer定时定平率条用myTimerTask的业务逻辑
		//及第一次执行时在当前时间的2秒之后，之后每隔1秒执行
		//timer.schedule(myTimerTask, 2000L,1000L);
		
		//
		Date doDate = new SimpleDateFormat("yyyy-MM-d H:m:s").parse("2018-3-21 9:32:12");
		timer.schedule(myTimerTask,doDate,8000L );
	}
}
