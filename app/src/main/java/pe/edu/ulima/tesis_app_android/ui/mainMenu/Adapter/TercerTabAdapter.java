package pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.BubbleChartView;
import pe.edu.ulima.tesis_app_android.DAO.Tab3DAO;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.services.ConectorBD;
import pe.edu.ulima.tesis_app_android.services.ConectorBDInterface;
import pe.edu.ulima.tesis_app_android.services.ControllerTabs;
import pe.edu.ulima.tesis_app_android.services.VariablesGlobales;

public class TercerTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ConectorBDInterface{

    List<Object> contents;

    //static final int TYPE_BUTTON = 0;
    static final int TYPE_GRAPH = 0;
    static final int TYPE_LABEL = 1;
    static final int TYPE_DATA = 2;
    static final int TYPE_CELL = 3;

    public TercerTabAdapter(List<Object> contents) {
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

            case TYPE_LABEL: {
                view = setLabels(parent);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_DATA: {
                viewTable = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_table_tab3, parent, false);
                return new RecyclerView.ViewHolder(viewTable) {
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

    //******VISTA DEL GRAFICO**************
    private BubbleChartData data;
    List<BubbleValue> values ;
            VariablesGlobales global = new VariablesGlobales();
    BubbleChartView chart;
    private View setGraph(ViewGroup parent){
        View view1 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_graph_buble, parent, false);

         boolean hasAxes = true;
         boolean hasAxesNames = true;
         ValueShape shape = ValueShape.CIRCLE;
         boolean hasLabels = false;
         boolean hasLabelForSelected = false;

        chart = (BubbleChartView) view1.findViewById(R.id.chartBuble);
        int BUBBLES_NUM = 4;
        //float[][] data= getDataBubleFromBI();
        values = new ArrayList<>();
        List<AxisValue> axisX = new ArrayList<AxisValue>();
        for (int i = 0; i < BUBBLES_NUM; ++i) {
            //BubbleValue value = new BubbleValue(i, data[i][0], data[i][1]);
            BubbleValue value = new BubbleValue(i, (float) Math.random() * 100, (float) Math.random() * 1000);
            value.setColor(Color.parseColor(global.getColor()[i]));
            value.setShape(shape);
            values.add(value);
            //axisX.add(new AxisValue(i).setLabel(vendedor[i]));
            //axisX.add(new AxisValue(i));
        }
        data = new BubbleChartData(values);
        data.setHasLabels(hasLabels);
        data.setHasLabelsOnlyForSelected(hasLabelForSelected);

        if (hasAxes) {
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisY.setName("MONTO DE VENTAS");
            }
            data.setAxisXBottom(new Axis(axisX).setName("VENDEDOR"));
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        chart.setBubbleChartData(data);
        //boton actualizar
        final View vista = parent;
        ImageButton btnUpdate = (ImageButton) view1.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Toast.makeText(vista.getContext(), "Actualizado", Toast.LENGTH_SHORT).show();

            }
        });
        //boton Editar
        ImageButton btnEdit = (ImageButton) view1.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateData();
                Toast.makeText(vista.getContext(), "Proximamente.", Toast.LENGTH_SHORT).show();

            }
        });
        return view1;

    }
    ConectorBD conector;
    private void initializeData(){
        conector = new ConectorBD(this);
        conector.getDataForTab3();
    }

    private void updateData(){
        initializeData();
    }

    private void updateGraph(){
        Log.e("btnUpdate", "actualizando...");
        for (BubbleValue value : data.getValues()) {
            value.setTarget(value.getX() + (float) Math.random() * 4 * getSign(), (float) Math.random() * 100,
                    (float) Math.random() * 1000);
        }
        chart.startDataAnimation();
    }

    private int getSign() {
        int[] sign = new int[]{-1, 1};
        return sign[Math.round((float) Math.random())];
    }

    @Override
    public void getDataFromBI(){
        updateGraph();
        updateTable();
        Log.e("callBack", "finished");
    }
    ////************************************** LABEL CARD ******************
    private View setLabels(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_label_bubble, parent, false);

        Button A = (Button) view.findViewById(R.id.colorA);
        Button B = (Button) view.findViewById(R.id.colorB);
        Button C = (Button) view.findViewById(R.id.colorC);
        Button D = (Button) view.findViewById(R.id.colorD);

        A.setBackgroundColor(values.get(0).getColor());
        B.setBackgroundColor(values.get(1).getColor());
        C.setBackgroundColor(values.get(2).getColor());
        D.setBackgroundColor(values.get(3).getColor());

        return view;
    }
    //******VISTA DE LOS DATOS**************
    View viewTable;
    private void updateTable() {
        TextView dataVendorA = (TextView) viewTable.findViewById(R.id.dataVendorA);
        TextView dataVendorB = (TextView) viewTable.findViewById(R.id.dataVendorB);
        TextView dataVendorC = (TextView) viewTable.findViewById(R.id.dataVendorC);
        TextView dataVendorD = (TextView) viewTable.findViewById(R.id.dataVendorD);
        TextView dataVendorAPorcentaje = (TextView) viewTable.findViewById(R.id.dataVendorAPorcentaje);
        TextView dataVendorBPorcentaje = (TextView) viewTable.findViewById(R.id.dataVendorBPorcentaje);
        TextView dataVendorCPorcentaje = (TextView) viewTable.findViewById(R.id.dataVendorCPorcentaje);
        TextView dataVendorDPorcentaje = (TextView) viewTable.findViewById(R.id.dataVendorDPorcentaje);

        ArrayList<Tab3DAO> data = ControllerTabs.getInstance().getArrayTab3();
        dataVendorA.setText(""+data.get(0).getDato());
        dataVendorB.setText(""+data.get(1).getDato());
        dataVendorC.setText(""+data.get(2).getDato());
        dataVendorD.setText("" + data.get(3).getDato());
        DecimalFormat df = new DecimalFormat("##.##");
        dataVendorAPorcentaje.setText("" + df.format(data.get(0).getPorcentaje()));
        dataVendorBPorcentaje.setText("" + df.format(data.get(1).getPorcentaje()));
        dataVendorCPorcentaje.setText("" + df.format(data.get(2).getPorcentaje()));
        dataVendorDPorcentaje.setText("" + df.format(data.get(3).getPorcentaje()));
    }
}