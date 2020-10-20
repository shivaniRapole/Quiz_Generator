import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;


public class Delete extends JFrame{
	private JLabel numbLabel =new JLabel("Select the question you wish to delete.");
	private JButton submit = new JButton("Submit");
	private JList<String> displayQ ;
	private String display[]; //= new String[100];
	private String Q;
	private int i=0;

	private JLabel numbLabelc =new JLabel("Select the question you wish to delete.");
	private JButton submitc = new JButton("Submit");
	private JList<String> displayQc ;
	private String displayc[]; //= new String[100];
	private String Qc;
	private int ic=0;
	

	public Delete(){



		try{
			FileReader fr=new FileReader("QuestionsMath.txt");
			BufferedReader br= new BufferedReader(fr);
			String s;
			while((s=br.readLine())!=null){
				i++;		
			}
			display= new String[i+10];
			i=0;
			br.close();
			fr=new FileReader("QuestionsMath.txt");
			br= new BufferedReader(fr);
			while((s=br.readLine())!=null){
				display[i++]=s;		
			}
			br.close();
		}

		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Error occurred while reading from questions file to display questions.");
			ex.printStackTrace();
		}

		try{
			FileReader frc=new FileReader("QuestionsChem.txt");
			BufferedReader brc= new BufferedReader(frc);
			String sc;
			while((sc=brc.readLine())!=null){
				ic++;		
			}
			displayc= new String[ic+10];
			ic=0;
			brc.close();
			frc=new FileReader("QuestionsChem.txt");
			brc= new BufferedReader(frc);
			while((sc=brc.readLine())!=null){
				displayc[ic++]=sc;		
			}
			brc.close();
		}

		catch(Exception exc){
			JOptionPane.showMessageDialog(null,"Error occurred while reading from questions file to display questions.");
			exc.printStackTrace();
		}

		displayQ =new JList<String>(display);
		displayQ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//add(numbLabel);
		//JScrollPane jsp=new JScrollPane(displayQ);
		//add(jsp);
		//add(displayQ);
		//add(submit);

		displayQc =new JList<String>(displayc);
		displayQc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel pmath=new JPanel();
		pmath.add(numbLabel);
		pmath.add(displayQ);
		pmath.add(submit);

		JPanel pchem=new JPanel();
		pchem.add(numbLabelc);
		pchem.add(displayQc);
		pchem.add(submitc);

		JTabbedPane jtp=new JTabbedPane();
		jtp.addTab("Math", pmath);
		jtp.addTab("Chemistry", pchem);
		
		add(jtp);

		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand() == "Submit"){
					int index = displayQ.getSelectedIndex();
					File tempf=new File("tf.txt");
					File tempfans =new File("tfa.txt");
					try{
						FileWriter fr2 = new FileWriter(tempf); 
						BufferedWriter br2 = new BufferedWriter(fr2);
						FileWriter fr2a =new FileWriter(tempfans);
						BufferedWriter br2a=new BufferedWriter(fr2a);
						FileReader frans=new FileReader("AnswersMath.txt");
						BufferedReader brans= new BufferedReader(frans);
						int j=0;
						while(j<i){
							if(j!=index){
								br2.write(display[j]);
								br2.newLine();
								br2a.write(brans.readLine());
								br2a.newLine();
							}
							
							else
							brans.readLine();	
							j++;
						}
						br2.close();
						br2a.close();
						brans.close();
						
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error occurred while deleting question.");
						ex.printStackTrace();
					}
					File origi=new File("QuestionsMath.txt");
					origi.delete();
					tempf.renameTo(origi);

					File origia=new File("AnswersMath.txt");
					origia.delete();
					tempfans.renameTo(origia);

					int r=index;
					while(r<i-1){
						display[r]=	display[r+1];
						r++;
					}
					i--;
					String display2[] = new String[i+10];
					for(int sop=0;sop<i;sop++){
						display2[sop]=display[sop];
					}
					displayQ.setListData(display2);
				}
			}
		});

		submitc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ec){
				if(ec.getActionCommand() == "Submit"){
					int indexc = displayQc.getSelectedIndex();
					File tempfc=new File("tfc.txt");
					File tempfansc =new File("tfac.txt");
					try{
						FileWriter fr2c = new FileWriter(tempfc); 
						BufferedWriter br2c = new BufferedWriter(fr2c);
						FileWriter fr2ac =new FileWriter(tempfansc);
						BufferedWriter br2ac=new BufferedWriter(fr2ac);
						FileReader fransc=new FileReader("AnswersChem.txt");
						BufferedReader bransc= new BufferedReader(fransc);
						int jc=0;
						while(jc<ic){
							if(jc!=indexc){
								br2c.write(displayc[jc]);
								br2c.newLine();
								br2ac.write(bransc.readLine());
								br2ac.newLine();
							}
							else
							bransc.readLine();
							jc++;	
						}
						br2c.close();
						br2ac.close();
						bransc.close();
						
						
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error occurred while deleting question.");
						ex.printStackTrace();
					}
					File origic=new File("QuestionsChem.txt");
					origic.delete();
					tempfc.renameTo(origic);

					File origiac=new File("AnswersChem.txt");
					origiac.delete();
					tempfansc.renameTo(origiac);

					int rc=indexc;
					while(rc<ic-1){
						displayc[rc]=	displayc[rc+1];
						rc++;
					}
					ic--;
					String display2c[] = new String[ic+10];
					for(int sop=0;sop<ic;sop++){
						display2c[sop]=displayc[sop];
					}
					displayQc.setListData(display2c);
				}
			}
		});
		
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(400,400);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				new Frame2();
				dispose();
			}
		});
	}
}