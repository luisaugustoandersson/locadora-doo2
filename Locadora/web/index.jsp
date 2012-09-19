<%-- 
    Document   : index
    Created on : 13/09/2012, 14:24:39
    Author     : CCE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locadora de Veiculos</title>
        <link rel="stylesheet" href="css/stilo.css" type="text/css">
        <script type="text/javascript" src="js/javascript.js" charset="UTF-8"></script>
    </head>
    <body>
        <div class="principal">
            <div class="logo" id="logo" >
                
            </div>
            <div class="login">
                <p>&nbsp;&nbsp;Usuário:<input type="text" name="txtlogin" size="15"></br>
                    &nbsp;&nbsp;Senha:&nbsp;&nbsp;<input type="password" name="txtsenha" size="15"></br>
                    &nbsp;&nbsp;<input type="checkbox" name="checksenha">&nbsp;lembrar minha senha?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" name="botaoentra">Entrar</button></br>
                    &nbsp;&nbsp;&nbsp;não possui conta? clique <a href="controleprinc?acao=novocliente">aqui</a>
                </p>
            </div>
            <div class="conteudo">
                <p></p>
            </div>
            <div class="busca">
                <p>&nbsp;&nbsp;<input type="text" name="txtbusca" size="25" maxlength="40" style="width:80; height:18">
                    <img src="imagens/busca.ico"><a href="www.google.com.br">Buscar</a></br>
                </p>
            </div>    
        </div>
    </body>
</html>