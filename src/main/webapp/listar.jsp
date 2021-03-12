<%@page import="java.util.List"%>
<%@page import="modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
         <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    </head>
    <body>
        <% List<Empleado> misProductos = (List<Empleado>) request.getAttribute("misEmpleados");%>
        <div class="container">
            <div class="card">
                <div class="card-header" style="text-align: center">
                    <h3>Empleados</h3>
                </div>
                <div class="body">
                    <table class="table table-striped"">
                        <tr>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Edad</th>
                            <th>Puesto</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <% for (Empleado e : misProductos) {
                                String cadenaBorrar = "<a onclick='return Confirmation()' href='servletEmpleados?op=borrar&id=" + e.getId() + "'>X</a>";
                                String cadenaActualizar = "<a href='servletEmpleados?op=update1&id=" + e.getId() + "'>Actualizar</a>";
                        %>

                        <tr>
                            <td><%=e.getNombre()%></td>
                            <td><%=e.getApellidos()%></td>
                            <td><%=e.getEdad()%></td>
                            <td><%=e.getPuesto()%></td>
                            <td><%=cadenaBorrar%></td>
                            <td><%=cadenaActualizar%></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                    <div class="card-fotter" style="text-align: center">
                        <p>Volver al menú principal</p>
                    </div>
            </div>
        </div>
        
        <script type="text/javascript">
            function Confirmation(){
                if(confirm("¿Está seguro que quiere borrar este cliente?")){
                    alert("Borrando...");
                    return true;
                }else{
                    alert("Cancelar..");
                    return false;
                }
            }
        </script>
    </body>
</html>
