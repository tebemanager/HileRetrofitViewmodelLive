package com.image.hileretrofitviewmodellive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.image.hileretrofitviewmodellive.adapter.RecyclerviewAdapter;
import com.image.hileretrofitviewmodellive.module.ItemsItem;
import com.image.hileretrofitviewmodellive.viewmodel.ActivityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    RecyclerviewAdapter recyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        initData();

    }

    private void initRecyclerview(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewAdapter = new RecyclerviewAdapter();
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    private void initData(){
        ActivityViewModel activityViewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        activityViewModel.getLiveData().observe(this, new Observer<List<ItemsItem>>() {
            @Override
            public void onChanged(List<ItemsItem> itemsItems) {
                if (itemsItems != null){
                    recyclerviewAdapter.setItemList(itemsItems);
                }else {
                    Toast.makeText(MainActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        activityViewModel.makeApiCall();
    }
}