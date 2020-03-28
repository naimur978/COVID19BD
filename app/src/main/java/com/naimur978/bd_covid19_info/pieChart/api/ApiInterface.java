package com.naimur978.bd_covid19_info.pieChart.api;


import com.naimur978.bd_covid19_info.pieChart.model.PieStatistics;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android on 9/29/2017.
 */

public interface ApiInterface {

    @GET("countries/bangladesh")
    Call<PieStatistics> init();

}