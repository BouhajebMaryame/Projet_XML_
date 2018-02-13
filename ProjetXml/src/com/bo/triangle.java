package com.bo;
public class triangle extends figure
{
	private point p1,p2,p3;
	
	public triangle() {
		super();
	}

	public triangle(point p1, point p2, point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public point getP1() {
		return p1;
	}

	public void setP1(point p1) {
		this.p1 = p1;
	}

	public point getP2() {
		return p2;
	}

	public void setP2(point p2) {
		this.p2 = p2;
	}

	public point getP3() {
		return p3;
	}

	public void setP3(point p3) {
		this.p3 = p3;
	}
	
	
}
