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
 * @author mertins
 */
public class ControleLogin {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private Connection conn;

    public ControleLogin(HttpServletRequest req, HttpServletResponse resp, Connection conn) {
        this.req = req;
        this.resp = resp;
        this.conn = conn;
    }

    public void processo() throws ServletException, IOException, SQLException {
        String user = req.getParameter("txtUsuario");
        String senha = req.getParameter("txtSenha");
        ClienteDAO usrDAO = new ClienteDAO(conn);
        Cliente cliente = new Cliente();
        cliente.setUsername(user);
        cliente.setSenha(senha);
        cliente = usrDAO.retrive(cliente);
        if (cliente == null || !cliente.validasenha(senha)) {
            ControlePrincipal.dispatcherErro(req, resp, "Usuario ou senha invalida");
            return;
        } else {
            req.getSession().setAttribute("Logado", Boolean.TRUE);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
