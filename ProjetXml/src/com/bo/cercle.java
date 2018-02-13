package com.bo;

public class cercle extends figure{
	private int rayon;
	private  point p;
	public cercle(int rayon, point p) {
		super();
		this.p=p;
		this.rayon = rayon;
	}
    
	public cercle()
	{
		super();
	}
	
	public point getP() {
		return p;
	}

	public void setP(point p) {
		this.p = p;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	
}
