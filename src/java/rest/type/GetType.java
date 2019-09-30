/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.type;

import data.Dao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logic.Type;

/**
 *
 * @author jonathan
 */

@Path("/type")
public class GetType {
    
        @GET
	@Path("/getall")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Type> getAllTypes(){
            
            try{
                List<Type> list= new ArrayList();
                
                // list = Dao.getDao().getAllTypes();
                
                return list;
                
            }
            
            catch(Exception e){
                throw new NotFoundException();
            }
        }
    
}
