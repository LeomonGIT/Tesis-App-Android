package pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.ConectorBD;
import pe.edu.ulima.tesis_app_android.services.ConectorBDInterface;
import pe.edu.ulima.tesis_app_android.services.GenerateData;
import pe.edu.ulima.tesis_app_android.services.VariablesGlobales;

public class SegundoTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ConectorBDInterface{

    List<Object> contents;

    //static final int TYPE_BUTTON = 0;
    static final int TYPE_GRAPH = 0;
    static final int TYPE_DATA = 1;

    public SegundoTabAdapter(List<Object> contents) {
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
                return TYPE_DATA;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        initializeData();

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

            case TYPE_DATA: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_table_tab2, parent, false);
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
            case TYPE_DATA:
                break;
            default:
                break;
        }
    }


    LineChartData data;
    //***** VISTA DEL GRAFICO *****
    VariablesGlobales global = new VariablesGlobales();
    private View setGraph(ViewGroup parent){
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
        LineChartView chart;
        int numberOfLines = 1;
        int maxNumberOfLines = 4;
        int numberOfPoints = 6;

        chart = (LineChartView) view1.findViewById(R.id.chartLine);


        List<AxisValue> axisX = new ArrayList<AxisValue>();
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            float[][] numberTabs = new GenerateData().getDataLineFromBI();
            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, numberTabs[i][j]));
                axisX.add(new AxisValue(j).setLabel(global.getDays()[j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i]);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            //line.setHasLabels(hasLabels);
            //line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            lines.add(line);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisY.setName("Horas");
            }
            data.setAxisXBottom(new Axis(axisX));
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);
        return view1;


    }
    ConectorBD conector;
    private void initializeData(){
        conector = new ConectorBD(this);
        conector.calledFromConector();
    }
    private void updateData(){
        initializeData();
    }
    private void updateGraph(){
        Log.e("btnUpdate", "actualizando...");
        /*for (int i=0;i< data.getLines().get(0).getValues().size();i++) {
            PointValue value=data.getLines().get(0).getValues().get(i);
            value.setTarget(ControllerTabs.getInstance().getArrayTab2().get(i).getDato());
        }
        chart.startDataAnimation();*/
    }

    @Override
    public void getDataFromBI(){
        updateGraph();
        //updateTable();
        Log.e("callBack", "finished");
    }

    //*************VISTA DE LOS DATOS***********

}