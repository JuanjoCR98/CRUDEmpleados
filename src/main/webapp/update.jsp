<%-- 
    Document   : update
    Created on : 12-mar-2021, 13:10:01
    Author     : Juanjo Cortés
--%>

<%@page import="modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <% Empleado empleado = (Empleado) request.getAttribute("miEmpleado");%>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3>Actualizar empleado</h3>
                </div>
                <div class="card-body">
                    <form action="servletEmpleados" method="get">
                        <p><label>Nombre: <input type="text" name="nombre" value="<%=empleado.getNombre()%>" required class="form-control"> </label></p>
                        <p><label>Apellidos: <input type="text" name="apellidos" value="<%=empleado.getApellidos()%>" required class="form-control"> </label></p>
                        <p><label>Edad: <input type="number" name="edad" value="<%=empleado.getEdad()%>" required class="form-control"> </label></p>
                        <p><label>Puesto: <input type="text" name="puesto" value="<%=empleado.getPuesto()%>" required class="form-control"> </label></p>
                        <input type="text" name="op" required value="update2" hidden> 
                        <input type="submit" value="Actualizar" class="btn btn-primary">       
                    </form> 
                </div>
            </div>
        </div>
       
    </body>
</html>
