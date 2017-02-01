package funciones;
import POJOS.*;
import gimnasiomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel
 
public class Asociar {
    
    public static void asociarActividad (C_Gimnasio gimnasio, Session sesion, BufferedReader leer) throws IOException {
        
        C_Actividad actividad;
        String nombre;
        
        byte op=1;
        
        
        while(op!=0){
            
            Consultas.verActividades(sesion);
            
            System.out.println("¿Desea asociar una actividad nueva o una existente?"
                    + "\n1.Nueva"
                    + "\n2.Existente"
                    + "\n0.Finalizar");
            op=Byte.parseByte(leer.readLine());

            switch(op){
                case 1:
                    actividad=Altas.nuevaActividad(leer);
                    if(sesion.createQuery("FROM POJOS.C_Actividad a WHERE a.nombre='"+actividad.getNombre()+"'").uniqueResult()==null)
                    {
                        sesion.beginTransaction();
                        gimnasio.getActividades().add(actividad);
                        sesion.getTransaction().commit();
                        System.out.println("\n Actividad Asociada \n");
                    }
                    else
                        System.out.println(" \n Actividad ya existente en la BD \n");
                    break;
                case 2:
                    System.out.println("Introducir actividad a asociar:");
                    nombre=leer.readLine();
                    actividad=(C_Actividad)sesion.createQuery("FROM POJOS.C_Actividad a WHERE a.nombre='"+nombre+"'").uniqueResult();

                    if(actividad!=null)
                    {
                        if(gimnasio.getActividades().contains(actividad))
                            System.out.println("\n Actividad ya registrada en este gimnasio \n");
                        else
                        {
                            sesion.beginTransaction();
                            gimnasio.getActividades().add(actividad);
                            sesion.getTransaction().commit();
                            System.out.println("\n Actividad Asociada \n");
                        }
                    }
                    else
                        System.out.println("\n Actividad no encontrada \n");

                    break;
            }
        }
        
    }
    
    public static void asociarActividad (C_Socio socio, Session sesion, BufferedReader leer) throws IOException {
        
        C_Actividad actividad;
        String nombre="";

        
        while(nombre.compareToIgnoreCase("fin")!=0){
            
            Consultas.verActividades(sesion);
        
            System.out.println("Introducir actividad a asociar, teclee 'fin' para finalizar:");
            nombre=leer.readLine();

            actividad=(C_Actividad)sesion.createQuery("FROM POJOS.C_Actividad a WHERE a.nombre='"+nombre+"'").uniqueResult();

            if(actividad!=null)
            {
                if(socio.getActividades().contains(actividad))
                    System.out.println("\nActividad ya asociada a este cliente\n");
                else
                {
                    sesion.beginTransaction();
                    actividad.nuevoRegistro();
                    socio.getActividades().add(actividad);
                    sesion.getTransaction().commit();
                    System.out.println("\n Actividad Asociada \n");
                }
            }
            else
                System.out.println("\nActividad no encontrada \n");
            
        }

    }
    
    public static void asociarGimnasio (C_Socio socio, BufferedReader leer) throws IOException {
        
        C_Gimnasio gimnasio;
        String cif;
        Session sesion;
        
        Consultas.verGimnasios();
        
        System.out.println("Introducir cif del gimnasio al que pertence este cliente:");
        cif=leer.readLine();
        sesion=HibernateUtil.getSession();
        gimnasio=(C_Gimnasio)sesion.get(C_Gimnasio.class, cif);

        if(gimnasio!=null)
            socio.setGimnasio(gimnasio);
        else
            System.out.println("Gimnasio no encontrado.");

        sesion.close();
        
    }
    
    public static void asociarSocio (C_Uso uso, BufferedReader leer ) throws IOException {
        
        String dni;
        Session sesion;
        C_Socio socio;
        
        System.out.println("Introducir DNI del socio que entra:");
        dni=leer.readLine();
        sesion=HibernateUtil.getSession();
        socio=(C_Socio)sesion.get(C_Socio.class, dni);
        
        if(socio!=null)
            uso.setSocio(socio);
        else
            System.out.println("Socio no encontrado.");
        
    }
}
