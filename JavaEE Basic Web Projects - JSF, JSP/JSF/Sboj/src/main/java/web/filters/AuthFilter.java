package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/views/home.xhtml",
        "/views/job-details.xhtml",
        "/views/job-delete.xhtml",
        "/views/add-job.xhtml",
        "/faces/views/home.xhtml",
        "/faces/views/job-details.xhtml",
        "/faces/views/job-delete.xhtml",
        "/faces/views/add-job.xhtml"

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
