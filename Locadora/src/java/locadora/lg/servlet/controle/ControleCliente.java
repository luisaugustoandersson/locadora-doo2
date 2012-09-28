/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.lg.servlet.controle;

import bean.Cliente;
import dao.ClienteDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CCE
 */
public class ControleCliente {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private Connection conn;

    public ControleCliente(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
        this.req = req;
        this.resp = resp;
        this.conn = conn;
    }

    public void processo(String acaoCRUD) throws ServletException, IOException, SQLException {
        if ("salvar".equals(acaoCRUD)) {
            this.salvar();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    private void salvar() throws ServletException, IOException {
        //aqui inserir todos os campos do cadastro de cliente
        String nome = req.getParameter("txtnome");
        String cpf = req.getParameter("txtcpf");
        String endereco = req.getParameter("txtendereco");
        String complemento = req.getParameter("txtcomplemento");
        String bairro = req.getParameter("txtbairro");
        String cidade = req.getParameter("txtcidade");
        String uf = req.getParameter("txtuf");
        String cnh = req.getParameter("txtcnh");
        String user = req.getParameter("txtuser");
        String senha = req.getParameter("txtsenha");
        String email = req.getParameter("txtemail");
        
        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setCpf(Integer.parseInt(cpf));  
        cli.setEndereco(endereco);
        cli.setComplemento(complemento);
        cli.setBairro(bairro);
        cli.setCidade(cidade);
        cli.setUf(uf);
        cli.setCnh(Integer.parseInt(cnh));     
        cli.setUsername(user);
        cli.setSenha(senha);
        cli.setEmail(email);
        
        int codigo = 0;
        try {
            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
        } catch (NumberFormatException ex) {
        } catch (NullPointerException ex) {
        }
        ClienteDAO cliDAO = new ClienteDAO(conn);
        try {
            if (codigo == 0) {
                cliDAO.create(cli);
            } else {
                cli.setCod(codigo);
                cliDAO.update(cli);
            }
        } catch (Exception ex) {
            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível Cadastrar o Cliente.[%s]", ex.getMessage()));
            return;
        }
    }
}

