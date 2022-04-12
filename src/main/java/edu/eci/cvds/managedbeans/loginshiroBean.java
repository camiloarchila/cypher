package edu.eci.cvds.managedbeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.eci.cvds.Security.Login;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginshiroBean")
@SessionScoped

public class loginshiroBean implements Serializable{
    private static final Logger log = LoggerFactory.getLogger(loginshiroBean.class);

    private String name;
    private String contrasena;
    private String urlnormal = "/faces/index.html";
    Subject subject;

    public void iniciaLogin(){
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getName(), new Sha256Hash(getContrasena()).toHex());
        try{
            subject.login(token);
            if(subject.hasRole("Admin")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/adminLogin.xhtml");
            }else if(subject.hasRole("User")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/loginUsers.xhtml");
            }
        }catch (UnknownAccountException ex) {
            facesError("No se encuentra la cuenta");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            System.err.println("Contrasena Incorrecta");
            facesError("Contrasena Incorrecta");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            facesError("Cuenta bloqueada");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException | IOException ex) {
            facesError("Error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (NullPointerException e) {
            System.err.println("error bean login");
        } finally {
            token.clear();
        }
    }

    private void facesError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUrlnormal() {
        return urlnormal;
    }

    public void setUrlnormal(String urlnormal) {
        this.urlnormal = urlnormal;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
