import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ModifyNormal extends JFrame{
	private JLabel Enter = new JLabel("Enter the details of the question to be modified.");
	private JTextField Question = new JTextField(20);
	private JTextField Answer = new JTextField(20);
	private JButton submit =  new JButton("Submit");
	private JList<String> displayQ;
	private String display[] = new String[100];
	private int i=0;
	private String displayans[] = new String[100];

	private JLabel Enterc = new JLabel("Enter the details of the question to be modified.");
	private JTextField Questionc = new JTextField(20);
	private JTextField Answerc = new JTextField(20);
	private JButton submitc =  new JButton("Submit");
	private JList<String> displayQc;
	private String displayc[] = new String[100];
	private int ic=0;
	private String displayansc[] = new String[100];
	//private int i=0;
	public ModifyNormal(int type){
		JTabbedPane jtp = new JTabbedPane();
		JPanel pmath =new JPanel();
		JPanel pchem =new JPanel();

		

		try{		
			FileReader fr=new FileReader("QuestionsMath.txt");
			BufferedReader br= new BufferedReader(fr);
			String s= new String(" ");
			while((s=br.readLine())!=null){
				display[i++]=s;		
		    }
			
			displayQ =new JList<String> (display);
			
			br.close();
			fr=new FileReader("AnswersMath.txt");
			br= new BufferedReader(fr);	
			int k=0;		
			while((s=br.readLine())!=null){
				displayans[k++]=s;		
			}			
			br.close();

			submit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getActionCommand().equals("Submit")){
						if(Question.getText().equals("")|| Answer.getText().equals(""))
							JOptionPane.showMessageDialog(null,"Please fill all the fields");
						else{
						int index = displayQ.getSelectedIndex();
						String sq = new String(Question.getText());
						String sa = new String(Answer.getText());
						display[index]= sq;
						try{
							File f = new File("tempmodques.txt");
							File f2 = new File("tempmodans.txt");
							FileWriter fr1 = new FileWriter (f,true);
							BufferedWriter br1 = new BufferedWriter(fr1);
							FileWriter fr2 = new FileWriter (f2);
							BufferedWriter br2 = new BufferedWriter(fr2);
							for(int j=0;j<i;j++){
								if(j==index){									
									br1.write(sq);
									if(type == 2)
									br1.append("     [True/False]");
									br1.newLine();
									br2.write(sa);
									br2.newLine();									
								}
								else{
								br1.write(display[j]);
								br1.newLine();
								br2.write(displayans[j]);
								br2.newLine();
								}
							}

							br1.close();
							br2.close();
							File f3 = new File("QuestionsMath.txt");
							File f4 = new File("AnswersMath.txt");
							f3.delete();
							f4.delete();
							f.renameTo(f3);
							f2.renameTo(f4);

			
							displayQ.setListData(display);
							//add(Enter);
							//add(displayQ);
								

						}
						catch(Exception ex){
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null,"2");
						}
						JOptionPane.showMessageDialog(null,"Question modified successfully");
						Question.setText("");					
						Answer.setText("");
					} 
				}
				}
			});
		}
		
		catch(Exception ex){
			ex.printStackTrace();
							JOptionPane.showMessageDialog(null,"3");
		}

		try{		
			FileReader frc=new FileReader("QuestionsChem.txt");
			BufferedReader brc= new BufferedReader(frc);
			String sc= new String(" ");
			while((sc=brc.readLine())!=null){
				displayc[ic++]=sc;		
		    }
			
			displayQc =new JList<String> (displayc);
			
			brc.close();
			frc=new FileReader("AnswersChem.txt");
			brc= new BufferedReader(frc);	
			int kc=0;		
			while((sc=brc.readLine())!=null){
				displayansc[kc++]=sc;		
			}			
			brc.close();

			submitc.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ec){
					if(ec.getActionCommand().equals("Submit")){
						if(Questionc.getText().equals("")|| Answerc.getText().equals(""))
							JOptionPane.showMessageDialog(null,"Please fill all the fields");
						else{
						int indexc = displayQc.getSelectedIndex();
						String sqc = new String(Questionc.getText());
						String sac = new String(Answerc.getText());
						displayc[indexc]= sqc;
						try{
							File fc = new File("tempmodques.txt");
							File f2c = new File("tempmodans.txt");
							FileWriter fr1c = new FileWriter (fc,true);
							BufferedWriter br1c = new BufferedWriter(fr1c);
							FileWriter fr2c = new FileWriter (f2c);
							BufferedWriter br2c = new BufferedWriter(fr2c);
							for(int jc=0;jc<ic;jc++){
								if(jc==indexc){									
									br1c.write(sqc);
									if(type == 2)
									br1c.append("     [True/False]");
									br1c.newLine();
									br2c.write(sac);
									br2c.newLine();									
								}
								else{
								br1c.write(displayc[jc]);
								br1c.newLine();
								br2c.write(displayansc[jc]);
								br2c.newLine();
								}
							}

							br1c.close();
							br2c.close();
							File f3c = new File("QuestionsChem.txt");
							File f4c = new File("AnswersChem.txt");
							f3c.delete();
							f4c.delete();
							fc.renameTo(f3c);
							f2c.renameTo(f4c);

			
							displayQc.setListData(displayc);
							//add(Enter);
							//add(displayQ);
								

						}
						catch(Exception exc){
							exc.printStackTrace();
							JOptionPane.showMessageDialog(null,"1");
						}
						JOptionPane.showMessageDialog(null,"Question modified successfully");
						Questionc.setText("");					
						Answerc.setText("");
					} 
				}
				}
			});
		}
		
		catch(Exception ex){
			ex.printStackTrace();
							JOptionPane.showMessageDialog(null,"4");
		}

		pmath.add(Enter);
		pmath.add(Question);
		pmath.add(Answer);
		pmath.add(submit);
		pmath.add(displayQ);

		pchem.add(Enterc);
		pchem.add(Questionc);
		pchem.add(Answerc);
		pchem.add(submitc);
		pchem.add(displayQc);

		jtp.add("Math",pmath);
		jtp.add("Chemistry",pchem);
		add(jtp);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(400,400);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				new Frame2();
				//setVisible(false);
				dispose();
			}
		});
	}
}