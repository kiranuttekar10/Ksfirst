package jppack;
import java.awt.Graphics;
import java.awt.print.*;
public class print1 implements Printable{

	public static void main(String[] args) {
		PrinterJob job=PrinterJob.getPrinterJob();
            
		job.setPrintable(new print1());
         
           boolean doprint=job.printDialog();
           
           if(doprint)
           {
        	   try
        	   {
        		   job.print();
        	   }catch(PrinterException e)
        	   {
        		   System.out.println("The job does not complete");
        	   }
           }
	}

	@Override
	public int print(Graphics g, PageFormat arg1, int arg2)
			throws PrinterException {
		// TODO Auto-generated method stub
      
     g.drawString("HelloWorld", 100, 100);
     return PAGE_EXISTS;
     
 
	
		
		
		
	}

}
