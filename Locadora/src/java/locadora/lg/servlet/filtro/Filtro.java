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
@WebFilter(filterName = "Filtro", urlPatterns = {"/*"})
public class Filtro implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public Filtro() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Boolean autenticado = (Boolean) req.getSession().getAttribute("Logado");
        if (autenticado == null || !autenticado) {
            if (acessoPermitido(req)) {
                String acao = req.getParameter("acao");
                if ("novocliente".equals(acao)) {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("formcliente.jsp");
                    dispatcher.forward(req, resp);
                    chain.doFilter(request, response);
                } else {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                    dispatcher.forward(req, resp);
                    chain.doFilter(request, response);
                }
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private boolean acessoPermitido(HttpServletRequest req) {
        boolean ret = false;
        String pagina = req.getRequestURI();
        String acao = req.getParameter("acao");
        if (pagina != null || "login".equals(acao) || "novocliente".equals(acao)) {
            ret = true;
        }
        return ret;
    }
}