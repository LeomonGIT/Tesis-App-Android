package pe.edu.ulima.tesis_app_android.services;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class GenerateData {

    //logica usar data del webservice BI

    private String[] color={"#2196f3","#f44336","#00bcd4","#795548","#4caf50","#607d8b"};

    public List<SliceValue> getDataPieFromBi(){
        List<SliceValue> values = new ArrayList<SliceValue>();

        int numValues = 6;

        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15);
            sliceValue.setColor(Color.parseColor(color[i]));
            values.add(sliceValue);
        }
        //
        return values;

    }

    public float[][] getDataLineFromBI(){

        int numberOfPoints = 12;
        int maxNumberOfLines = 4;
        float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }
        return randomNumbersTab;
    }

    public List<BubbleValue> getDataBubleFromBI(){
        int BUBBLES_NUM = 8;

        ValueShape shape = ValueShape.CIRCLE;
        List<BubbleValue> values = new ArrayList<BubbleValue>();
        for (int i = 0; i < BUBBLES_NUM; ++i) {
            BubbleValue value = new BubbleValue(i, (float) Math.random() * 100, (float) Math.random() * 1000);
            value.setColor(ChartUtils.pickColor());
            value.setShape(shape);
            values.add(value);
        }

        return values;
    }


    public List<Column> getDataBarFromBI() {

        int numSubcolumns = 1;
        int numColumns = 8;
        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<SubcolumnValue>();
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
            }

            Column column = new Column(values);
            column.setHasLabels(true);
            column.setHasLabelsOnlyForSelected(true);
            columns.add(column);
        }
        return columns;
    }
}
