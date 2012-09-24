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
        <div class="menu">
            <table border="0">
                <tr>
                    <td>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="noticias.jsp"><img src="imagens/noticias.png"></a> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>|&nbsp;&nbsp;&nbsp;&nbsp;<a href="veiculos.jsp"><img src="imagens/veiculos.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;|</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="formcliente.jsp"><img src="imagens/cadastro.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>|&nbsp;&nbsp;&nbsp;&nbsp;<a href="promocoes.jsp"><img src="imagens/promocoes.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;|</td>
                </tr>
            </table>
        </div>
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

                <div id="txt">
                    <span id="ctl00_ContentPlaceHolder1_cvTextoInformacoesGerais" style="height:100%;width:100%;"><div style="overflow:none;">
                            <p><span class="subtitulo_motivos">&nbsp;&nbsp;&nbsp;&nbsp;Economia, conforto e praticidade na hora de viajar</span></p>
                            <p>&nbsp;&nbsp;&nbsp;&nbsp;Não importa o motivo da sua viagem: férias, negócios, passeio. Um carro te proporciona muito mais &nbsp;&nbsp;&nbsp;&nbsp;liberdade para ir e vir, além de segurança e conforto.</p>
                            <p>&nbsp;&nbsp;&nbsp;&nbsp;Para viajar nas férias ou feriados, você pode alugar um carro que ofereça espaço e conforto, como &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ar-condicionado e porta-malas grande. Se a viagem for a negócios, o aluguel de um carro pode sair &nbsp;&nbsp;&nbsp;&nbsp;mais barato que os custos de um táxi.</p>
                             
                            
                            
                        </div></span>
                    <!-- motivo1 -->
                    <span id="ctl00_ContentPlaceHolder1_cvtitulo_viagem_ferias_passeios" class="motivos" style="height:100%;width:100%;"><div style="overflow:none;">
                            <H3>&nbsp;&nbsp;&nbsp;&nbsp;Viagem de férias e passeios</H3>
                        </div></span>
                    <span id="ctl00_ContentPlaceHolder1_cvconteudo_viagem_ferias_passeios" style="height:100%;width:100%;"><div style="overflow:none;">
                            <UL>
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Viajar de carro fazendo seu próprio roteiro 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Evitar desgaste do seu carro 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Viajar pelo litoral brasileiro e outras cidades </LI></UL>
                        </div></span>
                    <span id="ctl00_ContentPlaceHolder1_cvtitulo_motivos_viagem_trabalho_negocios" class="motivos" style="height:100%;width:100%;"><div style="overflow:none;">
                            <H3>&nbsp;&nbsp;&nbsp;&nbsp;Viagem de trabalho e negócios</H3>
                        </div></span>
                    <span id="ctl00_ContentPlaceHolder1_cvconteudo_motivos_viagem_trabalho_negocios" style="height:100%;width:100%;"><div style="overflow:none;">
                            <UL>
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Carro executivo com motorista bilíngue 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Alugar carro no aeroporto 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Rodízio de carros </LI></UL>
                        </div></span>
                    <span id="ctl00_ContentPlaceHolder1_cvtitulo_motivos_economia_comodidade" class="motivos" style="height:100%;width:100%;"><div style="overflow:none;">
                            <H3>&nbsp;&nbsp;&nbsp;&nbsp;Economia e comodidade</H3>
                        </div></span>
                    <span id="ctl00_ContentPlaceHolder1_cvconteudo_motivos_economia_comodidade" style="height:100%;width:100%;"><div style="overflow:none;">
                            <UL>
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Carro com motorista para festas e eventos 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Carro com GPS 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Seu carro na oficina mecânica 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Faça um test-drive antes de comprar um carro 
                                <LI>&nbsp;&nbsp;&nbsp;&nbsp;Programa Fidelidade Localiza </LI></UL>
                        </div></span>
                </div>


            </div>
            <div class="busca">
                <p>&nbsp;&nbsp;<input type="text" name="txtbusca" size="30" maxlength="40" style="width:80; height:18">
                    <a href="busca"><img src="imagens/busca.ico"></a></br>
                </p>
            </div>    
        </div>
    </body>
</html>