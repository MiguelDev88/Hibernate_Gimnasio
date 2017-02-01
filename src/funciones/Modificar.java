package funciones;
import POJOS.C_Gimnasio;
import POJOS.C_Socio;
import gimnasiomiguel.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;


// @author Miguel
 
public class Modificar {
    
    public static void modificar (BufferedReader leer) throws IOException {
        
        byte op=1;
        String cif,dni;
        Session sesion;
        C_Gimnasio gimnasio;
        C_Socio socio;
        
        
        try{
            while(op!=0){
                op=Menu.menuAltas(leer);
                switch(op){
                    case 1:
                        System.out.println("Introducir cif del Gimnasio a modificar:");
                        cif=leer.readLine();
                        sesion=HibernateUtil.getSession();
                        gimnasio=(C_Gimnasio)sesion.get(C_Gimnasio.class, cif);

                        if(gimnasio!=null){

                            sesion.beginTransaction();
                            modificarGimnasio(gimnasio, leer);
                            sesion.getTransaction().commit();

                        }else
                            System.out.println("Gimnasio no encontrado");

                        sesion.close();
                        break;
                    case 2:
                        System.out.println("Introducir dni del Socio a modificar:");
                        dni=leer.readLine();
                        sesion=HibernateUtil.getSession();
                        socio=(C_Socio)sesion.get(C_Socio.class, dni);

                        if(socio!=null){

                            sesion.beginTransaction();
                            modificarSocio(socio, leer);
                            sesion.getTransaction().commit();

                        }else
                            System.out.println("Socio no encontrado");

                        sesion.close();
                        break;
                }
            }
            
        }catch(Exception e){
                System.out.println("\n - Error en la modificación - \n");
                }

    }
    
    public static void modificarGimnasio (C_Gimnasio gimnasio, BufferedReader leer) throws IOException {
        
        byte op;
        String direccion,telefono;
        
        System.out.println("¿Qué desea modificar?"
                + "\n1.Dirección"
                + "\n2.Teléfono"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        switch(op){
            case 1:
                System.out.println("Introducir nueva dirección:");
                direccion=leer.readLine();
                gimnasio.setDireccion(direccion);
                break;
            case 2:
                System.out.println("Introducir nuevo teléfono:");
                telefono=leer.readLine();
                gimnasio.setTelefono(telefono);
                break;
        }
    }
    
    public static void modificarSocio (C_Socio socio, BufferedReader leer) throws IOException {
        
        byte op;
        String telefono;
        double cuota;
        
        System.out.println("¿Qué desea modificar?"
                + "\n1.Cuota"
                + "\n2.Teléfono"
                + "\n0.Finalizar");
        op=Byte.parseByte(leer.readLine());
        
        switch(op){
            case 1:
                System.out.println("Introducir nueva cuota:");
                cuota=Double.parseDouble(leer.readLine());
                socio.setCuota(cuota);
                break;
            case 2:
                System.out.println("Introducir nuevo teléfono:");
                telefono=leer.readLine();
                socio.setTelefono(telefono);
                break;
        }
    }
    
}
