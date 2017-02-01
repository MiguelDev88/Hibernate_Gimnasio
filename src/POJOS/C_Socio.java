package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel
 
public class C_Socio implements Serializable {
    
    private String dni,nombre,telefono;
    private double cuota;
    private C_Gimnasio gimnasio;
    private Set<C_Actividad> actividades;
    
    
    public C_Socio(){}
    
    public C_Socio(String dni, String nombre, String telefono, double cuota){
        
        this.dni=dni;
        this.nombre=nombre;
        this.telefono=telefono;
        this.cuota=cuota;
        this.actividades=new HashSet();
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public C_Gimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(C_Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public Set<C_Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<C_Actividad> actividades) {
        this.actividades = actividades;
    }

}
