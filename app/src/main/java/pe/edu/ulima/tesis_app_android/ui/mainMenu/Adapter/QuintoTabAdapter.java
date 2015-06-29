package pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.PieChartView;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.GenerateData;

public class QuintoTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;
    static int position;

    //static final int TYPE_BUTTON = 0;
    static final int TYPE_GRAPH = 0;
    static final int TYPE_LABEL = 1;
    static final int TYPE_DATA = 2;
    static final int TYPE_CELL = 3;

    public QuintoTabAdapter(List<Object> contents) {
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
                view = setGraphByTab(0,parent);

                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_LABEL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_label, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_DATA: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_datos, parent, false);
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


    private View setGraphByTab(int posTab,ViewGroup parent){

        switch (posTab){
            case 0:
                View view0 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_pie, parent, false);

                boolean hasLabels = false;
                boolean hasLabelsOutside = false;
                boolean hasCenterCircle = false;
                boolean hasCenterText1 = false;
                boolean hasCenterText2 = false;
                boolean isExploded = false;
                boolean hasLabelForSelected = false;
                PieChartView chart;
                PieChartData data;

                chart = (PieChartView) view0.findViewById(R.id.chartPie);

                //chart.setOnValueTouchListener(new ValueTouchListener());

                data = new PieChartData(new GenerateData().getDataPieFromBi());
                data.setHasLabels(hasLabels);
                data.setHasLabelsOnlyForSelected(hasLabelForSelected);
                data.setHasLabelsOutside(hasLabelsOutside);
                data.setHasCenterCircle(hasCenterCircle);

                chart.setPieChartData(data);
                return view0;
            case 1:
                View view1 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_line, parent, false);

                 boolean hasAxes = true;
                 boolean hasAxesNames = true;
                 boolean hasLines = true;
                 boolean hasPoints = true;
                 ValueShape shape = ValueShape.CIRCLE;
                 boolean isFilled = false;
                 boolean hasLabels1 = false;
                 boolean isCubic = false;
                 boolean hasLabelForSelected1 = false;

                return view1;
            case 2:
                View view2 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_bar, parent, false);

                return view2;
            case 3:
                View view3 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_buble, parent, false);

                return view3;
            case 4:
                View view4 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_dependency, parent, false);

                return view4;
            default:
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_graph_bar, parent, false);

                return view;


        }

    }


}