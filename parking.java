package Project;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class parking implements ActionListener{
	JFrame f;
	String [] Vehicle= {"Car","Bike","Track","Van","Bus"};
	JLabel VehicleLabel= new JLabel("Vehicle Type");
	JLabel AmountLabel= new JLabel("Amount");
	JLabel NoLabel= new JLabel("Vechile NO.");
	JLabel nameLabel= new JLabel("Name");
	JLabel phoneLabel = new JLabel("Phone no.");
	JComboBox vehicleComboBox= new JComboBox(Vehicle);
	JTextField amountTextField= new JTextField();
	JTextField noJTextField = new JTextField();
	JTextField nameTextField=new JTextField();
	JTextField phonTextField= new JTextField();
	JButton res = new JButton("REGISTER");
	JButton resetb=new JButton("RESET");
	 parking() {
		 createWindow();
			setLocationAndSize();
			addComponentsToFrame();
			actionEvent();
	 }
	public void createWindow() {
		f= new JFrame();
		f.setTitle("Parking");
		f.setBounds(40,40,380,600);
		f.getContentPane().setBackground(Color.CYAN);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		
	}
	public void setLocationAndSize() {
		VehicleLabel.setBounds(20,70,80,70);
		AmountLabel.setBounds(20,120,100,70);
		NoLabel.setBounds(20,170,120,70);
		nameLabel.setBounds(20,220,140,70);
		phoneLabel.setBounds(20,270,100,70);
		vehicleComboBox.setBounds(180,93,165,23);
		amountTextField.setBounds(180,143,165,23);
		noJTextField.setBounds(180,193,165,23);
		nameTextField.setBounds(180,243,165,23);
		phonTextField.setBounds(180,293,165,23);
		res.setBounds(60,400,100,35);
		resetb.setBounds(200,400,100,35);
	}
	public void addComponentsToFrame() {
		f.add(VehicleLabel);
		f.add(vehicleComboBox);
		f.add(AmountLabel);
		f.add(amountTextField);
		f.add(NoLabel);
		f.add(noJTextField);
		f.add(nameLabel);
		f.add(nameTextField);
		f.add(phoneLabel);
		f.add(phonTextField);
		f.add(res);
		f.add(resetb);
	}
	public void actionEvent() {
		res.addActionListener(this);
		resetb.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==res) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//Create Connection Object connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakshya","root","root");
				//Prepared Statement
				PreparedStatement ps= connection.prepareStatement("insert into parking values(?,?,?,?,?)");
				ps.setString(1,vehicleComboBox.getSelectedItem().toString());
				ps.setString(2,amountTextField.getText());
				ps.setString(3,noJTextField.getText());
				ps.setString(4,nameTextField.getText());
				ps.setString(5,phonTextField.getText());
				if(true) {
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"parking confirmed");
				}
				else {
					JOptionPane.showMessageDialog(null, "none");
				}}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		if(e.getSource()==resetb) {
    		vehicleComboBox.setSelectedItem(null);
    		amountTextField.setText(null);
    		noJTextField.setText(null);
    		nameTextField.setText(null);
    		phonTextField.setText(null);
    	}
		}
	
		public static void main(String [] args) {
			new parking();
		}}
