package com.naimur978.bd_covid19_info.PieChart.api;


import com.naimur978.bd_covid19_info.PieChart.model.PieStatistics;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android on 9/29/2017.
 */

public interface ApiInterface {

    @GET("bangladesh")
    Call<PieStatistics> init();

}