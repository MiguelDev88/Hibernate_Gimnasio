package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel
 
public class C_Gimnasio implements Serializable {
    
    private String cif, nombre, direccion, telefono;
    private Set<C_Actividad> actividades=new HashSet();
    
    
    public C_Gimnasio(){}
    
    public C_Gimnasio(String cif, String nombre, String direccion, String telefono){
        
        this.cif=cif;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<C_Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<C_Actividad> actividades) {
        this.actividades = actividades;
    }
    
}
