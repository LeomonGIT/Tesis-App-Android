package pe.edu.ulima.tesis_app_android.services;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class GenerateData {

    //logica usar data del webservice BI

    public List<SliceValue> getDataPieFromBi(){
        List<SliceValue> values = new ArrayList<SliceValue>();

        int numValues = 6;

        for (int i = 0; i < numValues; ++i) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15, ChartUtils.pickColor());
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


}
