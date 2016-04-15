package jppack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class printfile extends JFrame implements ActionListener {


JTextArea ta;
JButton b1,b2;
JPanel p;	
JScrollPane jsp;
	
public printfile(){
		
 p=new JPanel(new GridBagLayout());
 ta=new JTextArea(30,40);
 jsp=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 b1=new JButton("Read");
 b2=new JButton("Print");
// setLayout(new FlowLayout());

 GridBagConstraints c=new GridBagConstraints(); 
 c.insets=new Insets(10,10,10,10);
 c.gridx=0;
 c.gridy=0;

 p.add(b1,c);

 c.gridx=1;
 c.gridy=0;

 p.add(b2,c);

 c.gridx=0;
 c.gridy=-5;

 p.add(jsp,c);
 add(p,BorderLayout.LINE_START);
 

b1.addActionListener(this);
b2.addActionListener(this);

}

	public static void main(String args[])
	{
		printfile pf=new printfile();
		pf.setVisible(true);
		pf.setSize(500,500);
	}
	

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==b1)
		{
			JFileChooser choose=new JFileChooser();
			choose.showOpenDialog(null);
			File f=choose.getSelectedFile();
			String filename=f.getAbsolutePath();
			
			try
			{
				FileReader fr=new FileReader(filename);
				BufferedReader br=new BufferedReader(fr);
				ta.read(br, null);
				br.close();
				ta.requestFocus();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		
		if(a.getSource()==b2)
		{  
			
			try
		   {
			boolean complete=ta.print();
			  if(complete)
			 {
				JOptionPane.showMessageDialog(null,"Done Printing","Information",JOptionPane.INFORMATION_MESSAGE); 
			  }else
			 {
				JOptionPane.showMessageDialog(null,"Printing","Printer error",JOptionPane.ERROR_MESSAGE);
			 }
		
			
           			
		   }catch(Exception e)
		     {
			JOptionPane.showMessageDialog(null,e);
		    }
		}
	}
}
