/**Created	by	chenshi  at	2018年1月23日 下午10:40:46*/
package Chp09_Interface;

/**
 * @description:	LampTest.java
 * @packageName:	Chp9_Interface
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class LampTest {
	/**接口多态的应用*/
	public static void main(String[] args) {
		Lamb lamb = new	Lamb();
		lamb.setBulb(new YellowBulb());
		lamb.turnOn();
	}
}


interface	Bulb{
	void	shine();
}

class	RedBulb	implements	Bulb{
	@Override
	public void shine() {
		System.out.println("RedBulb shine()");
	}
}

class	GreenBulb	implements	Bulb{
	@Override
	public void shine() {
		System.out.println("GreenBulb shine()");
	}
}

class	YellowBulb	implements	Bulb{
	@Override
	public void shine() {
		System.out.println("YellowBulb shine()");
	}
}

class	Lamb{
	private	Bulb	bulb;

	public void setBulb(Bulb bulb) {
		this.bulb = bulb;
	}
	
	public	void	turnOn(){
		bulb.shine();
	}
}