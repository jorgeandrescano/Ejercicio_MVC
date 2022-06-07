package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Servicio;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ServiciosController", urlPatterns = {"/ServiciosController"})
public class ServiciosController extends HttpServlet {
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String btnGuardar = request.getParameter("btnGuardar");
        String idServicio = request.getParameter("idServicio");
        HttpSession miSession = request.getSession();
        
        if(btnGuardar != null) {
            String txtNombreServ = request.getParameter("txtNombreServ");
            String txtCategoria = request.getParameter("txtCategoria");
            String txtMedida = request.getParameter("txtMedida");
            String txtCosto= request.getParameter("txtCosto");
            String txtEstado = request.getParameter("txtEstado");
            
        try {
            Servicio objServ = new Servicio();
            objServ.setnombreServ(txtNombreServ);
            objServ.setidCategoria(Integer.parseInt(txtCategoria));
            objServ.setmedida(txtMedida);
            objServ.setcosto(Float.parseFloat(txtCosto));
            objServ.setestado(Integer.parseInt(txtEstado));
            //objServ.setestado(Boolean.valueOf(txtEstado));
            int resultado = objServ.guardarServicios();
            
            if (resultado == 1){
                miSession.setAttribute("Registro", true);
            }else {
                miSession.setAttribute("Registro", false);
                miSession.setAttribute("msj", "No se pudo guardar");
            }
            
        } catch(Exception e){
                miSession.setAttribute("Registro", false);
                miSession.setAttribute("msj", e.getMessage());
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServiciosController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServiciosController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public ResultSet listar() throws SQLException{
        Servicio lServ = new Servicio();
        return lServ.listarServicios();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
