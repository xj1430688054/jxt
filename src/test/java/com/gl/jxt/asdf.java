package com.gl.jxt;

import org.junit.Test;

public class asdf {
	private static int aa = 500;

	public asdf() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
	
		la(aa, 0, 0);
	}
	/**
	 * 
	 * @param a 水
	 * @param b 瓶盖
	 * @param c 瓶子
	 * @param d 在此方法中换了多少水
	 */
	public static void la(int a, int b, int c){
		b = a + b;
		c = c + a;
		a = 0;
		if(b < 2 && c < 3){
			System.out.println("你一共喝了" + aa + "水" + "还剩下" + b + "个瓶" + "还剩下" +  c + "盖子");
		}else{
			a = b/2 + c/3;   //这一轮能换多少水
			aa += a;         //总共多少书
			b = b%2;   //
			c = c%3;
			System.out.println("水: " + a + " 瓶:" + b + " 盖:" +c);
			la(a, b, c);
		}
		}
		
		
		
	
	@Test
	public void asd(){
		System.out.println(5/2);
		System.out.println(5%2);
		System.out.println(2+3+6);
	}
	
	
	
}
