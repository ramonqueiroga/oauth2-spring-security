package br.com.example.auth.security.oauth2poc.infra.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Already adapted to Spring 5 and Spring Boot 2.x >
 */
public class HttpInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(HttpInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("TESTE", "TESTE");
        LOG.info("Interceptor logging only for testing propose");
        return true;
    }
}
