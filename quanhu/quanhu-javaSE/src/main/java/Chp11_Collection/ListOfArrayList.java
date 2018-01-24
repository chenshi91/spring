/**Created	by	chenshi  at	2018年1月18日 下午6:03:16*/
package Chp11_Collection;

import org.junit.Test;

/**
 * @description:	ArrayList2.java
 * @packageName:	collection
 * @projectName:	quanhu-javaSE
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class ListOfArrayList {
	/**list接口特点:有顺序,可重复
	 * list接口下面3个子类:ArrayList,Vector,LinkedList
	 * ArrayList底层封装了数组的各种操作方法,特点是查询快,增删慢,所有的方法都不是同步方法*/
	@Test
	public void arrayList(){
		ArrayList1 list = new	ArrayList1();
		list.add("chens");
		list.add("huxz");
		list.add("liucy");
		list.add("zhengm");
		System.out.println("数组长度:"+list.size());
		list.fore();
		list.set(1, "zhang3");
		System.out.println("数组长度:"+list.size());
		list.fore();
		
	}
	
}

class ArrayList1{
	private	Object[] obs=new	Object[3];
	private	int index;
	
	public void	add(Object o){
		if(!(index<obs.length)) expand();
		obs[index]=o;
		index++;
	}
	
	public void set(int suffix,Object obj){
		if(index==obs.length)	expand();
		for (int i=index; i>suffix;i--) {
			obs[i]=obs[i-1];
		}
		obs[suffix]=obj;
	}
	
	/**
	 * @description:expand
	 * @return void
	 */
	private void expand() {
		Object[] obs2=new	Object[obs.length*2];
		System.arraycopy(obs, 0, obs2, 0, obs.length);
		obs=obs2;
	}

	public void delete(Object o){
		for (Object object : obs) {
			if(object==o)	object=null;
		}
	}
	
	public	void	fore(){
		for (int i=0;i<obs.length;i++) {
			System.out.print("obs["+i+"]"+obs[i]+" ");
		}
		System.out.println();
	}
	
	public int	size(){
		return	obs.length;
	}
	
}
