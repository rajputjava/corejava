package Project;

import java.awt.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

public class Digitalwatch implements Runnable  {
	JFrame f;
	Thread t= null;
	int hours=0,minutes=0,seconds=0;
	String timeString="";
	JButton b;
	Digitalwatch() {
		f= new JFrame();
		f.setTitle("Digitalwatch");
		f.getContentPane().setBackground(Color.MAGENTA);
		t=new Thread(this);
		t.start();
		b=new JButton();
			b.setBounds(100,100,100,50);
		f.add(b);
		f.setSize(300,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
	}
	public void run() {
		try {
			while(true) {
				Calendar cal = Calendar.getInstance();
				hours=cal.get(Calendar.HOUR_OF_DAY);
				if(hours>12)hours-=12;
				minutes=cal.get(Calendar.MINUTE);
				seconds=cal.get(Calendar.SECOND);
				
				SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				timeString = format.format(date);
				PrintTime();
				t.sleep(1000);
						
						
			}
		}
		catch(Exception e) {
			
		}
		
	}
	 public void PrintTime() {
		b.setText(timeString);
		
	}
	 public static void main(String[] args) {
		 new Digitalwatch();
		
	}

}
