/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.accord;

import data.Dao;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response.ResponseBuilder;
import logic.Accord;

/**
 *
 * @author jonathan
 */
@Path("/accord")
public class GetAccord {
    
    	@GET
	@Path("/getfile")
        @Produces("application/pdf")  
	public Response getFile(@QueryParam("filepath") String filepath) {
                
           try{ 
           
		File file = new File(filepath);
                if(file.exists()){
		
		        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition","attachment; filename=\""+file.getName()+"\"");  
		return response.build();
                }
                throw new Exception();
           }
           catch(Exception e){
               throw new NotFoundException();
           }

	}
    
    	@GET
	@Path("/getaccord/{accnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToRestAccord getAccord(@PathParam("accnumber") String accnumber ) {
               
           try{ 
              
		Accord a= Dao.getDao().getAccordByAccNumber(accnumber);
               ToRestAccord b= null;
               if (a != null)
                   b= ToRestAccord.toRestAcc(a);
               
               return b;
           }
           catch(Exception e){
               throw new NotFoundException();
           }

	}
        
        @GET
	@Path("/getaccord/sessiondate/{sessiondate}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordBySessionDate(@PathParam("sessiondate") String sessiondate){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordBySessionDate(format.parse(sessiondate));
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
        
        @GET
	@Path("/getaccord/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordByType(@PathParam("type") char type){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordByType(type);
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
          @GET
	@Path("/getaccord/incordate/{incordate}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordByIncorDate(@PathParam("incordate") String incordate){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordByIcorporatedDate(format.parse(incordate));
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
       
        
        @GET
	@Path("/getaccord/all")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAllAccords(){
            try{     
                List<Accord> list= Dao.getDao().searchAllAccords();
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
        
          
        @GET 
        @Path("/getaccord/notify")
        @Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getExpiredAccordsToday(){
            try{
                Date notify = new Date();
                Date notify2 = new Date();
                List<Accord> list= Dao.getDao().searchAccordByExpiredDate(notify, notify2 );
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        
        }
        
           @GET 
        @Path("/getaccord/notify")
        @Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getExpiredAccordsMonth(){
            try{
                Date notify = new Date();
                Date notify2 = new Date();
                //(notify <=1)? notify2.setMonth(12): notify2.setMonth(notify.getMonth()- 1);
                List<Accord> list= Dao.getDao().searchAccordByExpiredDate(notify,notify2 );
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
        
    
}
