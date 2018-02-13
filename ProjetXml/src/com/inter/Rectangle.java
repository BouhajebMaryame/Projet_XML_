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
import com.bo.rectangle;

public class Rectangle extends JDialog {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel largeur,longeur,xl,yl;
	  private JTextField larg,lon,x,y;
	  public rectangle inf;
	  
	 public Rectangle(JFrame parent, String title, boolean modal)
	 	{
		    super(parent, title, modal);
		    this.setSize(300, 200);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    initComponent();
		    this.setVisible(true);
	 	}  
	 private void initComponent(){
		 	JPanel panP3 = new JPanel();
		    JPanel panP1 = new JPanel();
		    JPanel panP2 = new JPanel();
		    JPanel panPx = new JPanel();
		    JPanel panPy = new JPanel();
		   larg = new JTextField();
		    larg.setPreferredSize(new Dimension(200, 25));
		    lon = new JTextField();
		    lon.setPreferredSize(new Dimension(200, 25));
		    x = new JTextField();
		    x.setPreferredSize(new Dimension(100, 25));
		    y = new JTextField();
		    y.setPreferredSize(new Dimension(100, 25));
		    largeur = new JLabel("largeur :");
		    longeur = new JLabel("longeur :");
		    xl = new JLabel("x :");
		    yl = new JLabel("y :");

		    panP1.add(largeur);
		    panP1.add(larg);
		    panP1.setBorder(BorderFactory.createTitledBorder(""));
		    panP2.add(longeur);
		    panP2.add(lon);
		    panP2.setBorder(BorderFactory.createTitledBorder(""));
		    panPx.add(xl);
		    panPx.add(x);
		    panPx.setBorder(BorderFactory.createTitledBorder(""));
		    panPy.add(yl);
		    panPy.add(y);
		    panPy.setBorder(BorderFactory.createTitledBorder(""));

		    JPanel control = new JPanel();
		    JButton okBouton = new JButton("OK");
		    
		    okBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inf = new rectangle(Integer.parseInt(larg.getText()),Integer.parseInt( lon.getText()),new point(Integer.parseInt(x.getText()),Integer.parseInt(y.getText())));
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
		    panP3.add(panP1,BorderLayout.NORTH);
		    panP3.add(panP2,BorderLayout.SOUTH);
		    panP3.add(panPx,BorderLayout.CENTER);
		    panP3.add(panPy,BorderLayout.CENTER);
		    this.getContentPane().add(panP3, BorderLayout.CENTER);
		    this.getContentPane().add(control, BorderLayout.SOUTH);
}
}