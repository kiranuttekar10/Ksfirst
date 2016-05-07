package shared;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
//Interface
public interface contactresource {
     @Get
     public contact retrieve();
     
     @Put
     public void store(contact con);
     
     @Delete
     public void remove();
     
}
