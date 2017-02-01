package gimnasiomiguel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


// @author Miguel
 
public class CrearTablas {
    
    public static void crearTablas(){
        
        
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS GIMNASIO_MIGUEL");
            sentencia.execute("USE GIMNASIO_MIGUEL");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS gimnasios ( "
                    + "cif CHAR(9) NOT NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "direccion VARCHAR(45) NOT NULL, "
                    + "telefono CHAR(9) NOT NULL, "
                    + "PRIMARY KEY (cif))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS actividades ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "numSocios INT(3) NOT NULL, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS gimnasios_actividades ( "
                    + "gimnasio CHAR(9) NOT NULL, "
                    + "actividad INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY(gimnasio,actividad), "
                    + "INDEX fk_gimnasio1 (gimnasio), "
                    + "INDEX fk_actividad2 (actividad), "
                    + "CONSTRAINT fk_gimnasio1 "
                    + " FOREIGN KEY(gimnasio) REFERENCES gimnasios(cif) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "CONSTRAINT fk_actividad2 "
                    + " FOREIGN KEY(actividad) REFERENCES actividades(id) "
                    + " ON DELETE CASCADE "
                    + " ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS socios ( "
                    + "dni CHAR(9) NOT NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "telefono CHAR(9) NOT NULL, "
                    + "cuota DOUBLE NOT NULL, "
                    + "gimnasio CHAR(9) NOT NULL, "
                    + "PRIMARY KEY (dni), "
                    + "INDEX fk_gimnasio2 (gimnasio), "
                    + "CONSTRAINT fk_gimnasio2 "
                    + " FOREIGN KEY(gimnasio) REFERENCES gimnasios(cif) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS socios_actividades ( "
                    + "socio CHAR(9) NOT NULL, "
                    + "actividad INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY(socio,actividad), "
                    + "INDEX fk_socio1 (socio), "
                    + "INDEX fk_actividad1 (actividad), "
                    + "CONSTRAINT fk_socio1 "
                    + " FOREIGN KEY(socio) REFERENCES socios(dni) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "CONSTRAINT fk_actividad1 "
                    + " FOREIGN KEY(actividad) REFERENCES actividades(id) "
                    + "  ON DELETE CASCADE"
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS usos ( "
                    + "socio CHAR(9) NOT NULL, "
                    + "fecha DATE NOT NULL, "
                    + "horaInicio TIME NOT NULL, "
                    + "horaFin TIME NOT NULL, "
                    + "PRIMARY KEY(socio,fecha,horaInicio), "
                    + "CONSTRAINT fk_socio2 "
                    + " FOREIGN KEY(socio) REFERENCES socios(dni) "
                    + "  ON DELETE CASCADE"
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            System.out.println("\n - BASE DE DATOS LISTA - \n");
                    

            conexion.close();
            
            
        }catch(Exception e) {
            System.out.println("\n - ERROR DE CONEXION CON LA BASE DE DATOS - \n");
            System.exit(0);
        }
    }
}
