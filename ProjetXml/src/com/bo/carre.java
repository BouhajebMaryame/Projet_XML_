package com.bo;

public class carre extends figure
{
	private point p;
	private int arc;
	
	public carre( int arc,point p) {
		super();
		this.p=p;
		this.arc = arc;
	}

	public carre() {
		super();
	}

	public int getArc() {
		return arc;
	}

	public void setArc(int arc) {
		this.arc = arc;
	}
	
	public point getP() {
		return p;
	}

	public void setP(point p) {
		this.p = p;
	}

}
