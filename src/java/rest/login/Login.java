/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.login;

import data.Dao;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logic.User;
import logic.User_Role;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author jonathan
 */
@Path("/login")
public class Login {
 @Context 
 HttpServletRequest request;
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)      
    @Path("/login")
    public Response login(User id) {
        try {
            String password = DigestUtils.sha256Hex(id.getPassword());
            id.setPassword(password);
           User_Role result = Dao.getDao().getUserRole(id);
           if(result != null){
               request.getSession().setAttribute("UserRole", result);
               Response.ResponseBuilder response = Response.ok((Object) result);
                return response.build();
           }
           else
               throw new Exception();


            
        } catch (Exception ex) {
            String ss=ex.getMessage();
            throw new NotAcceptableException();
        }
    }
    
    @GET
    @Path("getRole")
    @Produces({MediaType.APPLICATION_JSON})
    public User_Role getRole(){
        
        try{
            
            //String role=Dao.getDao().getRole;
            User_Role result= (User_Role)request.getSession().getAttribute("UserRole");
            
            if(result==null){
                result= new User_Role();
                result.setRole("undefined");
                result.setUser(null);
                return result;
            }
            return result;
            
        }
        
        catch(Exception e){
            throw new NotFoundException();
        }
    }
}
