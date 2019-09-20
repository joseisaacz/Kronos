/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.accord;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jonathan
 */
@Path("/accord")
public class GetAccord {
    
    	@GET
	@Path("/getfile/{path}")
	@Produces({MediaType.APPLICATION_OCTET_STREAM})
	public Response getFile(@PathParam("path") String path) {
                
           try{ 
		File file = new File(path);
                if(file.exists()){
		Response.ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename="+file.getName());
                response.header("Content-Type", "application/octet-stream");
                response.header("Content-Length", file.length());
		return response.build();
                }
                throw new Exception();
           }
           catch(Exception e){
               throw new NotFoundException();
           }

	}
    
    
    
}
