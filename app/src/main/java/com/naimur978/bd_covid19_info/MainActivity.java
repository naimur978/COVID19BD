package com.naimur978.bd_covid19_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.naimur978.bd_covid19_info.api.ApiClient;
import com.naimur978.bd_covid19_info.api.ApiInterface;
import com.naimur978.bd_covid19_info.model.PieStatistics;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiCall();



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
        pieChartData.add(new Entry(pieStatistics.getCritical(), 3));



        PieDataSet dataSet = new PieDataSet(pieChartData, "Bangladesh");
        dataSet.setValueTextSize(14);


        /**
         *  set segment for pie chart
         */



        ArrayList pieChartSectionName = new ArrayList();
        pieChartSectionName.add("Deaths");
        pieChartSectionName.add("Recovered");
        pieChartSectionName.add("Active");
        pieChartSectionName.add("Critical");

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


}
