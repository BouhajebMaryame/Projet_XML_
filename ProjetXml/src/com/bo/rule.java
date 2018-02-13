package com.bo;

public class rule 
{
	private figure f[];
	private String type ;
	private String description;
	
	public rule() {
		super();
	}
	
	public void  relation (figure [] tabfig, String type,String description)
	{
		this.description=description;
		this.type= type;
		this.f=tabfig;
	}

	public figure[] getF() {
		return f;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public void setF(figure[] f) {
		this.f = f;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
