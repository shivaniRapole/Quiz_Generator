import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class InsertNormal extends JFrame{
	private JLabel Enter =new JLabel("Enter the question and options");
	private JTextField Question = new JTextField(20);
 	private JTextField Answer = new JTextField(20);	
	private JButton submit = new JButton("Submit");

	private JLabel Enterc =new JLabel("Enter the question and options");
	private JTextField Questionc = new JTextField(20);
 	private JTextField Answerc = new JTextField(20);
	private JButton submitc = new JButton("Submit");

    public InsertNormal(int type){
    	JTabbedPane jtp = new JTabbedPane();
    	JPanel pmath=new JPanel();
		pmath.add(Enter);
		pmath.add(Question);
		pmath.add(Answer);
		pmath.add(submit);

		JPanel pchem=new JPanel();
		pchem.add(Enterc);
		pchem.add(Questionc);
		pchem.add(Answerc);
		pchem.add(submitc);
		jtp.addTab("Math", pmath);
		jtp.addTab("Chemistry", pchem);
		add(jtp);


		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand() == "Submit"){
					try{
						if(Question.getText().equals("")||Answer.getText().equals(""))
							JOptionPane.showMessageDialog(null,"Fill all the fields!");
						else{
						
						FileWriter fr = new FileWriter("QuestionsMath.txt",true);
						BufferedWriter br = new BufferedWriter(fr);
						
						
						String s= Question.getText();
						br.append(s);
						if(type == 2)
						br.append("     [True/False]");
						br.close();
						fr = new FileWriter("AnswersMath.txt",true);
						br = new BufferedWriter(fr);
						br.newLine();
						s= Answer.getText();
						br.append(s);
						br.close();
						
						
					
						
					JOptionPane.showMessageDialog(null,"New question added successfully to question bank.");
					Question.setText("");					
					Answer.setText("");	
					}	
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error occured");
						ex.printStackTrace();
				}
			}
			}
		});
	    

	    submitc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ec){
				if(ec.getActionCommand() == "Submit"){
					try{
						if(Questionc.getText().equals("")||Answerc.getText().equals(""))
							JOptionPane.showMessageDialog(null,"Fill all the fields!");
						else{
						
						FileWriter frc = new FileWriter("QuestionsChem.txt",true);
						BufferedWriter brc = new BufferedWriter(frc);
						
						
						String sc= Questionc.getText();
						brc.append(sc);
						if(type==2){
						brc.append("     [True/False]");}
						brc.close();
						frc = new FileWriter("AnswersChem.txt",true);
						brc = new BufferedWriter(frc);
						brc.newLine();
						sc= Answerc.getText();
						brc.append(sc);
						brc.close();
						
						
					
						
					JOptionPane.showMessageDialog(null,"New question added successfully to question bank.");
					Questionc.setText("");					
					Answerc.setText("");	
					}
				}
					catch(Exception exc){
						JOptionPane.showMessageDialog(null,"Error occured");
						exc.printStackTrace();
					}	
				}
			}
		});
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(400,400);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				new Frame2();
				setVisible(false);
				dispose();
			}
		});
	}
}