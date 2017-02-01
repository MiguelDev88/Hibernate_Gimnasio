package POJOS;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


// @author Miguel
 
public class C_Uso implements Serializable {
    
    private Date fecha;
    private Time horaInicio,horaFin;
    private C_Socio socio;
    
    
    public C_Uso(){}
    
    public C_Uso(Date fecha, Time horaInicio, Time horaFin){
        this.fecha=fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }
    
    public C_Uso (C_Socio socio, Date fecha, Time horaInicio){
        this.socio=socio;
        this.fecha=fecha;
        this.horaInicio=horaInicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public C_Socio getSocio() {
        return socio;
    }

    public void setSocio(C_Socio socio) {
        this.socio = socio;
    }
    
}
