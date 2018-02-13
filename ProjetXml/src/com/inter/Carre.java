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

import com.bo.carre;
import com.bo.cercle;
import com.bo.point;

public class Carre extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel larc,lx,ly;
	  private JTextField arc,x,y;
	  public carre inf;
	  public Carre(JFrame parent, String title, boolean modal)
	 	{
		    super(parent, title, modal);
		    this.setSize(300, 200);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    initComponent();
		    this.setVisible(true);
	 	}
	private void initComponent() {
		JPanel panPr = new JPanel();
	    JPanel panPx = new JPanel();
	    JPanel panP2 = new JPanel();
	    arc = new JTextField();
	    arc.setPreferredSize(new Dimension(200, 25));
	    x = new JTextField();
	    x.setPreferredSize(new Dimension(100, 25));
	    y = new JTextField();
	    y.setPreferredSize(new Dimension(100, 25));
	    larc=new JLabel("Arc :");
	    lx=new JLabel("x :");
	    ly=new JLabel("y :");
	    panPr.setBorder(BorderFactory.createTitledBorder("L'arc "));
		  panPr.add(larc);
		  panPr.add(arc);
		  panPx.setBorder(BorderFactory.createTitledBorder("Centre"));
		  panPx.add(lx);
		  panPx.add(x);
		  panPx.add(ly);
		  panPx.add(y);
		  JPanel control = new JPanel();
		    JButton okBouton = new JButton("OK");
		    
		    okBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inf = new carre(Integer.parseInt(arc.getText()),new point(Integer.parseInt(x.getText()),Integer.parseInt(y.getText())));
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
		    panP2.add(panPr,BorderLayout.NORTH);
		    panP2.add(panPx,BorderLayout.SOUTH);
		    this.getContentPane().add(panP2, BorderLayout.CENTER);
		    this.getContentPane().add(control, BorderLayout.SOUTH);

	    
		
	}
}
