package br.com.example.auth.security.oauth2poc.infra.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * This filter is executed every time a request happens to othe api. This filter execute first of every interceptor or others filters,
 * and adapter the request in the HttpHeaderTokenAdapter
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequestWrapper decryptedRequest = new HttpHeaderTokenAdapter(servletRequest);
        filterChain.doFilter(decryptedRequest, servletResponse);
    }

}
