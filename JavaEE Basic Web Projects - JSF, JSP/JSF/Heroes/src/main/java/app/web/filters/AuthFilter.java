package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/views/home.xhtml",
        "/views/create-hero.xhtml",
        "/views/delete-hero.xhtml",
        "/views/details-hero.xhtml",
        "/views/details-hero.xhtml/*",
        "/faces/views/home.xhtml",
        "/faces/views/create-hero.xhtml",
        "/faces/views/delete-hero.xhtml",
        "/faces/views/details-hero.xhtml",
        "/faces/views/details-hero.xhtml/*"

})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object username = request.getSession()
                .getAttribute("username");
        if(username == null) {
            response.sendRedirect("/views/login.xhtml");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
