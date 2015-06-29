package pe.edu.ulima.tesis_app_android.services;

public class Services {

    private String[] titles={"Ventas Diarias","Perdidas Mensuales","Cantidad Productos Vendidos","Monto Ganado","Dias mayor Venta"};

    public String[] getTitle(){
        return titles;
    }

    public void setTitle(int position,String title){
        titles[position] = title;
    }
}
