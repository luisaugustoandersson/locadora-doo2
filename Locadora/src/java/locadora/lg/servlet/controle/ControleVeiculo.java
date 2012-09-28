/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.lg.servlet.controle;

import bean.Veiculo;
import dao.VeiculoDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme Gehling
 */
public class ControleVeiculo {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private Connection conn;

    public ControleVeiculo(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
        this.req = req;
        this.resp = resp;
        this.conn = conn;
    }

    public void processo() throws ServletException, IOException, SQLException {
        String acaoCRUD = req.getParameter("acaoCRUD");

        if ("salvar".equals(acaoCRUD)) {
            this.salvar();
        } else if ("carregar".equals(acaoCRUD)) {
            this.carregar();
        } else if ("excluir".equals(acaoCRUD)) {
            this.excluir();
        }
        listaTodos();
        RequestDispatcher dispatcher = req.getRequestDispatcher("veiculos.jsp");
        dispatcher.forward(req, resp);
    }

    private void salvar() throws ServletException, IOException {
        String descricao = req.getParameter("txtDescricao");
        String localizacao = req.getParameter("txtLocalizacao");
        Veiculo dept = new Veiculo();
        int codigo = 0;
        try {
            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
        } catch (NumberFormatException ex) {
        } catch (NullPointerException ex) {
        }
        try {
            if (codigo == 0) {
            } else {
            }
        } catch (Exception ex) {
            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível inserir departamento.[%s]", ex.getMessage()));
            return;
        }
    }

    private void carregar() throws ServletException, IOException {

        int codigo = 0;
        try {
            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
        } catch (NumberFormatException ex) {
        } catch (NullPointerException ex) {
        }
        VeiculoDAO vecDAO = new VeiculoDAO(conn);
        try {
            if (codigo > 0) {
                Veiculo vec = new Veiculo();
                vec = vecDAO.retrive(vec);
                req.setAttribute("veiculo", vec);
            }
        } catch (Exception ex) {
            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível ler departamento.[%s]", ex.getMessage()));
            return;
        }

    }

    private void excluir() throws ServletException, IOException {
        int codigo = 0;
        try {
            codigo = Integer.parseInt(req.getParameter("txtCodigo"));
        } catch (NumberFormatException ex) {
        } catch (NullPointerException ex) {
        }
        VeiculoDAO vecDAO = new VeiculoDAO(conn);
        try {
            if (codigo > 0) {
                Veiculo vec = new Veiculo();
                vec.setCod(codigo);
                vecDAO.delete(vec);
            }
        } catch (Exception ex) {
            ControlePrincipal.dispatcherErro(req, resp, String.format("Não foi possível excluir departamento.[%s]", ex.getMessage()));
            return;
        }
    }

    private void listaTodos() throws ServletException, IOException, SQLException {
        VeiculoDAO vecDAO = new VeiculoDAO(conn);
        req.setAttribute("veiculos", vecDAO.listaTodos());
    }
}