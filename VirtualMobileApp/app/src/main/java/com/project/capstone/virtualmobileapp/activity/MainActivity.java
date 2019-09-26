package com.project.capstone.virtualmobileapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.project.capstone.virtualmobileapp.R;
import com.project.capstone.virtualmobileapp.model.Item;
import com.project.capstone.virtualmobileapp.remote.RmaAPIService;
import com.project.capstone.virtualmobileapp.utils.RmaAPIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RmaAPIService rmaAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rmaAPIService = RmaAPIUtils.getAPIService();
        rmaAPIService.getAll().enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                System.out.println("ra rồi");
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                System.out.println("fail rồi: " + t.getMessage());


            }
        });
    }
}
