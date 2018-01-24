/**Created	by	chenshi  at	2018年1月22日 上午11:30:36*/
package Chp08_ThreeModifiers;

/**
 * @description:	AbstractTest.java
 * @packageName:	Chp8_ThreeModifiers
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class AbstractTest {
	/**abstract 可以用来修饰类和方法*/
	public static void main(String[] args) {
		double r=3.2;
		Shape	circle=new	Circle(r);
		System.out.println("半径="+r+"的圆的周长是:"+circle.girth());
		System.out.println("半径="+r+"的圆的面积是:"+circle.area());
		
		double	width=3,heigth=5;
		Shape	rect=new	Rect(width, heigth);
		System.out.println("长="+width+",宽="+heigth+"的矩形的周长是:"+rect.girth());
		System.out.println("长="+width+",宽="+heigth+"的矩形的面积是:"+rect.area());
	}
}

abstract class	Shape{
	abstract	public	double	girth();
	abstract	public	double	area();
}

class	Circle	extends	Shape{
	private		Double	r;
	private	final static	double	π=3.1415926;
	
	public Circle(Double r) {
		super();
		this.r = r;
	}

	@Override
	public double girth() {
		return 2*π*r;
	}

	@Override
	public double area() {
		return π*r*r;
	}
	
}

class	Rect	extends	Shape{
	
	private	Double	width;
	private	Double	heigth;
	
	public Rect(Double width, Double heigth) {
		super();
		this.width = width;
		this.heigth = heigth;
	}

	@Override
	public double girth() {
		return 2*(width+heigth);
	}

	@Override
	public double area() {
		return width*heigth;
	}
	
}
