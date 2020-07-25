package application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class profile extends JFrame implements ActionListener
{ 
	JTextArea area=new JTextArea();
	JButton b1,b2;
	JPanel p;
	JLabel file=new JLabel("Enter the file name:");
	JTextField tf=new JTextField();
	JPanel p1=new JPanel(new GridLayout(1,2));
	JLabel l1=new JLabel();
	profile()
	{
	  p=new JPanel();
      b1=new JButton("Upload File");
      b2=new JButton("Open File");
      b1.addActionListener(this);
      b2.addActionListener(this);
      b1.setBounds(200,200,100,100);
      setVisible(true);
      setSize(600,600);
      area.setPreferredSize(new Dimension(400,400));
      p.add(area);
      p.add(b1);p.add(b2);
      p1.add(file);p1.add(tf);
      p.add(p1);p.add(l1);
      add(p);
    }
	public void actionPerformed(ActionEvent e)
	{
	 if(e.getSource()==b1)
	 {
	 if(tf.getText().isEmpty())
	 {
		 l1.setText("Enter the file name");
		 return;
	 }
	 String s=tf.getText();
	 s=s+".txt";
	 File f=new File(s);
	  try 
	  {
		if(f.createNewFile())
		 {
			l1.setText("File was created"); 
			FileWriter mywriter1 = new FileWriter(s,true);
		    BufferedWriter bw1=new BufferedWriter(mywriter1);
		    bw1.write(area.getText());
		    bw1.newLine();
		    bw1.close();
			area.setText(null);
		 }
		else
		{
			l1.setText("filename existing");
		}
	  }
	  catch (IOException e1)
	  {
		e1.printStackTrace();
	  }
	 }
	 if(e.getSource()==b2)
	 {
		 if(tf.getText().isEmpty())
		 {
			 l1.setText("Enter the file name");
			 return;
		 }
		 String s=tf.getText();
		 s=s+".txt";
		 try
		 {
		 FileReader myreader1=new FileReader(s);
		 BufferedReader br1=new BufferedReader(myreader1);
		 String str=br1.readLine();
		 while(str!=null)
		 {
			 area.setText(str+"\n");
			 str=br1.readLine();
		 }
		 }
		 catch (IOException e1) {
			// TODO Auto-generated catch block
			 l1.setText("File not found");
			e1.printStackTrace();
		}
	 }
	}
	public static void main(String args[])
	{
		new profile();
	}
}
