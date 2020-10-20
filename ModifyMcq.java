import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class ModifyMcq extends JFrame{

	private JLabel Enter = new JLabel("Select the question tobe modified and enter the detailsofthe new question");
	private JTextField QTF= new JTextField("enter new question",20);
	private JTextField ATF= new JTextField("enter new answer", 5);
	private JTextField O1TF= new JTextField(5);
	private JTextField O2TF= new JTextField(5);
	private JTextField O3TF= new JTextField(5);
	private JTextField O4TF= new JTextField(5);
	private String qarr[]= new String[100];
	private String aarr[] =new String[100];
	private JList <String> dispq;
	private JButton subbut= new JButton("Submit");
	private String s= new String(" ");
	private int size=0;

	private JLabel Enterc = new JLabel("Select the question tobe modified and enter the detailsofthe new question");
	private JTextField QTFc= new JTextField("enter new question",20);
	private JTextField ATFc= new JTextField("enter new answer", 5);
	private JTextField O1TFc= new JTextField(5);
	private JTextField O2TFc= new JTextField(5);
	private JTextField O3TFc= new JTextField(5);
	private JTextField O4TFc= new JTextField(5);
	private String qarrc[]= new String[100];
	private String aarrc[] =new String[100];
	private JList <String> dispqc;
	private JButton subbutc= new JButton("Submit");
	private String sc= new String(" ");
	private int sizec=0;

	
	public ModifyMcq(){

		JTabbedPane jtp = new JTabbedPane();
		JPanel pmath=new JPanel();
    	pmath.add(Enter);
    	
	pmath.add(QTF);
	pmath.add(O1TF);
	pmath.add(O2TF);
	pmath.add(O3TF);
	pmath.add(O4TF);
	pmath.add(ATF);
	pmath.add(subbut);
		JPanel pchem=new JPanel();
    	pchem.add(Enterc);
    
	pchem.add(QTFc);
	pchem.add(O1TFc);
	pchem.add(O2TFc);
	pchem.add(O3TFc);
	pchem.add(O4TFc);
	pchem.add(ATFc);
	pchem.add(subbutc);

	jtp.add("Math",pmath);
	jtp.add("Chemistry",pchem);
	add(jtp);

		try{
			BufferedReader br=new BufferedReader(new FileReader("QuestionsMath.txt"));
			while((s=br.readLine())!=null){
				qarr[size++]=s;
				}
			dispq=new JList <String>(qarr);
			//add(dispq);
			br.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		size=0;

		try{
			BufferedReader br=new BufferedReader(new FileReader("AnswersMath.txt"));
			while((s=br.readLine())!=null){
				aarr[size++]=s;
				}
			br.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}


		subbut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Submit")){
					if(QTF.getText().equals("") || ATF.getText().equals("") || O1TF.getText().equals("") || O2TF.getText().equals("") || O3TF.getText().equals("") || O4TF.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please fill all the fields");
					else{
					int index=dispq.getSelectedIndex();
					String nq=new String(QTF.getText());
					String na=new String(ATF.getText());
					nq=nq.concat("OPTIONS: ");
					nq=nq.concat("(a) ");
					nq=nq.concat(O1TF.getText());
					nq=nq.concat("(b) ");
					nq=nq.concat(O2TF.getText());
					nq=nq.concat("(c) ");
					nq=nq.concat(O3TF.getText());
					nq=nq.concat("(d) ");
					nq=nq.concat(O4TF.getText());

					File fqo=new File("QuestionsMath.txt");
					File fao=new File("AnswersMath.txt");

					File fqt=new File("QuestionsMathtemp.txt");
					File fat=new File("AnswersMathtemp.txt");

					try{
						BufferedWriter bwq= new BufferedWriter(new FileWriter(fqt));
						BufferedWriter bwa= new BufferedWriter(new FileWriter(fat));

						for(int i=0;i<size;i++){
							if(index==i){
								bwq.write(nq);
								bwq.newLine();
								bwa.write(na);
								bwa.newLine();
							}
							else{
								bwq.write(qarr[i]);
								bwq.newLine();
								bwa.write(aarr[i]);
								bwa.newLine();
							}
						}

						bwa.close();
						bwq.close();

						fqo.delete();
						fao.delete();

						fqt.renameTo(fqo);
						fat.renameTo(fao);

					}

					catch(Exception ex){
						ex.printStackTrace();
					}

					qarr[index]=nq;
					aarr[index]=na;

					dispq.setListData(qarr);

					
					JOptionPane.showMessageDialog(null,"New question modified successfully to question bank.");
				QTF.setText("");
				ATF.setText("");
				O4TF.setText("");
				O3TF.setText("");
				O2TF.setText("");
				O1TF.setText("");


				}

			}
			}
		});
		try{
			BufferedReader brc=new BufferedReader(new FileReader("QuestionsChem.txt"));
			while((sc=brc.readLine())!=null){
				qarrc[sizec++]=sc;
				}
			dispqc=new JList <String>(qarrc);
			//add(dispqc);
			brc.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		sizec=0;

		try{
			BufferedReader brc=new BufferedReader(new FileReader("AnswersChem.txt"));
			while((sc=brc.readLine())!=null){
				aarrc[sizec++]=sc;
				}
			brc.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}


		subbutc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Submit")){
					if(QTFc.getText().equals("") || ATFc.getText().equals("") || O1TFc.getText().equals("") || O2TFc.getText().equals("") || O3TFc.getText().equals("") || O4TFc.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please fill all the fields");
					else{
					int indexc=dispqc.getSelectedIndex();
					String nqc=new String(QTFc.getText());
					String nac=new String(ATFc.getText());
					nqc=nqc.concat("OPTIONS: ");
					nqc=nqc.concat("(a) ");
					nqc=nqc.concat(O1TFc.getText());
					nqc=nqc.concat("(b) ");
					nqc=nqc.concat(O2TFc.getText());
					nqc=nqc.concat("(c) ");
					nqc=nqc.concat(O3TFc.getText());
					nqc=nqc.concat("(d) ");
					nqc=nqc.concat(O4TFc.getText());

					File fqoc=new File("QuestionsChem.txt");
					File faoc=new File("AnswersChem.txt");

					File fqtc=new File("QuestionsMathtemp.txt");
					File fatc=new File("AnswersMathtemp.txt");

					try{
						BufferedWriter bwqc= new BufferedWriter(new FileWriter(fqtc));
						BufferedWriter bwac= new BufferedWriter(new FileWriter(fatc));

						for(int i=0;i<sizec;i++){
							if(indexc==i){
								bwqc.write(nqc);
								bwqc.newLine();
								bwac.write(nac);
								bwac.newLine();
							}
							else{
								bwqc.write(qarrc[i]);
								bwqc.newLine();
								bwac.write(aarr[i]);
								bwac.newLine();
							}
						}

						bwac.close();
						bwqc.close();

						fqoc.delete();
						faoc.delete();

						fqtc.renameTo(fqoc);
						fatc.renameTo(faoc);

					}

					catch(Exception ex){
						ex.printStackTrace();
					}

					qarrc[indexc]=nqc;
					aarrc[indexc]=nac;

					dispqc.setListData(qarrc);

					
					JOptionPane.showMessageDialog(null,"New question modified successfully to question bank.");
				QTFc.setText("");
				ATFc.setText("");
				O4TFc.setText("");
				O3TFc.setText("");
				O2TFc.setText("");
				O1TFc.setText("");


				}

			}
			}
		});
	pchem.add(dispqc);
	pmath.add(dispq);
			setVisible(true);
			setLayout(new FlowLayout());
			setSize(400,400);
			addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			new Frame2();
			setVisible(false);
			dispose();
		}
	});

	}
	
}
