package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component("RealFilter")
public class RealFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie cookie = new Cookie("RealFilter","Works");
        cookie.setPath(((HttpServletRequest)servletRequest).getContextPath());
        cookie.setMaxAge(60);

        ((HttpServletResponse)servletResponse).addCookie(cookie);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
