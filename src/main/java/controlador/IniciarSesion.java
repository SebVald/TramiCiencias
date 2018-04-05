package controlador;

import modelo.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.*;

/**
 *
 * @author Juanitobanana
 */

@ManagedBean
@SessionScoped
public class IniciarSesion {
    
    
    @Getter @Setter private String correoUsuario;
    @Getter @Setter private String contrasena;
        
    public String login() {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario usuario = udao.buscar(correoUsuario,contrasena);
        FacesContext context = FacesContext.getCurrentInstance();

        if (usuario == null) {
            context.addMessage(null, new FacesMessage("No se encontró el usuario"));
            correoUsuario = null;
            contrasena = null;
            return "";
        } else{
            context.getExternalContext().getSessionMap().put("user", usuario);
            correoUsuario = null;
            contrasena = null;
            return "index.xhtml?faces-redirect=true";
        
        }
    }

    public String  logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
}
