/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.state;

import data.Dao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logic.State;
import javax.ejb.*;



/**
 *
 * @author jonathan
 */

@Path("/state")
public class GetState {
    
   
    
    
    
        @GET
	@Path("/getall")
        @Produces(MediaType.APPLICATION_JSON)
        public List<State> getAllTypes(){
            
            try{
               return Dao.getDao().getAllState();
                
            }
            
            catch(Exception e){
                throw new NotFoundException();
            }
        }
    
    
}
