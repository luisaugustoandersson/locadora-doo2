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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CCE
 */
@WebServlet(name = "ControleAcesso", urlPatterns = {"/ControleAcesso"})
public class ControleAcesso extends HttpServlet {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private Connection conn;

    public ControleAcesso(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
        this.req = req;
        this.resp = resp;
        this.conn = conn;
    }
    
    public void processo() throws ServletException, IOException, SQLException {
        Boolean ok = false;
        ok = (Boolean) req.getSession().getAttribute("Logado");
        if (!ok) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("promocao.jsp");
            dispatcher.forward(req, resp);
            return;
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("veiculo.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
