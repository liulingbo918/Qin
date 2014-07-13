package qin.model.domainClass;

import java.io.Serializable;

public class Address implements Serializable {
	
	private String province;
	private String city;
	
	private static String[] allProvince = {"--", "北京", "上海", "天津", "重庆", "河北", "山西", "内蒙古", 
										"黑龙江", "吉林", "辽宁", "陕西", "甘肃", "青海", "山东", "河南", 
										"江苏", "浙江", "安徽", "江西", "福建", "台湾", "湖北", "湖南", 
										"广东", "广西", "海南", "四川", "云南", "贵州","西藏", "新疆", "宁夏", 
										"香港", "澳门"
										};
	
	public Address() {
		province = "--";
		city = "--";
	}
	
	public Address(String _province, String _city) {
		province = _province;
		city = _city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String _province) {
		province = _province;
	}
	
	
	public String getCity() {
		return province;
	}
	
	public void setCity(String _city) {
		city = _city;
	}

	
	public static String[] getProvinces() {
		
		return allProvince;
	}
	

	public static String[] getCitiesByProvinceName(String provinceName) {
		switch(provinceName) {
	
		case "北京" : 
			return new String[] {"北京"};			
		case "上海" : 
			return new String[] {"上海"};
		case "天津" : 
			return new String[] {"天津"};
		case "重庆" : 
			return new String[] {"重庆"};
		case "香港" : 
			return new String[] {"香港"};
		case "澳门" : 
			return new String[] {"澳门"};
			
		case "广东" : 
			return new String[] {"--","广州","深圳", "珠海", "汕头", "韶关", "佛山", "江门", "湛江", "茂名","肇庆",
					 			 "惠州","梅州","汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮" };
			
		//**********************
		// other provinces
		//**********************
		
		default : 
			return new String[] {"--"};
			
		}
	}
}
