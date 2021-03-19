/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Empleado;
import modelo.Utilidades;

/**
 * REST Web Service
 *
 * @author Juanjo Cortés
 */
@Path("empleados")
public class EmpleadosRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmpleadosRest
     */
    public EmpleadosRest() {
    }

    @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
    public Empleado getEmpleadoJson(@PathParam("id") int id  ) {
        Empleado empleado = Utilidades.getEmpleado(id);
        return empleado;
    }
    
    @GET
   @Produces(MediaType.APPLICATION_JSON)
    public List<Empleado> getEmpleados() {
        List<Empleado> listaEmpleados = Utilidades.getEmpleados();
        return listaEmpleados;
    }

     @PUT
     @Consumes(MediaType.APPLICATION_JSON)
    public Empleado updateEmpleado(Empleado emp ) {
        Utilidades.actualizaEmpleado(emp);
        return emp;
    }
    
     @POST
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
      public Empleado insertaEmpleado(Empleado emp ) {
        Utilidades.insertaEmpleado(emp);
        return emp;
      }
      
     @DELETE
     @Path("/{id}")
     public void borraEmpleado(@PathParam("id") int id  ) {
        Utilidades.borrarEmpleado(id);

      }
}
