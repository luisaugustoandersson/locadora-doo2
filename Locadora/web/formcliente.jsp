<%-- 
    Document   : cadastro
    Created on : 18/09/2012, 15:01:35
    Author     : CCE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Veículos - Cadastro de Clientes</title>
        <link rel=stylesheet href=css/stilo.css type=text/css>
    </head>
    <body>
        <div class="divcadastro">
            <form id="formcli" action="controleprinc" method="POST">
                <div class="divcadastrotitulo">
                    <p>Cadastro de Clientes</p>    
                </div>
                <table>
                    <tr>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nome:&nbsp;&nbsp;&nbsp;</td><td><input type=text name="txtnome" size=40></td> 
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CPF:</td><td><input type="text" name="txtcpf" size="11" maxlength="11"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Endereço:&nbsp;&nbsp;&nbsp;</td><td><input type=text name="txtendereco" size=30></td><td>&nbsp;Complemento:<input type="text" name="txtcomplemento" size="20"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bairro:</td><td><input type="text" name="txtbairro" size="10">&nbsp;&nbsp;Cidade:<input type="text" name="txtcidade" size="15"></td><td>&nbsp;UF:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="txtuf" size="10"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email:</td><td><input type="text" name="txtemail" size="30"></td><td>Registro CNH:<input type="text" name="txtcnh" size="11" maxlength="11"></td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td> </td><td> </td>
                    </tr>
                    <tr>
                        <td> </td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Cadastrar">&nbsp;&nbsp;&nbsp;<input type="reset" value="Limpar" onclick="reset()">&nbsp;&nbsp;&nbsp;<input type="button" value="Voltar" onclick="history.go(-1)"></td><td> </td>
                    </tr>
                </table>
                </br>
                </br>
        </div>
    </body>
</html>
    