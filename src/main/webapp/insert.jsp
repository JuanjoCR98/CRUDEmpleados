<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h4>Nuevo empleado</h4>
                </div>
                <div class="card-body">
                    <form action="servletEmpleados" method="get">
                        <p><label>Nombre: <input type="text" name="nombre" required class="form-control"> </label></p>
                        <p><label>Apellidos <input type="text" name="apellidos" required class="form-control"> </label></p>
                        <p><label>Edad: <input type="number" name="edad" required class="form-control"> </label></p>
                        <p><label>Puesto de trabajo: <input type="text" name="puesto" required class="form-control"> </label></p>
                        <input type="text" name="op" required value="insert2"> 
                        <input type="submit" value="INSERTAR" class="btn btn-primary">       
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
