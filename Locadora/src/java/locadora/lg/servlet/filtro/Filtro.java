package locadora.lg.servlet.filtro;

import java.io.IOException;
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
@WebFilter(filterName = "Filtro", urlPatterns = {"/veiculos.jsp"})
public class Filtro implements Filter {

    private static final boolean debug = true;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Filtro() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Boolean autenticado = (Boolean) req.getSession().getAttribute("Logado");
        if (autenticado == null || !autenticado) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("veiculos.jsp");
           // dispatcher.forward(req, resp);
           
       //    System.out.printf("Fazendo Request para alguma coisa [%s]", req.getRequestURI());
           chain.doFilter(request, response);
     //      System.out.printf("Devolvendo Response para alguma coisa [%s]", req.getRequestURI());
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        }
        //chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
