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
import java.util.Locale;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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

        try {

            File file = new File(filepath);
            if (file.exists()) {

                ResponseBuilder response = Response.ok((Object) file);
                response.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                return response.build();
            }
            throw new Exception();
        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    @GET
    @Path("/getaccord/{accnumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToRestAccord getAccord(@PathParam("accnumber") String accnumber) {

        try {

            Accord a = Dao.getDao().getAccordByAccNumber(accnumber);
            ToRestAccord b = null;
            if (a != null) {
                b = ToRestAccord.toRestAcc(a);
            }

            return b;
        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    @GET
    @Path("/getaccord/sessiondate/{sessiondate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getAccordBySessionDate(@PathParam("sessiondate") String sessiondate) {
        try {
             DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            List<Accord> list = Dao.getDao().searchAccordBySessionDate(format.parse(sessiondate));
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));
            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/getaccord/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getAccordByType(@PathParam("type") char type) {
        try {
             DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            List<Accord> list = Dao.getDao().searchAccordByType(type);
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));
            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/getaccord/incordate/{incordate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getAccordByIncorDate(@PathParam("incordate") String incordate) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date=format.parse(incordate);
            List<Accord> list = Dao.getDao().searchAccordByIcorporatedDate(format.parse(incordate));
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));
            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/getaccord/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getAllAccords() {
        try {
            List<Accord> list = Dao.getDao().searchAllAccords();
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));
            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }

        @Path("/getaccord/expiredtoday")
        @Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getExpiredAccordsToday(){
            try{
                Date notify = new Date();
                List<Accord> list= Dao.getDao().searchAccordByExpiredDate(notify, notify );
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                System.out.println(result.toString());
                return result;

    }
    catch (Exception e) {
        throw new NotFoundException();
    }

}

    @GET
    @Path("/getaccord/notify")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getNotifyAccordsToday() {
        try {
            Date notify = new Date();
            List<Accord> list = Dao.getDao().searchAccordByNotifyDate(notify);
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));

            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    @GET
    @Path("/getaccord/notify")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToRestAccord> getNotifyAccordsLess() {
        try {
            Date notify = new Date();
            List<Accord> list = Dao.getDao().searchAccordByNotifyDate(notify);
            List<ToRestAccord> result = new ArrayList();
            for (Accord item : list) {
                result.add(ToRestAccord.toRestAcc(item));
            }
            return result;
        } catch (Exception e) {
            throw new NotFoundException();
        }


    }


    @POST
    @Path("updateSessionDate/{accNumber}/{newSessionDate}")
    public Response updateSessionDate(@PathParam("accNumber") String accNumber,
            @PathParam("newSessionDate") String newSessionDate) {

        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Dao.getDao().updateAccordSessionDate(accNumber, format.parse(newSessionDate));
              ResponseBuilder response = Response.ok("Fecha de Sesion Actualizada");
              return response.build();
        } catch (Exception e) {
            throw new NotFoundException();
        }
}

        @GET
        @Path("/getaccord/expiredmonth")
        @Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getExpiredAccordsToday(@PathParam("initdate") String initdate, @PathParam("finaldate") String finaldate){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordByExpiredDate(format.parse(initdate), format.parse(finaldate));
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                System.out.println(result.toString());
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        
        }
  
        
}
        }


    @POST
    @Path("updateDeadline/{accNumber}/{newDeadline}")
    public Response updateDeadline(@PathParam("accNumber") String accNumber,
            @PathParam("newDeadline") String newDeadline) {

        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Dao.getDao().updateAccordDeadline(accNumber, format.parse(newDeadline));
            ResponseBuilder response = Response.ok("Fecha de vencimiento Actualizada");
              return response.build();

        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    @POST
    @Path("updateType/{accNumber}/{Type}")
    public Response updateType(@PathParam("accNumber") String accNumber,
            @PathParam("Type") String Type) {

        try {
            Dao.getDao().updateAccordType(accNumber, Type);
                 ResponseBuilder response = Response.ok("Tipo Actualizado");
              return response.build();
        } catch (Exception e) {
            throw new NotFoundException();
        }

    }


    @POST
    @Path("updateState/{accNumber}/{state}")
    public Response updateAccordState(@PathParam("accNumber") String accNumber,
            @PathParam("state") int state) {

        try {
            Dao.getDao().updateAccordState(accNumber, state);
             ResponseBuilder response = Response.ok("Estado Actualizado");
              return response.build();

        } catch (Exception e) {
            throw new NotFoundException();
        }

    }

    @POST
    @Path("deletePDF/{accNumber}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deletePDF(@PathParam("accNumber") String accNumber, List<String> url){

        try{
        for(String item : url ){
            File file=new File(item);
            file.delete();
            Dao.getDao().deletePdf(accNumber, item);
        }

         ResponseBuilder response = Response.ok("PDFs Eliminados");
              return response.build();
        }
        catch(Exception e){
            throw new NotFoundException();
        }

    }
    @POST
    @Path("deleteAccord/{accNumber}")
    public Response deleteAccord(@PathParam("accNumber") String accNumber){
        try{

            Dao.getDao().deleteAccord(accNumber);
             ResponseBuilder response = Response.ok("Acuerdo Eliminado");
              return response.build();

        }

        catch(Exception e){

            throw new NotFoundException();
        }
    }
}
