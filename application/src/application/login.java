package application;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;
public class login implements ActionListener
{
  JButton r,l;
  JTextField mailid;
  JPasswordField t2;
  JLabel l3;
  JFrame f=new JFrame("login");
  login()
  {
	  JLabel l1=new JLabel("mailid:");
	  mailid=new JTextField();
	  JLabel l2=new JLabel("password:");
	  t2=new JPasswordField();
	  JPanel p=new JPanel(new GridLayout(4,2));
	  JPanel p1=new JPanel();
	  p.add(l1);p.add(mailid);p.add(l2);p.add(t2);
	  r=new JButton("register");
	  l=new JButton("login");
	  l3=new JLabel();
	  r.addActionListener(this);
	  l.addActionListener(this);
	  p.add(r);p.add(l);p.add(l3);
	  p1.add(p);
	  f.add(p1);
	  f.setSize(500,500);
	  f.setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==r)
	  {
		  new register(); 
	  }
	  if(e.getSource()==l)
	  {
		  if(mailid.getText().isEmpty() || t2.getPassword().length==0)
		  {
			  l3.setText("fields are empty");
			  return;
		  }
		  try
		  {
		    FileReader myreader1=new FileReader("javaproject.txt");
		    BufferedReader br1=new BufferedReader(myreader1);
		    String s=br1.readLine();
		    while(s!=null)
		    {
		    	String arr[]=s.split(" ");
		    	if(arr[0].equals(mailid.getText()))
		    	{
		    	  if(arr[1].equals(new String(t2.getPassword())))
		    	  {
		    	  new profile();
		    	  return;
		    	  }
		    	  else
		    	  {
		    		  l3.setText("Password Incorrect");
		    		  return;
		    	  }
		    	}
		    	s=br1.readLine();
		    }
		    l3.setText("User in not registered");
		  }
		  catch(Exception e2)
		  {
			  e2.printStackTrace();
		  }
	  }
  }
  public static void main(String args[])
  {
	  new login();
  }
}
