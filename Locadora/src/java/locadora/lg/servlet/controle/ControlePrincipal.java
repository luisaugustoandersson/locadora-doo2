/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.lg.servlet.controle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import locadora.lg.servlet.filtro.Filtro;

/**
 *
 * @author CCE
 */
@WebServlet(name = "ControlePrincipal", urlPatterns = {"/controleprinc"})
public class ControlePrincipal extends HttpServlet {


    public ControlePrincipal(DataSource dataSource, Exception exception) {
        this.dataSource = dataSource;
        this.exception = exception;
    }

    public ControlePrincipal() {
    }
    private DataSource dataSource;
    private Exception exception;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DataSource dataSource = null;
        Connection conn = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/locadorabd");
            conn = dataSource.getConnection();
            String acao = req.getParameter("acao");
            String acaoCRUD = req.getParameter("acaoCRUD");
            if ("login".equals(acao)) {
                ControleLogin lc=new ControleLogin(req, res, conn);
                lc.processo();
            } else if("novocliente".equals(acao)){
                ControleCliente cc=new ControleCliente(req, res, conn);
                cc.processo(acaoCRUD);
            } else if("filtro".equals(acao)){
                ControleAcesso novofiltro=new ControleAcesso(req, res, conn);
                novofiltro.processo();
            } else if("logout".equals(acao)){
                req.getSession().invalidate();
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ControlePrincipal.dispatcherErro(req, res, ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    public static void dispatcherErro(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("mensagem", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("formerro.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/locadorabd");
        } catch (NamingException ex) {
            exception = ex;
        }
    }
}