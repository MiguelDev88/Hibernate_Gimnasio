package funciones;
import POJOS.*;
import gimnasiomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Time;
import java.sql.Date;
import org.hibernate.Session;


// @author Miguel
 
public class Altas {
    
    
    public static void altas (BufferedReader leer) throws IOException {
        
        byte op=1;

        while(op!=0){
            op=Menu.menuAltas(leer);
            switch(op){
                case 1:
                    altaGimnasio(leer);
                    break;
                case 2:
                    altaActividad(leer);
                    break;
                case 3:
                    altaSocio(leer);
                    break;
                case 4:
                    altaUso(leer);
                    break;
            }
        }
        
    }
    
    public static void altaGimnasio (BufferedReader leer) throws IOException {
        
        C_Gimnasio gimnasio;
        
        try{
            gimnasio=nuevoGimnasio(leer);

            Session sesion=HibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.save(gimnasio);
            sesion.getTransaction().commit();
            
            System.out.println("\n - GIMNASIO REGISTRADO - \n");
            
            Asociar.asociarActividad(gimnasio, sesion, leer);
            
            sesion.close();
            
        }catch(Exception e){
            System.out.println("\n - ERROR EN EL ALTA DEL GIMNASIO - \n");
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void altaActividad (BufferedReader leer) throws IOException {
        
        C_Actividad actividad;
        
        try{
            actividad=nuevaActividad(leer);

            Session sesion=HibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.save(actividad);
            sesion.getTransaction().commit();
            sesion.close();
            
        }catch(Exception e){
            System.out.println("\n - ERROR EN EL ALTA DE LA ACTIVIDAD - \n");
        }
        
    }
    
    public static void altaSocio (BufferedReader leer) throws IOException {
        
        C_Socio socio;
        
        try{
            socio=nuevoSocio(leer);
            Asociar.asociarGimnasio(socio, leer);

            Session sesion=HibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.save(socio);
            sesion.getTransaction().commit();
            
            Asociar.asociarActividad(socio, sesion, leer);
            
            sesion.close();
        
        }catch(Exception e){
            System.out.println("\n - ERROR EN EL ALTA DEL SOCIO - \n");
        }
        
    }
    
    public static void altaUso (BufferedReader leer) throws IOException {
        
        C_Uso uso;
        
        try{
            uso=nuevoUso(leer);
            Asociar.asociarSocio(uso, leer);

            Session sesion=HibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.save(uso);
            sesion.getTransaction().commit();
            sesion.close();
            
        }catch(Exception e){
            System.out.println("\n - ERROR EN EL ALTA DEL USO - \n");
        }
        
    }
    
    public static C_Gimnasio nuevoGimnasio (BufferedReader leer) throws IOException {
        
        String cif, nombre, direccion, telefono;
        
        
        System.out.println("Introducir cif:");
        cif=leer.readLine();
        System.out.println("Introducir nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir dirección:");
        direccion=leer.readLine();
        System.out.println("Introducir teléfono:");
        telefono=leer.readLine();
        
        C_Gimnasio gimnasio=new C_Gimnasio(cif,nombre,direccion,telefono);
        
        return gimnasio;
        
    }
    
    public static C_Socio nuevoSocio (BufferedReader leer) throws IOException {
        
        String dni,nombre,telefono;
        double cuota;
        
        System.out.println("Introducir dni:");
        dni=leer.readLine();
        System.out.println("Introducir nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir teléfono:");
        telefono=leer.readLine();
        System.out.println("Introducir cuota:");
        cuota=Double.parseDouble(leer.readLine());
        
        C_Socio socio = new C_Socio(dni,nombre,telefono,cuota);
        
        return socio;

    }
    
    public static C_Actividad nuevaActividad (BufferedReader leer) throws IOException {
        
        String nombre;
        
        System.out.println("Introducir nueva actividad:");
        nombre=leer.readLine();
        
        C_Actividad actividad = new C_Actividad(nombre);
        
        return actividad;
        
    }
    
    public static C_Uso nuevoUso (BufferedReader leer) throws IOException {
        
        C_Uso uso;
        Date fecha;
        Time horaInicio,horaFin;
        
        System.out.println("Introducir fecha:");
        fecha=Date.valueOf(leer.readLine());
        System.out.println("Introducir hora de entrada:");
        horaInicio=Time.valueOf(leer.readLine());
        System.out.println("Introducir hora de salida:");
        horaFin=Time.valueOf(leer.readLine());

        uso=new C_Uso(fecha,horaInicio,horaFin);
        
        return uso;

    }
    
}
