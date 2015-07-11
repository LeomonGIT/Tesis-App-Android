package pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.GenerateData;

public class PrimerTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    //static final int TYPE_BUTTON = 0;
    static final int TYPE_GRAPH = 0;
    static final int TYPE_LABEL = 1;
    static final int TYPE_DATA = 2;
    static final int TYPE_CELL = 3;

    public PrimerTabAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_GRAPH;
            case 1:
                return TYPE_LABEL;
            case 2:
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


        switch (viewType) {
            /*case TYPE_BUTTON:{
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_options, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }*/

            case TYPE_GRAPH: {
                view = setGraph(parent);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_LABEL: {
                view =setLabels(parent);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_DATA: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_table_tab1, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }

        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            /*case TYPE_BUTTON:
                break;*/
            case TYPE_GRAPH:
                break;
            case TYPE_LABEL:
                break;
            case TYPE_DATA:
                break;
            default:
                break;
        }
    }


    List<SliceValue> values;
    ImageButton btnUpdate;
    PieChartData data;
    PieChartView chart;

    private View setGraph(ViewGroup parent){
                View view0 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_pie, parent, false);

                boolean hasLabels = true;
                boolean hasLabelsOutside = false;
                boolean hasCenterCircle = false;
                boolean hasCenterText1 = false;
                boolean hasCenterText2 = false;
                boolean isExploded = false;
                boolean hasLabelForSelected = false;

        chart = (PieChartView) view0.findViewById(R.id.chartPie);
        btnUpdate = (ImageButton) view0.findViewById(R.id.btnUpdatePie);

        if (hasLabels) {
            hasLabelForSelected = false;
            chart.setValueSelectionEnabled(hasLabelForSelected);
        }

                //chart.setOnValueTouchListener(new ValueTouchListener());
                values =new GenerateData().getDataPieFromBi();
                data = new PieChartData(values);
                data.setHasLabels(hasLabels);
                data.setHasLabelsOnlyForSelected(hasLabelForSelected);
                data.setHasLabelsOutside(hasLabelsOutside);
                data.setHasCenterCircle(hasCenterCircle);

                chart.setPieChartData(data);

        //boton actualizar
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUpdate();

            }
        });

        return view0;


    }

    private void btnUpdate(){
        Log.e("btnUpdate","actualizando...");
        for (SliceValue value : data.getValues()) {
            value.setTarget((float) Math.random() * 30 + 15);
        }
        chart.startDataAnimation();


    }
    private View setLabels(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_label_pie, parent, false);

        Button lunes = (Button) view.findViewById(R.id.colorLunes);
        Button martes = (Button) view.findViewById(R.id.colorMartes);
        Button miercoles = (Button) view.findViewById(R.id.colorMiercoles);
        Button jueves = (Button) view.findViewById(R.id.colorJueves);
        Button viernes = (Button) view.findViewById(R.id.colorViernes);
        Button sabado = (Button) view.findViewById(R.id.colorSabado);

        lunes.setBackgroundColor(values.get(0).getColor());
        martes.setBackgroundColor(values.get(1).getColor());
        miercoles.setBackgroundColor(values.get(2).getColor());
        jueves.setBackgroundColor(values.get(3).getColor());
        viernes.setBackgroundColor(values.get(4).getColor());
        sabado.setBackgroundColor(values.get(5).getColor());

        return view;
    }

}