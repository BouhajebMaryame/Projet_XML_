package com.bo;

public class figure 
{
	private static int id;
	private int code ;
	public figure() {
		super();
		id ++;
		code=id;
		
	}

	public  int getId() {
		return id;
	}

	public int getCode() {
		return code;
	}
	
}
