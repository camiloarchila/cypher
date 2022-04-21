package edu.eci.cvds.Seguridad;

import edu.eci.cvds.Exceptions.BibliotecaException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

public class loginBeanImpl implements loginBean {

    private Subject sujeto;

    @Override
    public void inicia(String correo, String password, boolean remmemberme) throws BibliotecaException {
        sujeto = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(correo, password, remmemberme);
        try{
            sujeto.login(token);
        }catch (LockedAccountException lockedAccountException){
            throw new BibliotecaException("Muchos intentos", lockedAccountException);
        }catch (UnknownAccountException unknownAccountException){
            throw new BibliotecaException("Datos Erroneos", unknownAccountException);
        }catch (IncorrectCredentialsException incorrectCredentialsException){
            throw new BibliotecaException("Datos Erroneos", incorrectCredentialsException);
        }catch (AuthenticationException authenticationException){
            throw new BibliotecaException("No se pudo autenticar", authenticationException);
        }catch (Exception exception){
            throw new BibliotecaException("Oops, algo salio mal", exception);
        }
    }

    @Override
    public boolean logged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void logOut() {
        sujeto = SecurityUtils.getSubject();
        sujeto.logout();
    }
}
