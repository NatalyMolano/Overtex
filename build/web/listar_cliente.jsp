<%-- 
    Document   : listar_cliente
    Created on : 9/06/2023, 04:31:08 PM
    Author     : APRENDIZ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.ClienteVO"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    ClienteDAO clienteDAO = new ClienteDAO();
    ArrayList<ClienteVO> clientes = clienteDAO.listarPorCliente();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Detalles de los clientes</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>
</head>
<body>
    <h1>Detalles de los clientes</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Teléfono</th>
            <th>Documento</th>
            <th>Cantidad de ventas</th>
        </tr>
        <% for (ClienteVO cliente : clientes) { %>
        <tr>
            <td><%= cliente.getCliNombre() %></td>
            <td><%= cliente.getCliTelefono() %></td>
            <td><%= cliente.getDocumento() %></td>
            <td><%= cliente.getConteo()%></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
