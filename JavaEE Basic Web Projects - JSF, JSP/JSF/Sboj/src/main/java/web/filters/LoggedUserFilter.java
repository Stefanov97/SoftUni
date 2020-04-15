package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/views/login.xhtml",
        "/views/register.xhtml",
        "/views/index.xhtml",

        "/faces/views/login.xhtml",
        "/faces/views/register.xhtml",
        "/faces/views/index.xhtml"
})
public class LoggedUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object username = request.getSession()
                .getAttribute("username");
        if(username != null) {
            response.sendRedirect("/views/home.xhtml");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
