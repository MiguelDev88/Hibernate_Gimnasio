package funciones;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel
 
public class Menu {
    
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("\nSeleccione opción:"
                + "\n1.Altas"
                + "\n2.Bajas"
                + "\n3.Modificaciones"
                + "\n4.Consultas"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea dar de alta?"
                + "\n1.Gimnasio"
                + "\n2.Actividad"
                + "\n3.Socio"
                + "\n4.Uso"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuBajas (BufferedReader leer) throws IOException {
        
        byte op;
        
        System.out.println("¿Qué desea dar de baja?"
                + "\n1.Gimnasio"
                + "\n2.Actividad"
                + "\n3.Socio"
                + "\n4.Uso"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
    
        byte op;
        
        System.out.println("¿Qué desea consultar?"
                        + "\n1.Datos de un Socio"
                        + "\n2.Datos de un Uso"
                        + "\n0.Finalizar");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
    
}
