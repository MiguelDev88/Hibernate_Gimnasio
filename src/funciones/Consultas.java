package funciones;
import POJOS.*;
import gimnasiomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.hibernate.Session;


// @author Miguel
 
public class Consultas {
    
    public static void consultas (BufferedReader leer) throws IOException {
        
        byte op=1;
        
        try{

            while(op!=0)
            {
                op=Menu.menuConsultas(leer);
                switch (op){
                    case 1:
                        consultarSocio(leer);
                        break;
                    case 2:
                        consultarUso(leer);
                        break;
                }

            }
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public static void consultarSocio (BufferedReader leer) throws IOException {
        
        String nombre;
        C_Socio socio;
        C_Actividad actividad;

        Session sesion;
        
        System.out.println("Nombre del Socio a buscar:");
        nombre=leer.readLine();
        
        try{
            sesion=HibernateUtil.getSession();
            socio=(C_Socio)sesion.createQuery("FROM POJOS.C_Socio s WHERE s.nombre='"+nombre+"'").uniqueResult();

            if(socio!=null)
            {
                System.out.println("\nDATOS DEL SOCIO: "+socio.getNombre());
                    
                  
                System.out.println("----------------------------------------------------------");
                System.out.println("|    DNI    |   NOMBRE   |  TELEFONO  | CUOTA | GIMNASIO |");
                System.out.printf("|%11s|%12s|%12s|%7s|%10s| %n",socio.getDni(),socio.getNombre(),socio.getTelefono(),socio.getCuota(),socio.getGimnasio().getNombre());
                System.out.println("----------------------------------------------------------");
                
                Iterator actividades=socio.getActividades().iterator();
                
                System.out.println("\nLISTA DE ACTIVIDADES DEL SOCIO: "+socio.getNombre());
                System.out.println("--------------");
                while(actividades.hasNext())
                {
                    actividad=(C_Actividad)actividades.next();
                    System.out.printf("|%12s|%n",actividad.getNombre());
                }
                System.out.println("--------------");

            }else
                System.out.println("\n No se ha encontrado al Socio \n");
            
            sesion.close();
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }
    
    public static void consultarUso (BufferedReader leer) throws IOException {
        
        String nombre;
        Date fecha;
        Time horaInicio;
        C_Uso uso;
        C_Socio socio;
        Session sesion;
        
        System.out.println("Introducir nombre del Socio a buscar:");
        nombre=leer.readLine();
        try{
            sesion=HibernateUtil.getSession();
            socio=(C_Socio)sesion.createQuery("FROM POJOS.C_Socio s WHERE s.nombre='"+nombre+"'").uniqueResult();
        
            if(socio!=null){
                System.out.println("Introducir fecha a buscar:");
                fecha=Date.valueOf(leer.readLine());
                System.out.println("Introducir hora de entrada:");
                horaInicio=Time.valueOf(leer.readLine());
                
                uso=(C_Uso)sesion.get(C_Uso.class, new C_Uso(socio,fecha,horaInicio));
                
                if(uso!=null){
                    System.out.println("Hora de Salida del socio "+socio.getNombre()+":");
                    System.out.println(uso.getHoraFin());
                }
                
                else
                    System.out.println("\n No se ha encontrado ningún registro en esa fecha y hora \n");
            }
            else
                    System.out.println("\n No se ha encontrado ningún Socio con ese nombre \n");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void verGimnasios () throws IOException {
        
        C_Gimnasio gimnasio;
        Session sesion;
        
        try{
            sesion=HibernateUtil.getSession();
            Iterator gimnasios = sesion.createCriteria(C_Gimnasio.class).list().iterator();
            
            System.out.println("--------------------------------------------------");
            System.out.println("|  CIF  |    NOMBRE    |  DIRECCION  |  TELEFONO  | ");
            
            while(gimnasios.hasNext())
            {
                gimnasio=(C_Gimnasio)gimnasios.next();
                System.out.printf("|%7s|%14s|%13s|%12s| %n",gimnasio.getCif(),gimnasio.getNombre(),gimnasio.getDireccion(),gimnasio.getTelefono());
            }
            
            System.out.println("--------------------------------------------------");
            
            sesion.close();
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public static void verActividades (Session sesion) throws IOException {
        
        C_Actividad actividad;
        
        try{
            Iterator actividades = sesion.createCriteria(C_Actividad.class).list().iterator();
            System.out.println("LISTA COMPLETA DE ACTIVIDADES REGISTRADAS EN LA BD:");
            System.out.println("-----------------------------");
            System.out.println("|    NOMBRE    | NUM_SOCIOS | ");
            
            while(actividades.hasNext())
            {
                actividad=(C_Actividad)actividades.next();
                System.out.printf("|%14s|%12s| %n",actividad.getNombre(),actividad.getNumSocios());
            }
            
            System.out.println("-----------------------------");
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }

}
