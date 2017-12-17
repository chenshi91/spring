/**Created	by	chenshi  at	2017年12月17日 下午12:55:14*/
package enums;

/**
 * @description:	CommonEnum.java
 * @packageName:	enums
 * @projectName:	quanhu-web
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public enum CommonEnum {
	
//	private static final byte SHELVE_FLAG_ON=0;
	UN_KNOW("未知",(byte)-1),
	SHELVE_FLAG_ON("上线",(byte)0),
	SHELVE_FLAG_OFF("下线",(byte)1);
	
	String key;
	Byte value;

	/**
	 * @param key
	 * @param value
	 */
	private CommonEnum(String key, Byte value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @description:getCommonEnumByValue(根据value匹配CommonEnum)
	 * @param value
	 * @return
	 * @return CommonEnum
	 */
	public CommonEnum getCommonEnumByValue(Byte value){
		for (CommonEnum commonEnum : CommonEnum.values()) {
			if(commonEnum.getValue().equals(value)){
				return	commonEnum;
			}
		}
		return	CommonEnum.UN_KNOW;
	}


	public String getKey() {
		return key;
	}




	public void setKey(String key) {
		this.key = key;
	}




	public Byte getValue() {
		return value;
	}




	public void setValue(Byte value) {
		this.value = value;
	}




	public static void main(String[] args) {
		CommonEnum shelveFlagOn = CommonEnum.SHELVE_FLAG_ON;
		System.out.println(shelveFlagOn.getKey()+","+shelveFlagOn.getValue());
	}
	
	

}
