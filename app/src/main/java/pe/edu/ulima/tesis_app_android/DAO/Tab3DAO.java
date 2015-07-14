package pe.edu.ulima.tesis_app_android.DAO;

/**
 * Created by Administrador on 13/07/2015.
 */
public class Tab3DAO {
    private String dia;
    private int dato;

    public Tab3DAO(int dato, String dia) {
        this.dia = dia;
        this.dato = dato;
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

    @Override
    public String toString() {
        return "Tab3DAO{" +
                "dia='" + dia + '\'' +
                ", dato=" + dato +
                '}';
    }
}
