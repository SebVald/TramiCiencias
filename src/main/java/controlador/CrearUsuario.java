package controlador;

import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import modelo.*;
import lombok.*;

/**
 *
 * @author Juanitobanana
 */

@ViewScoped
@ManagedBean
public class CrearUsuario {
    @Getter @Setter private String correo;
    @Getter @Setter private String nombreUsuario;
    @Getter @Setter private Date fechaNacimiento;
    @Getter @Setter private boolean esAdmin;
    @Getter @Setter private String contrasena;
    @ManagedProperty(value = "#{param.id}")
    @Getter @Setter private String id;
    
    
      
    public void crearUsuario() {
        Usuario u = Usuario.builder().correo(correo)
                .nombreUsuario(nombreUsuario)
                .fechaNacimiento(fechaNacimiento)
                .esAdmin(esAdmin)
                .contrasena(contrasena).build();
        UsuarioDAO udao = new UsuarioDAO();
        udao.guardar(u);
    }
    
}
