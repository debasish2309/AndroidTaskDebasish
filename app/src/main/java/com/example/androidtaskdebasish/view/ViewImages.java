package com.example.androidtaskdebasish.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.androidtaskdebasish.R;
import com.example.androidtaskdebasish.adapter.RecyclerAdapter;
import com.example.androidtaskdebasish.model.DataClass;
import com.example.androidtaskdebasish.model.Image;
import com.example.androidtaskdebasish.model.Item;
import com.example.androidtaskdebasish.rest.ApiClient;
import com.example.androidtaskdebasish.rest.ApiInterface;
import com.example.androidtaskdebasish.viewmodel.ActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewImages extends AppCompatActivity {

    ArrayList<Image> imageList = new ArrayList<>();
    ActivityViewModel activityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_images);

        String search_element = getIntent().getStringExtra("SEARCHELEMENT");
        Log.d("!!!searchelement",search_element);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(ViewImages.this,2));

        activityViewModel = ViewModelProviders.of(ViewImages.this).get(ActivityViewModel.class);

        activityViewModel.init(search_element);

        activityViewModel.getImageRepository().observe(ViewImages.this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                Log.d("!!!items",String.valueOf(items.size()));
                for(int i = 0 ; i < items.size() ; i++) {
                    imageList.add(new Image(items.get(i).getImage().getContextLink()));
                    Log.d("!!!imageList",items.get(i).getImage().getContextLink());
                }
                recyclerView.setAdapter(new RecyclerAdapter(ViewImages.this,imageList));
            }
        });

    }
}
