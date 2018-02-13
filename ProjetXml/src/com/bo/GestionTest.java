package com.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class GestionTest {
	 
	private List<figure> listefigures ;
	private String description ;
	
	public GestionTest() {
		super();
		listefigures = new ArrayList<>();
		
	}
	public void ajouterfigures(figure f)
	{
		listefigures.add(f);
	}
	
	public void ajouterDescription(String dis)
	{
		if(dis!=null)
		description=dis;
	}
	public  void gnrXML() {

		
		Element scene = new Element("scene");
		Element figures = new Element("figures");
		scene.addContent(figures);
		Element atr[] = new Element[5];
			for(int i=0;i<listefigures.size();i++)
			{
				if(listefigures.get(i).getClass()== cercle.class)
				{
					cercle c = (cercle) listefigures.get(i);
					atr[i] = new Element("cercle");
					Element point = new Element("point");
					atr[i].setAttribute("id",""+c.getCode());
					atr[i].setAttribute("rayon",""+c.getRayon());
					point.setAttribute("x",""+c.getP().getX());
					point.setAttribute("y",""+c.getP().getY());
					atr[i].addContent(point);
					figures.addContent(atr[i]);
				}
				if(listefigures.get(i).getClass()==triangle.class)
				{
					triangle c = (triangle) listefigures.get(i);
					atr[i] = new Element("triangle");
					Element point  = new Element("point");
					Element point1 = new Element("point");
					Element point2 = new Element("point");
					atr[i].setAttribute("id",""+c.getCode());
					point.setAttribute("x",""+c.getP1().getX());
					point.setAttribute("y",""+c.getP1().getY());
					point1.setAttribute("x",""+c.getP2().getX());
					point1.setAttribute("y",""+c.getP2().getY());
					point2.setAttribute("x",""+c.getP3().getX());
					point2.setAttribute("y",""+c.getP3().getY());
					atr[i].addContent(point);
					atr[i].addContent(point1);
					atr[i].addContent(point2);
					figures.addContent(atr[i]);
				}
				
				if(listefigures.get(i).getClass()==carre.class)
				{
					carre c = (carre) listefigures.get(i);
					Element point = new Element("point");
					atr[i] = new Element("carre");
					atr[i].setAttribute("id",""+c.getCode());
					atr[i].setAttribute("arc",""+c.getArc());
					point.setAttribute("x",""+c.getP().getX());
					point.setAttribute("y",""+c.getP().getY());
					atr[i].addContent(point);
					figures.addContent(atr[i]);
					
				} 
				if(listefigures.get(i).getClass()==rectangle.class)
				{
					rectangle c = (rectangle) listefigures.get(i);
					atr[i] = new Element("rectangle");
					Element point = new Element("point");
					atr[i].setAttribute("id",""+c.getCode());
					atr[i].setAttribute("longeur",""+c.getLongeur());
					atr[i].setAttribute("largeur",""+c.getLargeur());
					point.setAttribute("x",""+c.getP().getX());
					point.setAttribute("y",""+c.getP().getY());
					atr[i].addContent(point);
					figures.addContent(atr[i]);
					
				} 
				if(listefigures.get(i).getClass()==Droit.class)
				{
					Droit c = (Droit)listefigures.get(i);
					atr[i] = new Element("Droit");
					atr[i].setAttribute("id",""+c.getCode());
					Element point = new Element("point");
					point.setAttribute("x",""+c.getP1().getX());
					point.setAttribute("y",""+c.getP1().getY());
					atr[i].addContent(point);
					Element point1 = new Element("point");
					point1.setAttribute("x",""+c.getP2().getX());
					point1.setAttribute("y",""+c.getP2().getY());
					atr[i].addContent(point1);
					figures.addContent(atr[i]);
					
				} 
			}
		    	Element rule = new Element("rule");
				Element eldescription = new Element("description");
				eldescription.setText(description);
				rule.addContent(eldescription);
				
			
			scene.addContent(rule);
			Document document = new Document(scene);
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			try {
				sortie.output(document, new FileOutputStream("figures.xml"));
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	public int size()
	{
		return listefigures.size();
	}
}
