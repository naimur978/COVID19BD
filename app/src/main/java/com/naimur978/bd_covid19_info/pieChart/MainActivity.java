package com.naimur978.bd_covid19_info.pieChart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.fivemin.chief.nonetworklibrary.networkBroadcast.NoNet;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.naimur978.bd_covid19_info.cardView.viewmodel.CoronaServiceViewModel_All;
import com.naimur978.bd_covid19_info.databinding.ActivityMainBinding;
import com.naimur978.bd_covid19_info.pieChart.api.ApiClient;
import com.naimur978.bd_covid19_info.pieChart.api.ApiInterface;
import com.naimur978.bd_covid19_info.pieChart.model.PieStatistics;
import com.naimur978.bd_covid19_info.R;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ApiInterface apiInterface;

    ActivityMainBinding activityMainBinding;
    CoronaServiceViewModel_All serviceViewModel_all;

    private FragmentManager fm = null;
    private NoNet mNoNet;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fm = getSupportFragmentManager();
        mNoNet = new NoNet();
        mNoNet.initNoNet(this, fm);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);




                        serviceViewModel_all = ViewModelProviders.of(MainActivity.this)
                                .get(CoronaServiceViewModel_All.class);

                        observeViewModel(serviceViewModel_all);


                        apiInterface = ApiClient.getClient().create(ApiInterface.class);
                        apiCall();

                    }







    private void observeViewModel(CoronaServiceViewModel_All serviceViewModel_all) {
        serviceViewModel_all.allServiceObserver().observe(this, all -> {

            if(all != null){
                activityMainBinding.setAll(all);
            }
        });
    }


    /**
     *  Api call for retriving data for pie chart
     */
    private void apiCall() {
        Call<PieStatistics> pieStatisticsCall = apiInterface.init();
        pieStatisticsCall.enqueue(new Callback<PieStatistics>() {
            @Override
            public void onResponse(Call<PieStatistics> call, Response<PieStatistics> response) {
                setData(response.body());
            }

            @Override
            public void onFailure(Call<PieStatistics> call, Throwable t) {

            }
        });
    }


    /**
     *  Set Data Into the pie chart
     * @param pieStatistics
     */

    private void setData(PieStatistics pieStatistics) {

        PieChart pieChartList = findViewById(R.id.piechart);


        /**
         *  get Data for pie chart
         */

        ArrayList pieChartData = new ArrayList();
        pieChartData.add(new Entry(pieStatistics.getDeaths(), 0));
        pieChartData.add(new Entry(pieStatistics.getRecovered(), 1));
        pieChartData.add(new Entry(pieStatistics.getActive(), 2));




        PieDataSet dataSet = new PieDataSet(pieChartData, "");
        dataSet.setValueTextSize(14);


        /**
         *  set segment for pie chart
         */



        ArrayList pieChartSectionName = new ArrayList();
        pieChartSectionName.add("Deaths");
        pieChartSectionName.add("Recovered");
        pieChartSectionName.add("Active");


        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        PieData data = new PieData(pieChartSectionName, dataSet);
        pieChartList.setData(data);




        /**
         *  Segment color added into the pie chart
         */



      /*  dataSet.setColors(new int[]{
                Color.parseColor("#515E56"),
                Color.parseColor("#ef5350"),
                Color.parseColor("#3721A5"),
                Color.parseColor("#25A85A")});*/



        pieChartList.animateXY(500, 500);



    }

    @Override
    protected void onResume() {
        mNoNet.RegisterNoNet();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mNoNet.unRegisterNoNet();
        super.onPause();
    }


}
