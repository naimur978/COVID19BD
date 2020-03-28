package com.naimur978.bd_covid19_info.cardView.services.repository;


import com.naimur978.bd_covid19_info.cardView.services.model.All;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaServices {

    @GET("countries/bangladesh")
    Call<All> getAllInfo();


}
