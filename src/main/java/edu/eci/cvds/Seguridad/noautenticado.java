package edu.eci.cvds.Seguridad;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class noautenticado extends AccessControlFilter {

    String urlini = "CVDS.Project/recursos.xhtml";

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject sujeto = getSubject(servletRequest, servletResponse);
        return !sujeto.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        WebUtils.issueRedirect(servletRequest,servletResponse,urlini);
        return false;
    }

    public String getUrlini(){return urlini;}

    public void setUrlini(){this.urlini = urlini;}
}
