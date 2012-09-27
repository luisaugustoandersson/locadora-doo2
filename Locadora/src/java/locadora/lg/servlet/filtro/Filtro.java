/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.lg.servlet.filtro;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme Gehling
 */
@WebFilter(filterName = "filtro", urlPatterns = {"/veiculo.jsp"})
public abstract class Filtro implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public Filtro() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Logger log = Logger.getLogger(Autenticacao.class.getName());
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Boolean autenticado = (Boolean) req.getSession().getAttribute("Logado");
        if (autenticado == null || !autenticado) {
            //log.log(Level.INFO, String.format("Sem usuário autenticado [%s]", autenticado));
            RequestDispatcher dispatcher = req.getRequestDispatcher("noticias.jsp");
            dispatcher.forward(req, resp);
            if (!acessoPermitido(req)) {
                dispatcher = req.getRequestDispatcher("noticias.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        }
        //log.log(Level.INFO, String.format("Usuário autenticado [%s]", autenticado));
        //chain.doFilter(request, response);
        
    }

    public void destroy() {
    }

    private boolean acessoPermitido(HttpServletRequest req) {
        boolean ret = false;
        String pagina = req.getRequestURI();
        String acao = req.getParameter("acao");




        if (pagina != null && "login".equals(acao)) {
            Logger.getLogger(Filtro.class
                    .getName()).log(Level.INFO, String.format("Acesso autorizado sem autenticação à página [%s]", pagina));
            ret = true;
        }
        return ret;
    }
}
