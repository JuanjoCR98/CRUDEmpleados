/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.Utilidades;

/**
 *
 * @author Juanjo Cortés
 */
public class servletEmpleados extends HttpServlet {
    private int id;
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
        PrintWriter out = response.getWriter();
           String op = request.getParameter("op");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletEmpleados</title>");            
            out.println("</head>");
            out.println("<body>");
            if (op.equals("listar")) {
                 List<Empleado> misEmpleados = Utilidades.getEmpleados();
                 request.setAttribute("misEmpleados",misEmpleados);
                 request.getRequestDispatcher("listar.jsp").forward(request, response);
                /*for (Productos p1 : misProductos) {
                    out.println("<p>" + p1.getNombre() + "</p>");
                }*/
            }
            if (op.equals("insert1")) { //cuando le indicamos que vaya a insertar
                request.getRequestDispatcher("insert.jsp").forward(request, response);
            }
             if ( op.equals("insert2")) { //cuando le indicamos que vaya a insertar
                Empleado miEmpleado = new Empleado();
                
                miEmpleado.setNombre(request.getParameter("nombre"));
                miEmpleado.setApellidos(request.getParameter("apellidos"));
                miEmpleado.setEdad(Integer.parseInt(request.getParameter("edad")));
                miEmpleado.setPuesto(request.getParameter("puesto"));
                Utilidades.insertaEmpleado(miEmpleado);
                    out.println("<h1>Empleado insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
            }
              if ( op.equals("borrar")) { //cuando le indicamos que vaya a insertar
                  id = Integer.parseInt(request.getParameter("id"));
                  if(Utilidades.borrarEmpleado(id)>0){
                      request.getRequestDispatcher("index.jsp").forward(request, response);
                  }
            }
            if (op.equals("update1")) {
                id = Integer.parseInt(request.getParameter("id"));
                Empleado miEmpleado = Utilidades.getEmpleado(id);
                request.setAttribute("miEmpleado", miEmpleado);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            }
            if (op.equals("update2")) {
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String puesto = request.getParameter("puesto");
                int edad = Integer.parseInt(request.getParameter("edad"));
                Empleado miEmpleado = new Empleado(id, nombre, apellidos, edad, puesto);
                int filas = Utilidades.actualizaEmpleado(miEmpleado);
                out.println("<h3>Se ha actualizado correctamente</h3>");
                out.println("<h4>" + filas + " filas actualizadas</h4>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
