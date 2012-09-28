<%-- 
    Document   : veiculos
    Created on : 23/09/2012, 23:49:51
    Author     : CCE
--%>
<%@page import="bean.Veiculo"%>
<%@page import="bean.Marca"%>
<%@page import="bean.Modelo"%>
<%@page import="java.util.List"%>
<%@page errorPage="formerro.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Veículos - Veículos e Tarifas</title>
        <link rel=stylesheet href=css/stilo.css type=text/css>
    </head>
    <body>
        <div class="divveiculos">
            <form id="formvec" action="controleprinc" method="POST">
                <div class="divveiculostitulo">
                    <p>Veículos e Tarifas</p>
                </div>
                </br></br>
                <table border="0" cellspacing="4" cellpadding="3" width="90%" align="center">
                    <tr>
                        <th><b></b></th><th><b>Marca</b></th><th><b>Modelo</b></th><th><b>Teste</b></th><th><b>Cor do Veiculo</b></th><th><b>Disponibilidade</b></th><th><b>Diárias</b></th></br>
                    </tr>

                    <%
                        List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
                        for (Veiculo vecLista : veiculos) {
                            out.print("<tr>");
                            out.print(String.format("<td><img src=\"%s\" width=\"150\" height=\"100\"></img></td>", vecLista.getFoto()));
                            out.print(String.format("<td align=\"center\">%s</td>", vecLista.getMarca().getMarca()));
                            out.print(String.format("<td align=\"center\">%s</td>", vecLista.getModelo().getModelo()));
                            out.print(String.format("<td align=\"center\">%s</td>", vecLista.getCor()));
                            if (vecLista.getDisponivel()) {
                                out.print(String.format("<td><img src=\"imagens/disponivel.jpg\"></img></td>"));
                            } else {
                                out.print(String.format("<td><img src=\"imagens/disponivel.jpg\"></img></td>"));
                            }
                            out.print(String.format("<td align=\"center\">%s</td>", vecLista.getDiaria()));
                            out.print(String.format("<td><input type=\"submit\" value=\"Alugar\"/>"));
                            out.print(String.format("<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"update\"/></td>"));
                            out.print("</tr>");
                        }
                    %>

                </table>
            </form>
        </div>
    </body>
</html>