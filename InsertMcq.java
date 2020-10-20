import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class InsertMcq extends JFrame{
	private JLabel Enter =new JLabel("Enter the question and options");
	private JTextField Question = new JTextField(5);
	private JTextField a = new JTextField(5);
	private JTextField b = new JTextField(5);
	private JTextField c = new JTextField(5);
	private JTextField d = new JTextField(5);
	private JTextField Answer = new JTextField(5);

	private JLabel Enterc =new JLabel("Enter the question and options");
	private JTextField Questionc = new JTextField(5);
	private JTextField ac = new JTextField(5);
	private JTextField bc = new JTextField(5);
	private JTextField cc = new JTextField(5);
	private JTextField dc = new JTextField(5);
	private JTextField Answerc = new JTextField(5);

	private JButton submit = new JButton("Submit");
	private JButton submitc = new JButton("Submit");
	public InsertMcq(){
		JTabbedPane jtp = new JTabbedPane();
    	JPanel pmath=new JPanel();
    	pmath.add(Enter);
	pmath.add(Question);
	pmath.add(a);
	pmath.add(b);
	pmath.add(c);
	pmath.add(d);
	pmath.add(Answer);
	pmath.add(submit);
		JPanel pchem=new JPanel();
    	pchem.add(Enterc);
	pchem.add(Questionc);
	pchem.add(ac);
	pchem.add(bc);
	pchem.add(cc);
	pchem.add(dc);
	pchem.add(Answerc);
	pchem.add(submitc);

	jtp.add("Math",pmath);
	jtp.add("Chemistry",pchem);
	add(jtp);


	submit.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent e){
			if(e.getActionCommand() == "Submit"){
				try{
					if(Question.getText().equals("") || a.getText().equals("") || b.getText().equals("") || c.getText().equals("") || d.getText().equals("") || Answer.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please fill all the fields");
					else{
					FileWriter fr = new FileWriter("QuestionsMath.txt",true);
					BufferedWriter br = new BufferedWriter(fr);
					//br.newLine();
					

					String s= Question.getText();
					br.append(s);
					br.append("Options: ");
					s= a.getText();
					br.append("(a)");
					br.append(s);
					s= b.getText();
					br.append(" (b)");
					br.append(s);
					s= c.getText();
					br.append(" (c)");
					br.append(s);
					s= d.getText();
					br.append(" (d)");
					br.append(s);
					br.close();
					fr = new FileWriter("SolutionsMath.txt",true);
					br = new BufferedWriter(fr);
					br.newLine();
					s= Answer.getText();
					br.append(s);
					br.close();
				
				JOptionPane.showMessageDialog(null,"New question added successfully to question bank.");
				Question.setText("");
				a.setText("");
				b.setText("");
				c.setText("");
				d.setText("");
				Answer.setText("");
			}
			}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex);
				}
			}
		}
	});

	submitc.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent ec){
			if(ec.getActionCommand() == "Submit"){
				try{
					if(Questionc.getText().equals("") || ac.getText().equals("") || bc.getText().equals("") || cc.getText().equals("") || dc.getText().equals("") || Answerc.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please fill all the fields");
					else{
					FileWriter frc = new FileWriter("QuestionsChem.txt",true);
					BufferedWriter brc = new BufferedWriter(frc);
					//brc.newLine();
					
					String sc= Questionc.getText();
					brc.append(sc);
					brc.append("Options: ");
					sc= ac.getText();
					brc.append("(a)");
					brc.append(sc);
					sc= bc.getText();
					brc.append(" (b)");
					brc.append(sc);
					sc= cc.getText();
					brc.append(" (c)");
					brc.append(sc);
					sc= dc.getText();
					brc.append(" (d)");
					brc.append(sc);
					brc.close();
					frc = new FileWriter("SolutionsChem.txt",true);
					brc = new BufferedWriter(frc);
					brc.newLine();
					sc= Answer.getText();
					brc.append(sc);
					brc.close();
			
				JOptionPane.showMessageDialog(null,"New question added successfully to question bank.");
				Questionc.setText("");
				ac.setText("");
				bc.setText("");
				cc.setText("");
				dc.setText("");
				Answerc.setText("");
			}
			}
				catch(Exception exc){
					JOptionPane.showMessageDialog(null,exc);
				}
			}
		
	}
	});
	

	setVisible(true);
	setLayout(new FlowLayout());
	setSize(400,400);
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			new Frame2();
			setVisible(false);
			dispose();
		}
	});

}
}