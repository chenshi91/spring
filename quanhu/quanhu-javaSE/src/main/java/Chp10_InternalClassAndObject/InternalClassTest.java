/**Created	by	chenshi  at	2018年1月24日 下午12:11:52*/
package Chp10_InternalClassAndObject;

/**
 * @description:	InternalClassTest.java
 * @packageName:	Chp10_InternalClass
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class InternalClassTest {
	/**内部类*/
	public static void main(String[] args) {
		Teacher teacher = School.getTeacher(8);
		teacher.teach();
		Integer i1 = new	Integer(4);
		Integer i2 = new	Integer(4);
//		i1.intValue()
		
		System.out.println(i1.intValue()==i2.intValue());
	}
}

interface	Teacher{
	void	teach();
}

class	School{
	public	static	Teacher	getTeacher(int i){
		/**局部内部类,强制弱耦合,屏蔽了类的创建只能在外部类里面*/
		class	Huxz	implements	Teacher{
			@Override
			public void teach() {
				System.out.println("Huxz teach java");
			}
		}
		
		if(i%2==0)	return	new	Huxz();
		
		/**特殊的局部内部类--匿名类部类*/
		else	return	new	Teacher() {
			@Override
			public void teach() {
				System.out.println("Liucy teach Mysql");
			}
		};
	}
}
