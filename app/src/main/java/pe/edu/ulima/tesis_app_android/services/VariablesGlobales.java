package pe.edu.ulima.tesis_app_android.services;

public class VariablesGlobales {

    private static String[] titles={"Cant. Ventas Diarias","Tiempo entre ventas","Ventas segun Vendedor","Stock Perdido Mensual","Periodo mayor Venta"};
    private static String[] days = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
    private static String[] months = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
            "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    private static String[] color={"#2196f3","#f44336","#00bcd4","#795548","#4caf50","#607d8b"
            ,"#cddc39","#ffc107","#ffa726","#8d6e63","#b388ff","#e0e0e0"};

    public static String[] getTitles() {
        return titles;
    }

    public static void setTitles(String[] titles) {
        VariablesGlobales.titles = titles;
    }

    public static String[] getDays() {
        return days;
    }

    public static void setDays(String[] days) {
        VariablesGlobales.days = days;
    }

    public static String[] getMonths() {
        return months;
    }

    public static void setMonths(String[] months) {
        VariablesGlobales.months = months;
    }

    public static String[] getColor() {
        return color;
    }

    public static void setColor(String[] color) {
        VariablesGlobales.color = color;
    }
}
