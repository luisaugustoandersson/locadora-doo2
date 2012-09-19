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
        String login = req.getParameter("txtUsuario");
        String senha = req.getParameter("txtSenha");
        //UsuarioDAO usrDao = new UsuarioDAO(conn);
        //Usuario usuario = usrDao.retrieve(login);
        //if (usuario == null || !usuario.validaSenha(senha)) {
            //ServletPrincipal.dispatcherErro(req, resp, String.format("Usuário ou Senha Inválidos.[%s]", login));
            return;
        //} else {
          //  req.getSession().setAttribute("UsuarioLogado", Boolean.TRUE);
           // RequestDispatcher dispatcher = req.getRequestDispatcher("formprincipal.jsp");
            //dispatcher.forward(req, resp);
        }
    }
//}
