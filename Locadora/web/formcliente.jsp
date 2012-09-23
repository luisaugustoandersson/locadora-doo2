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
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nome:&nbsp;&nbsp;&nbsp;</td><td><input type=text name="txtnome" size=40></td> 
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CPF:</td><td><input type="text" name="txtcpf" size="11" maxlength="11"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Endereço:&nbsp;&nbsp;&nbsp;</td><td><input type=text name="txtendereco" size=30></td><td>&nbsp;Compl:<input type="text" name="txtcomplemento" size="20"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bairro:</td><td><input type="text" name="txtbairro" size="11"></td><td>&nbsp;Cidade:<input type="text" name="txtcidade" size="15"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UF:</td><td><input type="text" name="txtuf" size="11"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reg.CNH:</td><td><input type="text" name="txtcnh" size="11" maxlength="11"></td>
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
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Usuario:</td><td><input type="text" name="txtuser" size="20" maxlength="15"</td><td> </td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Senha:</td><td><input type="password" name="txtsenha" size="20" maxlength="15"</td><td> </td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E-mail:</td><td><input type="text" name="txtemail" size="30"></td><td> </td><td> </td>
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
                        <td> </td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Cadastrar" formaction="controleprinc?acao=novocliente?acaoCRUD=salvar">&nbsp;&nbsp;&nbsp;<input type="reset" value="Limpar" onclick="reset()">&nbsp;&nbsp;&nbsp;<input type="button" value="Voltar" onclick="history.go(-1)"></td><td> </td>
                    </tr>
                </table>
                </br>
                </br>
        </div>
    </body>
</html>
    