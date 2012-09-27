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
@WebFilter(filterName = "Filtro", urlPatterns = {"/*"})
public abstract class Filtro implements Filter {

    private static final boolean debug = true;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Filtro() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    // Write code here to process the request and/or response after
    // the rest of the filter chain is invoked.
    // For example, a logging filter might log the attributes on the
    // request object after the request has been processed. 
	/*
     for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
     String name = (String)en.nextElement();
     Object value = request.getAttribute(name);
     log("attribute: " + name + "=" + value.toString());

     }
     */
    // For example, a filter might append something to the response.
	/*
     PrintWriter respOut = new PrintWriter(response.getWriter());
     respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
     */

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Logger log = Logger.getLogger(Autenticacao.class.getName());
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Boolean autenticado = (Boolean) req.getSession().getAttribute("UsuarioLogado");
        if (autenticado == null || !autenticado) {
            log.log(Level.INFO, String.format("Sem usuário autenticado [%s]", autenticado));
            RequestDispatcher dispatcher = req.getRequestDispatcher("NOTICIAS.jsp");
            dispatcher.forward(req, resp);
            if (!acessoPermitido(req)) {
                dispatcher = req.getRequestDispatcher("NOTICIAS.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        }
        log.log(Level.INFO, String.format("Usuário autenticado [%s]", autenticado));
        chain.doFilter(request, response);
    }

    /**
     * Return the filter configuration object for this filter. /** Set the
     * filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    /**
     * Destroy method for this filter
     */
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
