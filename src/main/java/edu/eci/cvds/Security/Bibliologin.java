package edu.eci.cvds.Security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bibliologin extends AccessControlFilter {

    String llevarurl;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        return !subject.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        if(SecurityUtils.getSubject().hasRole("Admin")){
            llevarurl="/faces/adminLogin.xhtml";
        }else if(SecurityUtils.getSubject().hasRole("User")){
            llevarurl="/faces/loginUsers.xhtml";
        }
        WebUtils.issueRedirect(servletRequest,servletResponse,llevarurl);
        return false;
    }

    public String getLlevarurl() {
        return llevarurl;
    }

    public void setLlevarurl(String llevarurl) {
        this.llevarurl = llevarurl;
    }
}
