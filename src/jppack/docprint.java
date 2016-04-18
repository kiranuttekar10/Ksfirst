package jppack;


//Print a document to a printer by using a DocPrintJob and an implementation of PrintService 

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;

public class docprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       FileInputStream textstream = null;
       try
       {
    	   textstream=new FileInputStream("C:\\Documents and Settings\\suraj\\Desktop\\file1.txt");
    	   
       }catch(FileNotFoundException e)
       {
    	   System.out.println("File Not Found");
       }
       
       if(textstream==null)
       {
    	   return;
       }
       
       DocFlavor myformat= DocFlavor.INPUT_STREAM.TEXT_PLAIN_US_ASCII;
       //Set the format for printing
       Doc mydoc=new SimpleDoc(textstream,myformat,null);
       //Created a document
       PrintRequestAttributeSet as=new HashPrintRequestAttributeSet();
       as.add(new Copies(5));
       
       as.add(Sides.DUPLEX);
       //attributes are done 
       
       //look up for a printer for the type of format
       PrintService[] service=PrintServiceLookup.lookupPrintServices(myformat, as);
       
       
       //create a printjob for one of  the services
       if(service.length>0)
       {
    	   DocPrintJob job=service[0].createPrintJob();
    	   try
    	   {   
    		 
    		   job.print(mydoc, as);
    	   }catch(Exception e)
    	   {
    		   System.out.println(e);
    	   }
       }
       
       
       
       
	}

}
