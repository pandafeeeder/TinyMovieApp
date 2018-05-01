package com.cb.project.gracefulmovies.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cb.project.gracefulmovies.model.OpenModel;
import com.cb.project.gracefulmovies.R;
import com.cb.project.gracefulmovies.model.OpenModel;
import com.cb.project.gracefulmovies.view.adapter.LicenseListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 开源许可
 * <p/>
 * Created by woxingxiao on 2017-02-14.
 */
public class OpenLicenseActivity extends BaseActivity {

    @BindView(com.cb.project.gracefulmovies.R.id.license_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cb.project.gracefulmovies.R.layout.activity_open_license);
        ButterKnife.bind(this);

        initializeToolbar();

        String[] libs = getResources().getStringArray(com.cb.project.gracefulmovies.R.array.libraries);
        String[] licenses = getResources().getStringArray(com.cb.project.gracefulmovies.R.array.licenses);
        List<OpenModel> list = new ArrayList<>();
        OpenModel openModel;
        for (int i = 0; i < libs.length; i++) {
            openModel = new OpenModel();
            openModel.setName(libs[i]);
            openModel.setLicense(licenses[i]);
            list.add(openModel);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new LicenseListAdapter(list));
    }
}
