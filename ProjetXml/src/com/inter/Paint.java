package com.inter;
import  java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JPanel;

import com.bo.Droit;
import com.bo.carre;
import com.bo.cercle;
import com.bo.rectangle;
import com.bo.triangle;




public class Paint extends JPanel  
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void paintCercle(Graphics g,cercle A)
		 {  
			Graphics2D g2D = (Graphics2D) g;
			g2D.drawOval(A.getP().getX(), A.getP().getY(), A.getRayon(), A.getRayon());
		  } 
		public void paintRectangle(Graphics g,rectangle rec)
		 {                                     
			 Graphics2D g2D = (Graphics2D) g;
			 g2D.drawRect(rec.getP().getX(), rec.getP().getY(),rec.getLargeur(), rec.getLongeur());
		  } 
		public void paintCarre(Graphics g,carre re)
		 {                                     
			 Graphics2D g2D = (Graphics2D) g;
			 g2D.drawRect(re.getP().getX(), re.getP().getY(),re.getArc(), re.getArc());
		  } 
	
		public void paintDroit(Graphics g,Droit d)
		 {  
			Line2D lin = new Line2D.Float(d.getP1().getX(),d.getP1().getY(), d.getP1().getX(), d.getP2().getY());
			 Graphics2D g2D = (Graphics2D) g;
			 g2D.draw(lin);
		  } 
}
