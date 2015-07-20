package pe.edu.ulima.tesis_app_android.DAO;

/**
 * Created by Administrador on 13/07/2015.
 */
public class Tab3DAO {
    private String dia;
    private int dato;
    private double porcentaje;

    public Tab3DAO(String dia, int dato, double porcentaje) {
        this.dia = dia;
        this.dato = dato;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Tab3DAO{" +
                "dia='" + dia + '\'' +
                ", dato=" + dato +
                ", porcentaje=" + porcentaje +
                '}';
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
