package com.bo;

public class rectangle extends figure
{
	private int longeur;
	private int largeur;
	private point p;
	public rectangle() {
		super();
		
	}
	public rectangle(int string, int string2,point p) {
		super();
		this.p=p;
		this.longeur = string;
		this.largeur = string2;
	}
	public int getLongeur() {
		return longeur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public String toString() {
		return "rectangle [longeur=" + longeur + ", largeur=" + largeur + "]";
	}
	public point getP() {
		return p;
	}
	public void setP(point p) {
		this.p = p;
	}
	
	
	
}
