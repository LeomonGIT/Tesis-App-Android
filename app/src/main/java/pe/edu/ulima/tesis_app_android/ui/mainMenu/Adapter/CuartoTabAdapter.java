package pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.ConectorBD;
import pe.edu.ulima.tesis_app_android.services.ConectorBDInterface;
import pe.edu.ulima.tesis_app_android.services.VariablesGlobales;

public class CuartoTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ConectorBDInterface{

    List<Object> contents;

    //static final int TYPE_BUTTON = 0;
    static final int TYPE_GRAPH = 0;
    static final int TYPE_DATA = 1;
    static final int TYPE_CELL = 2;

    public CuartoTabAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_GRAPH;
            case 1:
                return TYPE_DATA;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        //dainitializeData();
        switch (viewType) {
            case TYPE_GRAPH:
            {
                view = setGraph(parent);

                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_DATA: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_table_tab4, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_GRAPH:
                break;
            case TYPE_DATA:
                break;
            default:
                break;
        }
    }


    //**************************VISTA DEL GRAFICO************************

    ColumnChartView chart;
    ColumnChartData data;
    VariablesGlobales global = new VariablesGlobales();
    private View setGraph(ViewGroup parent){
        View view1 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_graph_bar, parent, false);

        boolean hasAxes = true;
        boolean hasAxesNames = true;

        chart = (ColumnChartView) view1.findViewById(R.id.chartBar);
        List<AxisValue> axisX = new ArrayList<AxisValue>();
        int numSubcolumns = 1;
        int numColumns = 12;
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5,
                        Color.parseColor(global.getColor()[i])));

            }
            axisX.add(new AxisValue(i).setLabel(global.getMonths()[i]));
            Column column = new Column(values);
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(true);
            columns.add(column);
        }

        data = new ColumnChartData(columns);

        if (hasAxes) {
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisY.setName("Prom. Stock Perdido");
            }
            data.setAxisXBottom(new Axis(axisX).setName("MESES"));
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        chart.setColumnChartData(data);
        //boton actualizar
        final View vista = parent;
        ImageButton btnUpdate = (ImageButton) view1.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateData();
                updateGraph();
                Toast.makeText(vista.getContext(), "Actualizado", Toast.LENGTH_SHORT).show();

            }
        });
        return view1;

    }
    ConectorBD conector;
    private void initializeData(){
        conector = new ConectorBD(this);
        conector.getDataForTab4();
    }
    private void updateData(){
        initializeData();
    }
    private void updateGraph(){
        Log.e("btnUpdate", "actualizando...");
        for (Column column : data.getColumns()) {
            for (SubcolumnValue value : column.getValues()) {
                value.setTarget((float) Math.random() * 100);
            }
        }
        chart.startDataAnimation();
    }
    @Override
    public void getDataFromBI(){
        updateGraph();
        //updateTable();
        Log.e("callBack", "finished");
    }

    //**************************VISTA DE LOS DATOS************************

}