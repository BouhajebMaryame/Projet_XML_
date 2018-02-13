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

import com.bo.Droit;
import com.bo.point;


public class DroitDial extends JDialog {
	
	  private JLabel lx1, lx2,ly1,ly2;
	  private JTextField p1x,p1y,p2x,p2y;
	  public  Droit inf;
	  
	 public DroitDial(JFrame parent, String title, boolean modal)
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
		    p1x = new JTextField();
		    p1x.setPreferredSize(new Dimension(100, 25));
		    p1y = new JTextField();
		    p1y.setPreferredSize(new Dimension(100, 25));
		    panP1.setBorder(BorderFactory.createTitledBorder("point 1"));
		    lx1 = new JLabel("x :");
		    ly1 = new JLabel("y :");
		    panP1.add(lx1);
		    panP1.add(p1x);
		    panP1.add(ly1);
		    panP1.add(p1y);
		    
		    p2x = new JTextField();
		    p2x.setPreferredSize(new Dimension(100, 25));
		    p2y = new JTextField();
		    p2y.setPreferredSize(new Dimension(100, 25));
		    panP2.setBorder(BorderFactory.createTitledBorder("point 2"));
		    lx2 = new JLabel("x :");
		    ly2 = new JLabel("y :");
		    panP2.add(lx2);
		    panP2.add(p2x);
		    ly2 = new JLabel("y :");
		    panP2.add(ly2);
		    panP2.add(p2y);
		    JPanel control = new JPanel();
		    JButton okBouton = new JButton("OK");
		    
		    okBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inf = new Droit(new point(Integer.parseInt(p1x.getText()), Integer.parseInt(p1y.getText())),new point(Integer.parseInt(p2x.getText()), Integer.parseInt(p2y.getText())));
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
		    panP3.add(panP1,BorderLayout.CENTER);
		    panP3.add(panP2,BorderLayout.SOUTH);
		    this.getContentPane().add(panP3, BorderLayout.CENTER);
		    this.getContentPane().add(control, BorderLayout.SOUTH);
}
}