package com.demo.SMS;

public class RandomNum {
	private String  random=(int)((Math.random()*9+1)*100000)+"";//����math.random��������0-9�������������100000
	public static String num;
	public String getRandom(){
		return random;
	}
} 

//�����֤��