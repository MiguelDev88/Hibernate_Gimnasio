package funciones;
import POJOS.*;
import gimnasiomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel
 
public class Bajas {
    
    public static void bajas (BufferedReader leer) throws IOException {
        
        byte op=1;

        while(op!=0){
            op=Menu.menuBajas(leer);
            switch(op){
                case 1:
                    bajaGimnasio(leer);
                    break;
                case 2:
                    bajaActividad(leer);
                    break;
                case 3:
                    bajaSocio(leer);
                    break;
            }
        }  
    }
    
    public static void bajaGimnasio (BufferedReader leer) throws IOException {
        
        String cif;
        Session sesion;
        C_Gimnasio gimnasio;
        
        System.out.println("Introducir CIF del gimnasio a dar de baja:");
        cif=leer.readLine();
        
        try{
            sesion=HibernateUtil.getSession();
            gimnasio=(C_Gimnasio)sesion.get(C_Gimnasio.class, cif);
            if(gimnasio!=null){

                if(Menu.menuConfirmar(leer)==1)
                {
                    sesion.beginTransaction();
                    sesion.delete(gimnasio);
                    sesion.getTransaction().commit();
                    System.out.println("\n Gimnasio eliminado \n");
                }

            }else
                System.out.println("\n Gimnasio no encontrado \n");

            sesion.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void bajaActividad (BufferedReader leer) throws IOException {
        
        String nombre;
        Session sesion;
        C_Actividad actividad;
        
        System.out.println("Introducir nombre de la actividad a dar de baja:");
        nombre=leer.readLine();
        
        
        try{
            sesion=HibernateUtil.getSession();
            actividad=(C_Actividad)sesion.createQuery("FROM POJOS.C_Actividad a WHERE a.nombre='"+nombre+"'").uniqueResult();

            if(actividad!=null){

                if(Menu.menuConfirmar(leer)==1)
                {
                    sesion.beginTransaction();
                    sesion.delete(actividad);
                    sesion.getTransaction().commit();
                    System.out.println("\n Actividad eliminada \n");
                }

            }else
                System.out.println("\n Actividad no encontrada \n");

            sesion.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void bajaSocio (BufferedReader leer) throws IOException {
        
        String dni;
        Session sesion;
        C_Socio socio;
        
        System.out.println("Introducir DNI del socio a dar de baja:");
        dni=leer.readLine();
        
        try{
        
            sesion=HibernateUtil.getSession();
            socio=(C_Socio)sesion.get(C_Socio.class, dni);

            if(socio!=null){

                if(Menu.menuConfirmar(leer)==1)
                {
                    sesion.beginTransaction();
                    sesion.delete(socio);
                    sesion.getTransaction().commit();
                    System.out.println("\n Socio eliminado \n");
                }

            }else
                System.out.println("\n Socio no encontrado \n");

            sesion.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
