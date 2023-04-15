package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class RegistrationForm  implements ActionListener {
	JFrame frame;
	String[] gender = {"male","Female"};
	JLabel nameLabel = new JLabel("NAME");
	JLabel genderLabel = new JLabel("GENDER");
	JLabel fatherNameLabel = new JLabel("FATHERS NAME");
	JLabel passwordLabel= new JLabel("PASSWORD");
	JLabel confirmPasswordLabel= new JLabel("CONFIRM PASSWORD");
	JLabel cityLabel = new JLabel("CITY");
	JLabel emaiLabel = new JLabel("EMAIL");
	JTextField nameTextField = new JTextField();
	JComboBox genderComboBox=new JComboBox(gender);
	JTextField fatherTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JTextField cityTextField = new JTextField();
	JTextField emailTextField= new JTextField();
	JButton registerButton = new JButton("REGISTER");
	JButton resetButton= new JButton("RESET");
	
	RegistrationForm()
	{
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	public void createWindow() {
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.setBounds(40,40,380,600);
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	public void setLocationAndSize() {
		nameLabel.setBounds(20,20,40,70);
		genderLabel.setBounds(20,70,80,70);
		fatherNameLabel.setBounds(20,120,100,70); 
		passwordLabel.setBounds(20,170,100,70);
		confirmPasswordLabel.setBounds(20,220,140,70);
		cityLabel.setBounds(20,270,100,70);
		emaiLabel.setBounds(20,320,100,70);
		nameTextField.setBounds(180,43,165,23);
		genderComboBox.setBounds(180,93,165,23);
		fatherTextField.setBounds(180,143,165,23);
		passwordField.setBounds(180,193,165,23);
		confirmPasswordField.setBounds(180,243,165,23);
		cityTextField.setBounds(180,293,165,23);
		emailTextField.setBounds(180,343,165,23);
		registerButton.setBounds(70,400,100,35);
		resetButton.setBounds(220,400,100,35);
			
	}
	public void addComponentsToFrame()
	{
		frame.add(nameLabel );
		frame.add(genderLabel);
		frame.add(fatherNameLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(cityLabel);
		frame.add(emaiLabel);
		frame.add(nameTextField);
		frame.add(genderComboBox);
		frame.add(fatherTextField);
		frame.add(passwordField);
		frame.add(confirmPasswordField);
		frame.add(cityTextField);
		frame.add(emailTextField);
		frame.add(registerButton);
		frame.add(resetButton);
	}
	public void actionEvent() {
		registerButton.addActionListener(this);
		resetButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerButton) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//Create Connection Object connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakshya","root","root");
				//Prepared Statement
				PreparedStatement pstatement= connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
				//Specifying the value of it's parameter
				pstatement.setString(1,nameTextField.getText());
				pstatement.setString(2,genderComboBox.getSelectedItem().toString());
				pstatement.setString(3,fatherTextField.getText());
				pstatement.setString(4,passwordField.getText());
				pstatement.setString(5, confirmPasswordField.getText());
				pstatement.setString(6, cityTextField.getText());
				pstatement.setString(7, emailTextField.getText());
				//checking for the Password match
				if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())){
					//Executing query
					pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null,"data Registered Successflly");
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"password did not match");
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==resetButton) {
			//Clearing fields
			nameTextField.setText("");
			genderComboBox.setSelectedItem("male");
			fatherTextField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
			cityTextField.setText("");
			emailTextField.setText("");
		}
	}
	
}
