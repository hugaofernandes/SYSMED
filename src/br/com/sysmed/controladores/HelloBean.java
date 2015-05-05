package br.com.sysmed.controladores;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {

    /**
     * Creates a new instance of HelloBean
     */
    private static final long serialVersionUID = 1L;

    private String name="/View/pacientes.xhtml";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}