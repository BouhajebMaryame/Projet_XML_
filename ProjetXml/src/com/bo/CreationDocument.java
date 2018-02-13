package com.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreationDocument
{
public static void main(String[] args){
		
		/* Création de tous les éléments */
		point p = new point(3,5);
		triangle t= new triangle(new point(1,3),new point(1,3),new point(1,3));
		figure tfig[]= new figure[2];
		tfig[0]=new cercle(2, p);
		tfig[1]=new  triangle(new point(1,3),new point(1,3),new point(1,3));
		cercle c= new cercle(2, p);
		Element scene = new Element("scene");
		Element figures = new Element("figures");
		Element cercle = new Element("cercle");
		Element point = new Element("point");
		cercle.setAttribute("rayon",""+c.getRayon());
		cercle.setAttribute("id",""+c.getCode());
		point.setAttribute("x"," "+p.getX());
		point.setAttribute("y"," "+p.getY());
		
		Element triangle = new Element("triangle");
		triangle.setAttribute("id",""+t.getCode());
		triangle.setAttribute("base",""+t.getP1());
		triangle.setAttribute("hauteur",""+t.getP2());

		Element rules = new Element("rules");
		Element rule = new Element("rule");
		Element type = new Element("type");
		Element figure = new Element("figure");
		Element figure1 = new Element("figure");
		Element discription = new Element("discription");
		
		type.setText("chuas");
		discription.setText("test de jaksnb xml");
		figure.setAttribute("id1",""+tfig[0].getCode());
		figure1.setAttribute("id2",""+tfig[1].getCode());
		/* Création de la hiérarchie */
		scene.addContent(figures);
		cercle.addContent(point);
		figures.addContent(cercle);
		figures.addContent(triangle);
		scene.addContent(rules);
		rules.addContent(rule);
		rule.addContent(type);
		rule.addContent(figure);
		rule.addContent(figure1);
		rule.addContent(discription);
		
		/* Enregistrment */
		Document document = new Document(scene);
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, new FileOutputStream("E:\\ytu.xml"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
