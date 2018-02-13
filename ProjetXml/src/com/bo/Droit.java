package com.bo;

public class Droit extends figure
{
	private point p1;
	private point p2;
	public Droit(point p1, point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	public point getP1() {
		return p1;
	}
	public point getP2() {
		return p2;
	}
	public void setP1(point p1) {
		this.p1 = p1;
	}
	public void setP2(point p2) {
		this.p2 = p2;
	}

	
}
