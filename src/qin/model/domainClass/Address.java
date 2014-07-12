package qin.model.domainClass;

import java.io.Serializable;

public class Address implements Serializable {
	
	private String province;
	private String city;
	
	private static String[] allProvince = {"--", "����", "�Ϻ�", "���", "����", "�ӱ�", "ɽ��", "���ɹ�", 
										"������", "����", "����", "����", "����", "�ຣ", "ɽ��", "����", 
										"����", "�㽭", "����", "����", "����", "̨��", "����", "����", 
										"�㶫", "����", "����", "�Ĵ�", "����", "����","����", "�½�", "����", 
										"���", "����"
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
	
		case "����" : 
			return new String[] {"����"};			
		case "�Ϻ�" : 
			return new String[] {"�Ϻ�"};
		case "���" : 
			return new String[] {"���"};
		case "����" : 
			return new String[] {"����"};
		case "���" : 
			return new String[] {"���"};
		case "����" : 
			return new String[] {"����"};
			
		case "�㶫" : 
			return new String[] {"--","����","����", "�麣", "��ͷ", "�ع�", "��ɽ", "����", "տ��", "ï��","����",
					 			 "����","÷��","��β","��Դ","����","��Զ","��ݸ","��ɽ","����","����","�Ƹ�" };
			
		//**********************
		// other provinces
		//**********************
		
		default : 
			return new String[] {"--"};
			
		}
	}
}
