package pe.edu.ulima.tesis_app_android.ui.mainMenu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.SliceValue;
import pe.edu.ulima.tesis_app_android.R;
import pe.edu.ulima.tesis_app_android.ui.mainMenu.Adapter.PrimerTabAdapter;


public class ReportTabFragment extends Fragment implements PieChartOnValueSelectListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private static int position;
    private List<Object> mContentItems = new ArrayList<>();

    public static ReportTabFragment newInstance() {
        return new ReportTabFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_report_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        for (int i = 0; i < 3; ++i)
            mContentItems.add(new Object());

                mAdapter = new RecyclerViewMaterialAdapter(new PrimerTabAdapter(mContentItems));
        mRecyclerView.setAdapter(mAdapter);

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
    }

    @Override
    public void onValueSelected(int i, SliceValue sliceValue) {

    }

    @Override
    public void onValueDeselected() {

    }
}
