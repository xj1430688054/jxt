package com.gl.jxt;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class fastjson {
	@Test
	public void js1(){
		Department a = new  Department();
		String js = JSON.toJSONString(a);
		System.out.println(js);
		
	}

}
