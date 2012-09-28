<%-- 
    Document   : formDepartamento
    Created on : Oct 4, 2008, 4:39:54 PM
    Author     : mertins
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" >
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Veículos - ERRO</title>
    </head>
    <link rel="stylesheet" href="css/layout.css" type="text/css"/>
    <body>
        <div id="container">
            <div id="header">
                <div class="tituloPri">Locadora de Veículos</div>
            </div>
            <div id="leftBar">
            </div>
            <div id="contentLogin">
                <div id="cxErro">
                    <div id="titCxErro">Desculpe, Ocorreu um Erro! Verifique a descrição.</div>
                    <br>
                    <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
                out.write(String.format("<div id=\"msgCxErro\">%s</div>", mensagem));
                out.write("<br/>");
            }
                    %>
                    <a class="labelsErro" href="index.jsp">Voltar</a>
                    
                </div>
            </div>
        </div>        
    </body>
</html>
