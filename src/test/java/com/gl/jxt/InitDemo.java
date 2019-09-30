//package com.gl.jxt;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.junit.Test;
//
//
//import net.sf.json.JSONObject;
//
//public class InitDemo {
//	
//	
//	/**
//	 * ����������java����ת��Ϊjson����
//	 *
//	 * @author xujian
//	 * @Date 2019/3/27 09:27
//	 * 
//	 */
//	@Test
//	public void test1(){
//		System.out.println("�˷���Ϊjava����ת��Ϊjson����");
//		Department a = new  Department();
//		JSONObject json = JSONObject.fromObject(a);//��java����ת��Ϊjson����
//		String str = json.toString();//��json����ת��Ϊ�ַ���
//		System.out.println("ת���Ķ���Ϊ�� " + str);
//		System.out.println();
//		System.out.println("--------------------------------------------------------------------------------------------------------");
//		
//	}
//	@Test
//	public void test2(){
//		System.out.println("�˷���Ϊjson����ת��Ϊjava����");
//		Department a = new  Department();
//		JSONObject obj = new JSONObject().fromObject(a);//��json�ַ���ת��Ϊjson����
//		Department b = (Department)JSONObject.toBean(obj,Department.class);//����json����ת��ΪPerson����
//		System.out.println(b.toString());
//		System.out.println();
//		System.out.println("--------------------------------------------------------------------------------------------------------");
//	}
//	
//	@Test
//	public void test3(){
//		System.out.println("�˷���Ϊmap����ת��Ϊjson����");
//		Department aDepartment = new Department();
//		Map<Integer, Department> map = new HashMap<>();
//		for (int i = 0; i < 3; i++) {
//			map.put(i, aDepartment);
//		}
//		JSONObject obj = new JSONObject().fromObject(map);
//		System.out.println(obj.toString());
//		System.out.println();
//		System.out.println("--------------------------------------------------------------------------------------------------------");
//		
//	}
//	
//	
//	@Test
//	public void test4(){
//		System.out.println("�˷���Ϊmap����ת��Ϊjson����");
//		Department aDepartment = new Department();
//		Map<Integer, Department> map = new HashMap<>();
//		for (int i = 0; i < 3; i++) {
//			map.put(i, aDepartment);
//		}
//		JSONObject obj = new JSONObject().fromObject(map);
//		Map<Integer, Department> map2 = new HashMap<>();
//		//��������
//		for (Object key : obj.keySet()) {
//			System.out.println(key.toString());
//			//�˶���Ϊ
//			JSONObject object = (JSONObject)obj.get(key);
//			Department b = (Department)JSONObject.toBean(obj,Department.class);//����json����ת��ΪPerson����
//			System.out.println(b.toString());
//		}
//	
//			
//		
//		
//		}
//	
//	
//	
//	public static void main(String[] args) {
//
//		
//	}
//
//}
