package by.str.connector;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class PreAuthTokenHeaderFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String authHeaderName;

    public PreAuthTokenHeaderFilter(String authHeaderName) {
        this.authHeaderName = authHeaderName;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader(authHeaderName);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return null;
    }
}
