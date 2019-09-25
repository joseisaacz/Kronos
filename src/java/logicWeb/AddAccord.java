/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicWeb;

import data.Dao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jose4j.json.internal.json_simple.JSONArray;

/**
 *
 * @author jonathan
 */
@WebServlet(name = "AddAccord", urlPatterns = {"/AddAccord"})
public class AddAccord extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String UPLOAD_DIRECTORY = "/home/jonathan/uploads/";
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 10;  // 10MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    
    
//   protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        // checks if the request actually contains upload file
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            // if not, we stop here
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: Form must has enctype=multipart/form-data.");
//            writer.flush();
//            response.sendError(503);
//            return;
//        }
//        try{
//            
//        Accord acc= this.getAccord(request, response);
//        
//        
//        
//        
//        
//        
//        // configures upload settings
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        // sets memory threshold - beyond which files are stored in disk
//        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        // sets temporary location to store files
//        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
// 
//        ServletFileUpload upload = new ServletFileUpload(factory);
//         
//        // sets maximum size of upload file
//        upload.setFileSizeMax(MAX_FILE_SIZE);
//         
//        // sets maximum size of request (include file + form data)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
// 
//        // constructs the directory path to store upload file
//        // this path is relative to application's directory
//        String uploadPath = UPLOAD_DIRECTORY;
//         
//        // creates the directory if it does not exist
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
// 
//   
//            // parses the request's content to extract file data
//            @SuppressWarnings("unchecked")
//            List<FileItem> formItems = upload.parseRequest(request);
// 
//            if (formItems != null && formItems.size() > 0) {
//                // iterates over form's fields
//                for (FileItem item : formItems) {
//                    // processes only fields that are not form fields
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
//                        acc.getURL().add(filePath);
//                        // saves the file on disk
//                    PrintWriter writer = response.getWriter();
//                    writer.println("Datos guardados correctamente");
//                     writer.flush();
//                    }
//                }
//            }
//            
//            if(acc.getType()!= 'A'){
//            String name= request.getParameter("tempName");
//            String email= request.getParameter("tempEmail");
//            if(name==null || email==null)
//                throw new Exception();
//            
//            TempUser temp=Dao.getDao().getTempUserByEmail(email);
//            
//            if(temp==null){
//               temp= new TempUser();
//                temp.setEmail(email);
//                temp.setName(name);
//                
//            }
//            
//            acc.setState(2);
//            Dao.getDao().insertAccord(acc);
//            Dao.getDao().insertTempUser(temp);
//        }
//            
//        }
//         catch (Exception ex) {
//             response.sendError(503);
//             throw new ServletException();
//        }
////        // redirects client to message page
////        getServletContext().getRequestDispatcher("/message.jsp").forward(
////                request, response);
//    }
//
//   private Accord getAccord(HttpServletRequest request, HttpServletResponse response){
//       
//     
//        try {
//              Accord acc= new Accord();
//              acc.setAccNumber(request.getParameter("accNumber"));
//              String sessionDate=request.getParameter("sessionDate");
//              DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//               acc.setSessionDate(format.parse(sessionDate));
//               String deadLine= request.getParameter("deadLine");
//               acc.setDeadline(format.parse(deadLine));
//               String incorDate=request.getParameter("incorDate");
//               acc.setIncorporatedDate(format.parse(incorDate));
//               String observations= request.getParameter("observations");
//               acc.setObservations(observations);
//               acc.setType(request.getParameter("type").charAt(0));
//               acc.setNotified(true ? request.getParameter("notify") != null : false);
//               acc.setPublished(true ? request.getParameter("public") != null : false);
//               acc.URL=new ArrayList();
//               
//               return acc;
//        } 
//        catch (Exception ex) {
//            
//        }
//       
//       return null;
//   }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
