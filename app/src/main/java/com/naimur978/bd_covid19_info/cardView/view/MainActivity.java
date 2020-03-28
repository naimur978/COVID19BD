package com.naimur978.bd_covid19_info.cardView.view;

//api source : https://corona.lmao.ninja/

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.naimur978.bd_covid19_info.cardView.viewmodel.CoronaServiceViewModel_All;
import com.naimur978.bd_covid19_info.R;
import com.naimur978.bd_covid19_info.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    CoronaServiceViewModel_All serviceViewModel_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.bottom_view);

        serviceViewModel_all = ViewModelProviders.of(this).get(CoronaServiceViewModel_All.class);


        observeViewModel(serviceViewModel_all);

    }


    private void observeViewModel(CoronaServiceViewModel_All serviceViewModel_all) {
        serviceViewModel_all.allServiceObserver().observe(this, all -> {

            if(all != null){
                activityMainBinding.setAll(all);
            }
        });
    }
}
