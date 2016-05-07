package Client;

import org.restlet.Component;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;



import server.contactserver;
import shared.contact;

public class clientcall {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      Component comp=new Component();
      comp.getServers().add(Protocol.HTTP, 8185);
      comp.getDefaultHost().attach("/trace",contactserver.class);
      comp.start();
     
   // Initialize the resource proxy.
      
      
		ClientResource cr = new ClientResource(
				"http://localhost:8185/trace");
		// Workaround for GAE servers to prevent chunk encoding
		cr.setRequestEntityBuffering(true);
		cr.accept(MediaType.APPLICATION_JSON);

		shared.contactresource resource = cr.wrap(shared.contactresource.class);

		// Get the remote contact
		contact con = resource.retrieve();
		if (con != null) {
			System.out.println("firstname: " + con.getFirstname());
			System.out.println(" lastname: " + con.getLastname());
			System.out.println("      age: " + con.getAge());
			System.out.println("  Address: " + con.getAdd().getLine1()+" ,"+con.getAdd().getLine2()+" ,"+con.getAdd().getZipCode()+" ,"+con.getAdd().getCity()+" ,"+con.getAdd().getCountry());
		}

		// Update the contact
		con.setFirstname("Roy");
		resource.store(con);
		System.out.println("New firstname: "+ con.getFirstname());
	}

	}


