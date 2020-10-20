import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login_page extends JFrame{
		JFrame OOP = new JFrame("OOP Mini Project");
		JLabel welcome = new JLabel("Welcome to quiz Generator");
		JLabel user = new JLabel("Username :");
		JLabel pass = new JLabel("Password :");
		JButton submit = new JButton("submit");
		JButton reset = new JButton("reset");
		JTextField username = new JTextField (20);
		JPasswordField password = new JPasswordField (20);

		public login_page(){
	    	submit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String passData = password.getText(); 
		   			String userData = username.getText();
				    if(userData.equals("20150531") && passData.equals("shivani")){
		    			new Frame2();
		    			setVisible(false);
				   	}
	 	    		else if(userData.equals("") || passData.equals("")){
	 	   				JOptionPane.showMessageDialog(null,"Enter the complete data, don't leave any field empty");
	    			}
	    			else if(!userData.equals("20150531") || !passData.equals("shivani")){
	    				JOptionPane.showMessageDialog(null,"Username and Password are not matching");
	    			}
				}
			});

			reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					password.setText("");
					username.setText("");
				}
			}); 
			add(welcome);
			add(user);
			add(username);
			add(pass);
			add(password);
			add(submit);
			add(reset);
			setVisible(true);
			setLayout(new FlowLayout());
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   		}
	public static void main(String args[]){
		new login_page();
	}
}

