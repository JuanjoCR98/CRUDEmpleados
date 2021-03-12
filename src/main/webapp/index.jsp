<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
                    <h4>MENU PRINCIPAL</h4>
                </div>
                <div class="card-body">
                    <a class="btn btn-dark" style="width:90%;margin-bottom:50px;margin-top:20px" href="servletEmpleados?op=listar">LISTAR EMPLEADOS</a><br>
                    <a class="btn btn-dark" style="width:90%" href="servletEmpleados?op=insert1">INSERTAR EMPLEADOS</a><br>
                </div>
            </div>
        </div>
    </body>
</html>
