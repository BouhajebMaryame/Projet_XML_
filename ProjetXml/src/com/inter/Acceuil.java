package com.inter;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.bo.Droit;
import com.bo.GestionTest;
import com.bo.carre;
import com.bo.cercle;
import com.bo.point;
import com.bo.rectangle;
import com.bo.triangle;

public class Acceuil extends JFrame
{
	private static final long serialVersionUID = 1L;
	 JButton n = new JButton("test");
	 GestionTest test = new GestionTest();
	 JPanel p  				 = new JPanel();
	 JPanel pan				 = new JPanel();
	 JMenuItem newMenuformat = new JMenuItem("HTML");
	 JLabel labcer  = new JLabel("Cercle");
	 JLabel labcar  = new JLabel("Carre");
	 JLabel labrec  = new JLabel("Rectangle");
	 JLabel labdr   = new JLabel("Droit");
	 JPanel panap   = new JPanel();
	 JButton btD    = new JButton("ajouter description");
	 JButton btG	= new JButton("Generer html");
	public Acceuil()
		{
		setTitle("l’annotation des dessins géométriques");
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialisation();
		actionlistner();
		setLocationRelativeTo(null);
		setVisible(true);
		}
	
	public void initialisation()
		{
		
		 pan.setBorder(BorderFactory.createTitledBorder("Les figures"));
		 p.setBorder(BorderFactory.createTitledBorder("tesy"));
		 pan.setLayout(new GridLayout(5,1));
		 pan.setSize(100, 400);
		 pan.add(labcer); pan.add(labcar); pan.add(labrec);  pan.add(labdr);
		 panap.add(btD);  panap.add(btG);
		 this.add(pan,BorderLayout.WEST);
		 this.add(p,BorderLayout.CENTER);
		 this.add(panap, BorderLayout.SOUTH);
		}
	
	public void actionlistner() 
		{
		btD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(test.size()>0) {
				JOptionPane op = new JOptionPane();
				String arc   = op.showInputDialog(null,"veuillez saisir l'arc:","carré",JOptionPane.QUESTION_MESSAGE);
				test.ajouterDescription("arc");
				}
			}
		});
		
		btG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(test.size()>0)
				{
					test.gnrXML();
					DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
					try{
						DocumentBuilder builder=factory.newDocumentBuilder();
						File fileXML=new File("figures.xml");
						Document XML= builder.parse(fileXML);
						
						File fileXSLT=new File("fichierXSLT.xsl");
						
						StreamSource styleSource=new StreamSource(fileXSLT);
						Transformer t=TransformerFactory.newInstance().newTransformer(styleSource);
						
						String resultFile= "Transform.html";
						StreamResult HTML=new StreamResult(resultFile);
						
						t.setOutputProperty(OutputKeys.METHOD, "html");
						
						t.setOutputProperty(OutputKeys.INDENT, "yes");
						
						t.transform(new DOMSource(XML), HTML);
			
					}catch (DOMException e) {
				         e.printStackTrace();
				      } catch (ParserConfigurationException e) {
				         e.printStackTrace();
				      } catch (FileNotFoundException e) {
				         e.printStackTrace();
				      } catch (TransformerConfigurationException e) {
				         e.printStackTrace();
				      } catch (TransformerFactoryConfigurationError e) {
				         e.printStackTrace();
				      } catch (TransformerException e) {
				         e.printStackTrace();
				      } catch (SAXException e) {
				         e.printStackTrace();
				      } catch (IOException e) {
				         e.printStackTrace();
				      }
				}
				
			}
		});
		
		labcer.setIcon(new ImageIcon("icon/cercle.png"));
		labcer.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent arg0) {
				  Cercle op = new Cercle(null, "Cercle", true);
	       
	              if(op!=null)
	              {
	              
	              test.ajouterfigures(op.inf);
	              Graphics g=p.getGraphics();
	        	  Paint pa=new Paint();
	              pa.paintCercle(g, op.inf);
	              System.out.println(op.inf.toString());
	              }
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0)  {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0){}
			});

		
		labcar.setIcon(new ImageIcon("icon/carre.png"));
		labcar.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent arg0) {
				  Carre op = new Carre(null, "Rectangle", true);
	              if(op!=null)
	              {
	              
	              test.ajouterfigures(op.inf);
	              Graphics g=p.getGraphics();
	        	  Paint pa=new Paint();
	              pa.paintCarre(g, op.inf);
	              System.out.println(op.inf.toString());
	              }
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0)  {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0){}
			});

		labdr.setIcon(new ImageIcon("icon/droit.png"));
		labdr.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				  DroitDial op = new DroitDial(null, "Droit", true);
				  if(op!=null)
	              {
	              
	              test.ajouterfigures(op.inf);
	              Graphics g=p.getGraphics();
	        	  Paint pa=new Paint();
	              pa.paintDroit(g,op.inf);
	              System.out.println(op.inf.toString());
	              }
	           //   System.out.println(op.inf.getP1().getX()+op.inf.getP1().getY()+op.inf.getP2().getX()+op.inf.getP2().getY()); 	
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0)  {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0){}
			});
		
		labrec.setIcon(new ImageIcon("icon/rect.png"));
		labrec.addMouseListener(new MouseListener() {
		
			public void mouseClicked(MouseEvent arg0) {
				  Rectangle op = new Rectangle(null, "Rectangle", true);
	              System.out.println(op.inf.getLongeur()+op.inf.getLargeur());
	              if(op!=null)
	              {
	              
	              test.ajouterfigures(op.inf);
	              Graphics g=p.getGraphics();
	        	  Paint pa=new Paint();
	              pa.paintRectangle(g,op.inf);
	              System.out.println(op.inf.toString());
	              }
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0)  {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0){}
			});

		
		
		}
	public static void main(String[] args) {
		new Acceuil();
				
	}
}
