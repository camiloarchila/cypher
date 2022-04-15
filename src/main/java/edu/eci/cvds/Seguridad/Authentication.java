package edu.eci.cvds.Seguridad;
import javax.servlet.ServletRequest;
/**
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.apache.shiro.SecurityUtils;
public class Authentication extends AccessControlFilter{

    String welcomeurl;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        return !subject.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        if (SecurityUtils.getSubject().hasRole("Admin")){
            welcomeurl = "/CVDS.Project/Admin.xhtml";

        }else if(SecurityUtils.getSubject().hasRole("User")){
            welcomeurl = "/CVDS.Project/Users.xhtml";
        }
        WebUtils.issueRedirect(servletRequest,servletResponse,welcomeurl);
        return false;
    }

    public String getUrl() {
        return welcomeurl;
    }

    public void setUrl(String url) {
        this.welcomeurl = url;
    }
}
***/
public class Authentication {
}
