<%-- 
    Document   : login
    Created on : 21/03/2023, 02:31:03 PM
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link href="CSS/cover.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/diseño_1.css" rel="stylesheet" type="text/css"/>
    <link href="CSS/sildebars.css" rel="stylesheet" type="text/css"/>
    
    <script>
        // Desactivar los botones de navegación y la barra de direcciones
        window.addEventListener('DOMContentLoaded', function() {
            history.pushState(null, null, location.href);
            window.onpopstate = function () {
                history.go(1);
            };
        });
    </script>
</head>
    <body id="login">

            <div id="cuadro">
                <form method="post" action="Usuario1">
                    <p id="tituloLogin">Iniciar Sesion</p>
                    <hr>
                    <br/><br/>      
                    <label id="subtitulo1" for="exampleInputEmail1" class="form-label">Ingrese su Usuario:</label>
                    <br/><br/>
                    <input class="entrada" type="text"  id="exampleInputEmail1" aria-describedby="emailHelp" name="usuLogin">
                    <br/><br/>
                    <label id="subtitulo2" for="exampleInputPassword1" class="form-label">Contraseña:</label>
                    <br/><br/>
                    <input class="entrada" type="password" id="exampleInputPassword1" name="usuPassword">
                    <br/><br/>
                    <button class="boton" type="submit" >Ingresar</button>
                    <input type="hidden" name="opcion" value="4" >
                    </form>
                    <br/>
            </div>
            
           
            

                    <%
                    if (request.getAttribute("MensajeError") != null) {%>
                <div class="alert alert-danger" role="alert">
                    ${MensajeError}
                </div>

                <%} else {%>
                <div class="alert alert-light" role="alert">
                    ${MensajeExito}
                </div>

                <%
                    }
                %>
                

                </body>
                </html>