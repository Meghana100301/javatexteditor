package application;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class register implements ActionListener
{
	JPasswordField cpasst;
	JTextField passt,t3;
	JLabel error;
	JFrame f1=new JFrame();
	register()
	{
		JPanel p=new JPanel(new GridLayout(4,2));
		JPanel p1=new JPanel();
		JLabel mail=new JLabel("Email id:");
	        t3=new JTextField();
		JLabel pass=new JLabel("Set Password:");
		passt=new JTextField();
		JLabel cpass=new JLabel("Confirm Password:");
		cpasst=new JPasswordField();
		error=new JLabel();
		JButton submit=new JButton("Submit");
		submit.addActionListener(this);
		p.add(mail);p.add(t3);
		p.add(pass);p.add(passt);p.add(cpass);p.add(cpasst);p.add(submit);p.add(error);
		p1.add(p);
		f1.add(p1);
		f1.setSize(500,500);
		f1.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if((passt.getText()).equals(new String(cpasst.getPassword())))
		{
			try
			{
				File myObj = new File("javaproject.txt");
			    if (myObj.createNewFile())
			    {
			        System.out.println("File created: " + myObj.getName());
			    }
			    if(t3.getText().isEmpty())
			    {
			    	error.setText("The field is empty");
			    	return;
			    }
			    FileReader myreader=new FileReader("javaproject.txt");
			    BufferedReader br=new BufferedReader(myreader);
			    String s=br.readLine();
			    while(s!=null)
			    {
			    	String arr[]=s.split(" ");
			    	if(arr[0].equals(t3.getText()))
			    	{
			    		error.setText("emailid already exists");
			    		return;
			    	}
			    	s=br.readLine();
			    }
			    FileWriter mywriter = new FileWriter("javaproject.txt",true);
			    BufferedWriter bw=new BufferedWriter(mywriter);
			    bw.write(t3.getText()+" "+passt.getText());
			    error.setText("user registered");
			    bw.newLine();
			    bw.close();
			}
			catch(Exception e1)
			{ 
	           e1.printStackTrace();
			}
		}
	}
    public static void main(String args[])
    {
	    new register();
    }
}
