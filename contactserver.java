package server;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import shared.Address;
import shared.contact;
import shared.contactresource;

public class contactserver extends ServerResource implements contactresource {

	public static void main(String[] args) throws Exception {
	

	//new Server(Protocol.HTTP,8185,contactserver.class).start();
	
	}
   
	private static contact con=new contact("Scott","Tiger",40,new Address("C-9/15","S.No.-13, Sambhaji Nagar","411043","Pune","India"));
	
	@Override
	public contact retrieve() {
		// TODO Auto-generated method stub
		return con;
	}

	
	@Override
	public void store(contact con) {
		// TODO Auto-generated method stub
		contactserver.con=con;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		con=null;
	}

}
