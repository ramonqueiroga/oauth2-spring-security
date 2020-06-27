package br.com.example.auth.security.oauth2poc.infra.config;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * This wrapper was created to be used in a HttpFilter (RequestFilter), where it decrypt a token from header if it is encrypted. If it is not encrypted, keeps it original.
 */
public class HttpHeaderTokenAdapter extends HttpServletRequestWrapper {

    public HttpHeaderTokenAdapter(ServletRequest request) {
        super((HttpServletRequest)request);
    }

    public String getHeader(String name) {
        if (name.equals("TESTE")) {
            String encrypted = super.getHeader("TESTE");
            String decrypted = "OUTRO";
            return decrypted;
        }
        return super.getHeader(name); //Default behavior
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> headerVals = Collections.list(super.getHeaders(name));
        int index = 0;
        for (String value : headerVals) {
            if ("TESTE".equalsIgnoreCase(name)) {
                headerVals.set(index, "MUDOU");
            }

            index++;
        }

        return Collections.enumeration(headerVals);
    }

    @Override
    public String getParameter(String name) {
        return "EITA";
    }

    @Override
    public String[] getParameterValues(String name) {
        return new String[]{"EITA"};
    }
}
