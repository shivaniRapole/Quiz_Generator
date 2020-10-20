import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame2 extends JFrame{
	
	

	private JButton BIns=new JButton("Insert");
	private JButton BMod=new JButton("Modify");
	private JButton BDel=new JButton("Delete");
	private JButton BGenTest=new JButton("Generate Test");

	private JCheckBox McqIns=new JCheckBox("MCQ Insert");
	private JCheckBox TFIns=new JCheckBox("TF Insert");
	private JCheckBox FBIns=new JCheckBox("FB Insert");
	private JCheckBox McqMod=new JCheckBox("MCQ Modify");
	private JCheckBox TFMod=new JCheckBox("TF Modify");
	private JCheckBox FBMod=new JCheckBox("FB Modify");

	private int InsChecked=-1;
	private int ModChecked=-1;


	public Frame2(){
		super("Selection Frame");

		//Selecting insert checkboxes

		
			McqIns.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(McqIns.isSelected()){
					InsChecked=1;
					try{TFIns.setSelected(false);
						FBIns.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});

		TFIns.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(TFIns.isSelected()){
					InsChecked=2;
					try{McqIns.setSelected(false);
						FBIns.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});
		
		FBIns.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(FBIns.isSelected()){
					InsChecked=3;
					try{TFIns.setSelected(false);
						McqIns.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});	
		// Selecting Mod Checkboxes
		McqMod.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(McqMod.isSelected()){
					ModChecked=1;
					try{TFMod.setSelected(false);
						FBMod.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});

		TFMod.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(TFMod.isSelected()){
					ModChecked=2;
					try{McqMod.setSelected(false);
						FBMod.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});
		
		FBMod.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(FBMod.isSelected()){
					ModChecked=3;
					try{TFMod.setSelected(false);
						McqMod.setSelected(false);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
				}
			}
		});	

	//If insert button slected

	BIns.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "Insert"){
				if(InsChecked== -1){
					JOptionPane.showMessageDialog(null,"select the type!");
				}
				if(InsChecked== 1){
					new InsertMcq();
                	dispose();
				}
				if(InsChecked== 2){
					new InsertNormal(InsChecked);
                	dispose();
				}
				if(InsChecked== 3){
					new InsertNormal(InsChecked);
                	dispose();
				}
			}
		}
	});
//If Mod button slected

	BMod.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand() == "Modify"){
				if(ModChecked== -1){
					JOptionPane.showMessageDialog(null,"select the type!");
				}
				if(ModChecked== 1){
					new ModifyMcq();
					dispose();

				}
				if(ModChecked== 2){
					new ModifyNormal(ModChecked);
					dispose();
				}
				if(ModChecked== 3){
					new ModifyNormal(ModChecked);
					dispose();
				}
			}
		}
	});
//If del button selected

	BDel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="Delete"){
			
			Delete delFrame = new Delete();
			dispose();
		}

	}	
	});

	//if gen test button is selected
	BGenTest.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="Generate Test"){
			setVisible(false);
			GenTest gennn = new GenTest();
		}
	}	
	});


	add(BDel);
	add(BMod);
	add(BIns);
	add(BGenTest);
	
	add(McqMod);
	add(TFMod);
	add(FBMod);
	add(McqIns);
	add(TFIns);
	
	add(FBIns);
	
	setVisible(true);
	setLayout(new FlowLayout());
	setSize(400,400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}

