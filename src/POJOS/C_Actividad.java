package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel
 
public class C_Actividad implements Serializable {
    
    private int id;
    private String nombre;
    private Set<C_Socio> socios;
    private int numSocios;
    
    
    public C_Actividad(){}
    
    public C_Actividad(String nombre){
        
        this.nombre=nombre;
        this.socios=new HashSet();
        this.numSocios=0;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<C_Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<C_Socio> socios) {
        this.socios = socios;
    }

    public int getNumSocios() {
        return numSocios;
    }

    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }
    
    public void nuevoRegistro (){
        this.numSocios++;
    }
    
}
