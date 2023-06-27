<%-- 
    Document   : pruebita
    Created on : 4/06/2023, 07:40:46 AM
    Author     : natal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Producto</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <style>
            body {
                background-color: #f2f2f2;
            }

            .form-container {
                background-color: #ffffff;
                padding: 20px;
                margin-top: 50px;
                border: 2px solid #000000;
                border-radius: 10px;
                width: 70%;
                margin: 0 auto;
            }

            .form-group label, .form-group input {
                font-size: 15px;
            }

            .product-heading {
                background-color: #dddddd;
                color: #000000;
                padding: 10px;
                margin-bottom: 20px;
                text-align: left;
                font-weight: bold;
                border-radius: 5px;
                margin-top: -20px;
            }

            .btn-icon {
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .btn-icon i {
                margin-right: 5px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <div class="product-heading">Registro Producto</div>
            <form>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="fecha">Fecha Actual:</label>
                        <input type="text" class="form-control" id="fecha" name="fecha" value="<?php echo date('Y-m-d'); ?>" disabled>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="nombre">Nombre del Producto:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="Producto ejemplo">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" class="form-control" id="cantidad" name="cantidad" value="100">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="precio">Precio:</label>
                        <input type="text" class="form-control" id="precio" name="precio" value="10.99">
                    </div>
                    <div class="form-group col-md-2">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block btn-icon" data-toggle="tooltip" data-placement="top" title="Registrar">
                            <i class="fas fa-plus"></i> Registrar
                        </button>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" id="buscador" name="buscador" placeholder="Buscar...">
                    </div>
                    <div class="form-group col-md-2">
                        <button type="submit" class="btn btn-primary btn-block btn-icon" data-toggle="tooltip" data-placement="top" title="Actualizar">
                            <i class="fas fa-sync-alt"></i> Actualizar
                        </button>
                    </div>
                    <div class="form-group col-md-2">
                        <button type="submit" class="btn btn-primary btn-block btn-icon" data-toggle="tooltip" data-placement="top" title="Borrar">
                            <i class="fas fa-trash"></i> Borrar
                        </button>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Fecha</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Producto ejemplo</td>
                            <td><?php echo date('Y-m-d'); ?></td>
                            <td>100</td>
                            <td>10.99</td>
                        </tr>
                    </tbody><tr>
                            <td>jajajja</td>
                            <td><?php echo date('Y-m-d'); ?></td>
                            <td>100</td>
                            <td>10.99</td>
                        </tr>
                </table>
            </form>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </body>
</html>









