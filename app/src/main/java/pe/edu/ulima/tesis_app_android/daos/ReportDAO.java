package pe.edu.ulima.tesis_app_android.daos;


public class ReportDAO {

    private int tipo;
    private String label;
    private String datos;

    public ReportDAO(int tipo, String label, String datos) {
        this.tipo = tipo;
        this.label = label;
        this.datos = datos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}


