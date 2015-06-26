package pe.edu.ulima.tesis_app_android.services;

public class Services {

    private String[] titles={"Reporte","Reporte","Reporte","Reporte","Reporte"};

    public String[] getTitle(){
        return titles;
    }

    public void setTitle(int position,String title){
        titles[position] = title;
    }
}
