/**Created	by	chenshi  at	2018年1月19日 下午10:30:31*/
package tips;

/**
 * @description:	Enum.java
 * @packageName:	tips
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Enum {
	/**枚举:这个类是已经构造好了不允许用户构造该类新对象的特殊的类,默认是Enum的子类,Final类
	 * 1,所有构造方法私有
	 * 2,枚举值是枚举类的对象,也是枚举类中的公开静态常量
	 * 3,枚举中可以定义抽象方法,由枚举值分别实现*/
	public static void main(String... args) {
		Season1 spring = Season1.SPRING;
		System.out.println(spring.name);
		
		Season2 summer = Season2.SUMMER;
		System.out.println(summer.ordinal()+" "+summer.name());
		Season2[] values = Season2.values();
		for (Season2 season2 : values) {
			System.out.println(season2.ordinal()+" "+season2.name2+" "+season2.months);
		}
		
		Operation[] values2 = Operation.values();
		for (Operation operation : values2) {
			System.out.println(operation.math(100, 2));
		}
	}
}

class	Season1{
	public static final Season1 SPRING=new Season1("春天");
	public static final Season1 SUMMER=new Season1("夏天");
	public static final Season1 AUTUMN=new Season1("秋天");
	public static final Season1 WINTER=new Season1("冬天");
	
	String name;
	private Season1(String name){
		this.name=name;
	}
	
}

enum	Season2{
	SPRING("春天","3-5"),
	SUMMER("夏天","6-10"),
	AUTUMN("秋天","11-12"),
	WINTER("冬天","1-2");
	public	String name2;
	String	months;
	private Season2(String name,String	months) {
		this.name2 = name;
		this.months=months;
	}
}

enum	Operation{
	ADD {
		@Override
		public int math(int param1, int param2) {
			return param1+param2;
		}
	},
	REDUCE {
		@Override
		public int math(int param1, int param2) {
			return param1-param2;
		}
	},
	RIDE {
		@Override
		public int math(int param1, int param2) {
			return param1*param2;
		}
	},
	DIVIDE {
		@Override
		public int math(int param1, int param2) {
			return param1/param2;
		}
	};
	public abstract	int math(int param1,int param2);
}