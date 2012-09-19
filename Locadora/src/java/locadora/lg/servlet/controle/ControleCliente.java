/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.lg.servlet.controle;

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

    public void processo() throws ServletException, IOException, SQLException {
        String acaoCRUD = req.getParameter("acaoCRUD");

        if ("salvar".equals(acaoCRUD)) {
            this.salvar();
        }
//            else if ("carregar".equals(acaoCRUD)) {
//            this.carregar();
//        } else if ("excluir".equals(acaoCRUD)) {
//            this.excluir();
//        }
//       listaTodos();
        RequestDispatcher dispatcher = req.getRequestDispatcher("formcliente.jsp");
        dispatcher.forward(req, resp);
    }

    private void salvar() throws ServletException, IOException {
        //aqui inserir todos os campos do cadastro de cliente
        String descricao = req.getParameter("txtDescricao");
        String localizacao = req.getParameter("txtLocalizacao");
        
        Cliente cli = new Cliente();
        cli.setDescricao(descricao);
        cli.setLocalizacao(localizacao);
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
            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível inserir departamento.[%s]", ex.getMessage()));
            return;
        }
    }
}

//    private void carregar() throws ServletException, IOException {
//
//        int codigo = 0;
//        try {
//            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
//        } catch (NumberFormatException ex) {
//        } catch (NullPointerException ex) {
//        }
//        DepartamentoDAO deptDAO = new DepartamentoDAO(conn);
//        try {
//            if (codigo > 0) {
//                Departamento dept = new Departamento(codigo);
//                dept = deptDAO.retrieve(dept);
//                req.setAttribute("departamento", dept);
//            }
//        } catch (Exception ex) {
//            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível ler departamento.[%s]", ex.getMessage()));
//            return;
//        }
//
//    }

//    private void excluir() throws ServletException, IOException {
//        int codigo = 0;
//        try {
//            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
//        } catch (NumberFormatException ex) {
//        } catch (NullPointerException ex) {
//        }
//        DepartamentoDAO deptDAO = new DepartamentoDAO(conn);
//        try {
//            if (codigo > 0) {
//                Departamento dept = new Departamento(codigo, req.getParameter("txtDescricao"), req.getParameter("txtLocalizacao"));
//                deptDAO.delete(dept);
//            }
//        } catch (Exception ex) {
//            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível excluir departamento.[%s]", ex.getMessage()));
//            return;
//        }
//    }

//    private void listaTodos() throws ServletException, IOException, SQLException {
//        DepartamentoDAO deptDAO = new DepartamentoDAO(conn);
//        req.setAttribute("departamentos", deptDAO.listaTodos());
//    }
//}
