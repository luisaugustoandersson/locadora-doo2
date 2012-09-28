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
                            out.print(String.format("<td><input class=\"buttonsLogin\" type=\"submit\" value=\"Alugar\"/>"));
                            out.print(String.format("<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"update\"/></td>"));
                            out.print("</tr>");
                        }
                    %>

                    <%--
                                        <tr>
                                            <td><img src="imagens/palio.jpg" width="150" height="100"></img></td><td align="center">Fiat</td><td align="center">Hatch</td><td align="center">Palio</td><td align="center">Vermelho</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$120,00</br><a href="aluguel/formulario.php?valor=120,00">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/Corsa.jpg" width="180" height="120"></img></td><td align="center">Chevrolet</td><td align="center">Hatch</td><td align="center">Corsa Classic</td><td align="center">Branco</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$140,00</br><a href="aluguel/formulario.php?valor=140,00">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/uno.jpg" width="150" height="100"></img></td><td align="center">Fiat</td><td align="center">Hatch</td><td align="center">Uno</td><td align="center">Verde</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$120,00</br><a href="aluguel/formulario.php?valor=120,00">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/clio.jpg" width="150" height="100"></img></td><td align="center">Renault</td><td align="center">Hatch</td><td align="center">Clio</td><td align="center">Azul</td><td align="center"><img src="imagens/indisponivel.jpg"></img></td><td align="center">R$120,00</br><a href="http://servlab.ucpel.tche.br/~aluno-web/interfaceweb2011/Regis/Trabalho-CARROS/aluguel/carroindisponivel.html">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/Gol.jpg" width="190" height="100"></img></td><td align="center">Wolksvagen</td><td align="center">Hatch</td><td align="center">Gol G5</td><td align="center">Branco</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$160,00</br><a href="aluguel/formulario.php?valor=160,00">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/307.jpg" width="190" height="130"></img></td><td align="center">Peugeot</td><td align="center">Hatch</td><td align="center">307</td><td align="center">Preto</td><td align="center"><img src="imagens/indisponivel.jpg"></img></td><td align="center">R$140,00</br><a href="http://servlab.ucpel.tche.br/~aluno-web/interfaceweb2011/Regis/Trabalho-CARROS/aluguel/carroindisponivel.html">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/focus.jpg" width="180" height="100"></img></td><td align="center">Ford</td><td align="center">Sedan</td><td align="center">Focus</td><td align="center">Prata</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$140,00</br><a href="aluguel/formulario.php?valor=140,00">Alugue este Modelo</a></td></br>
                                        </tr>
                                        <tr>
                                            <td><img src="imagens/polo.jpg" width="190" height="100"></img></td><td align="center">Wolksvagen</td><td align="center">Sedan</td><td align="center">Polo</td><td align="center">Preto</td><td align="center"><img src="imagens/disponivel.jpg"></img></td><td align="center">R$160,00</br><a href="aluguel/formulario.php?valor=160,00">Alugue este Modelo</a></td></br>
                                        </tr>
                    --%>
                </table>
            </form>
        </div>
    </body>
</html>
