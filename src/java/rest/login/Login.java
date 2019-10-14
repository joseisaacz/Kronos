/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.login;

import data.Dao;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import logic.User;
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
    @Path("/log")
    public void login(User id) {
        try {
            String password = DigestUtils.sha256Hex(id.getPassword());
            id.setPassword(password);
           User result = Dao.getDao().getUser(id);
           if(result != null){
               request.getSession().setAttribute("User", result);
           }
           
            
        } catch (Exception ex) {
            String es=ex.getMessage();
            throw new NotAcceptableException();
        }
    }
}
