import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class GenTest extends JFrame{

	private JButton gtbutton=new JButton("Generate Test");
	private JTextField gtnuminput= new JTextField(5);
	private JLabel gtlabel= new JLabel("Enter number of questions wanted in test");
	private int num;
	private JTextArea disp=new JTextArea();
	private String s=new String();
	private String sa=new String();

	private JCheckBox SubM=new JCheckBox("Math");
	private JCheckBox SubC= new JCheckBox("Chemistry");
	private int sub1checked=-1;



		
	
	public GenTest(){
		super("Generate Test Frame");

		SubM.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(SubM.isSelected()){
					sub1checked=1;
					try{SubC.setSelected(false);}
					catch(Exception ex){
						System.out.println(ex);
					}
				}
			}
		});

		SubC.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(SubC.isSelected()){
					sub1checked=0;
					try{SubM.setSelected(false);}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});

		
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(400,400);

		gtbutton.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Generate Test")) {

					if(!SubM.isSelected() && !SubC.isSelected())
						JOptionPane.showMessageDialog(null,"Select a subject!");
					else{

					try{
						num=Integer.parseInt(gtnuminput.getText());
					}
					catch(Exception ex){

					}

					ArrayList <Integer> arr =new ArrayList <Integer> ();
					ArrayList <String> newqs=new ArrayList <String>();
					ArrayList <String> newans=new ArrayList <String>();
					int size=0;
					try{
						BufferedReader reader;
						if(SubM.isSelected())
					reader = new BufferedReader(new FileReader("QuestionsMath.txt"));
					else 
					reader = new BufferedReader(new FileReader("QuestionsChem.txt"));


					
					while(reader.readLine()!=null){
						
						arr.add(size++);

					}
					reader.close();
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex);
					}
					if(num>size){
						JOptionPane.showMessageDialog(null,"Enter number less than "+size);
					}
					else{
						Collections.shuffle(arr);
					File newlygentest=new File("NewTest.txt");
					File newlygenans= new File("NewTestAns.txt");
					for(int i=0;i<num;i++){
						int wanted=arr.get(i).intValue();
						try{
							BufferedReader reader1;
							BufferedReader reader2;

							if(SubM.isSelected()){
								reader1 = new BufferedReader(new FileReader("QuestionsMath.txt"));
							reader2 = new BufferedReader(new FileReader("AnswersMath.txt"));

							}
							else {
								reader1 = new BufferedReader(new FileReader("QuestionsChem.txt"));
						reader2 = new BufferedReader(new FileReader("AnswersChem.txt"));
							}
						
						for(int j=0;j<wanted;j++){
							reader1.readLine();
							reader2.readLine();
						}
						newqs.add(reader1.readLine());
						newans.add(reader2.readLine());

						reader1.close();
						reader2.close();
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Exception!");
					}

					}

					try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(newlygentest));

					for(int i=0;i<num;i++){
						writer.write(newqs.get(i));
						writer.newLine();
						s=s.concat(newqs.get(i) + "\n");
						sa=sa.concat(newans.get(i) + "\n");

						
					}

					writer.close();
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex);
					}

					disp.setText(s);
					arr.clear();
					newqs.clear();
					newans.clear();
					sa="";
					s="";
					disp.setSize(350, 350);
					disp.setEditable(false);
					}

					}

					

				}
			}
		});

		add(disp);
		add(SubC);
		add(SubM);
		add(gtbutton);
		add(gtnuminput);
		add(gtlabel);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				new Frame2();
				//setVisible(false);
				dispose();
			}
		});


	}
}