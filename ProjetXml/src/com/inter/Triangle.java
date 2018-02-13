package com.inter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bo.point;
import com.bo.triangle;
public class Triangle extends JDialog {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lx1,ly1,lx2,ly2,lx3,ly3;
	JTextField x1,y1,x2,y2,x3,y3;
	
	  public triangle inf;
	  
	 public Triangle(JFrame parent, String title, boolean modal)
	 	{
		    super(parent, title, modal);
		    this.setSize(300, 250);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    initComponent();
		    this.setVisible(true);
	 	}  
	 private void initComponent(){
		 	JPanel panPx1 = new JPanel();
		    JPanel panPx2 = new JPanel();
		    JPanel panPx3 = new JPanel();
		    JPanel panP2 = new JPanel();
		    x1 = new JTextField();
		    x1.setPreferredSize(new Dimension(100, 25));
		    y1 = new JTextField();
		    y1.setPreferredSize(new Dimension(100, 25));
		    x2 = new JTextField();
		    x2.setPreferredSize(new Dimension(100, 25));
		    y2= new JTextField();
		    y2.setPreferredSize(new Dimension(100, 25));
		    x3 = new JTextField();
		    x3.setPreferredSize(new Dimension(100, 25));
		    y3 = new JTextField();
		    y3.setPreferredSize(new Dimension(100, 25));
		    lx1    = new JLabel("x     :");
		    ly1 = new JLabel("y  :");
		    lx2    = new JLabel("x     :");
		    ly2 = new JLabel("y  :");
		    lx3    = new JLabel("x     :");
		    ly3 = new JLabel("y  :");

		    panPx1.add(lx1);
		    panPx1.add(x1);
		    panPx1.add(ly1);
		    panPx1.add(y1);
		    panPx1.setBorder(BorderFactory.createTitledBorder("point 1"));
		  
		  panPx2.add(lx2);
		    panPx2.add(x2);
		    panPx2.add(ly2);
		    panPx2.add(y2);
		    panPx2.setBorder(BorderFactory.createTitledBorder("point 2"));
		     panPx3.add(lx3);
		    panPx3.add(x3);
		    panPx3.add(ly3);
		    panPx3.add(y3);
		    panPx3.setBorder(BorderFactory.createTitledBorder("point 3"));
		    
		    
		    JPanel control = new JPanel();
		    JButton okBouton = new JButton("OK");
		    
		    okBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inf = new triangle(new point(Integer.parseInt(x1.getText()),Integer.parseInt(y1.getText())),new point(Integer.parseInt(x2.getText()),Integer.parseInt(y2.getText())),new point(Integer.parseInt(x3.getText()),Integer.parseInt(y3.getText())));
					 setVisible(false);
				}
			});
	
		    JButton cancelBouton = new JButton("Annuler");
		    cancelBouton.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        setVisible(false);
		      }      
		    });
		    control.add(okBouton);
		    control.add(cancelBouton);
		   panP2.add(panPx1,BorderLayout.NORTH);
		   panP2.add(panPx2,BorderLayout.CENTER);
		    panP2.add(panPx3,BorderLayout.SOUTH);
		    this.getContentPane().add(panP2, BorderLayout.CENTER);
		    this.getContentPane().add(control, BorderLayout.SOUTH);
}
}