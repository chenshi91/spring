/**Created	by	chenshi  at	2018年1月17日 下午9:34:19*/
package designpattern;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @description:	Factory.java
 * @packageName:	designpattern
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class Factory {

	/**
	 * day16:工厂模式
	 */
	public static void main(String[] args) {
		Animal animal = FactoryDesigns.createAnimal();
		Class<? extends Animal> class1 = animal.getClass();
		System.out.println(class1.getName());
	}

}

abstract	class	Animal{}
class	Dog	extends Animal{}
class	Cat extends	Animal{}

class	FactoryDesigns{
	
	public	static	Animal	createAnimal(){
		try {
			FileReader fileReader = new	FileReader("factoryConfig.txt");
			BufferedReader br=new BufferedReader(fileReader);
			String readLine = br.readLine();
			br.close();
			
			Class<?> forName = Class.forName(readLine);
			Object object = forName.newInstance();
			return (Animal)object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
