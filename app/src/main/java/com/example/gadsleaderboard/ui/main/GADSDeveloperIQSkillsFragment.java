package com.example.gadsleaderboard.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gadsleaderboard.GADSDeveloperIqSkillsDataAdapter;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class GADSDeveloperIQSkillsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<GADSDevelopersIqSkillsModel> data;
    private GADSDeveloperIqSkillsDataAdapter adapter;
    Context context;

    private static final String ARG_SECTION_NUMBER = "section_number";



     public static GADSDeveloperIQSkillsFragment newInstance(int index) {
        GADSDeveloperIQSkillsFragment fragment = new GADSDeveloperIQSkillsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView)root.findViewById(R.id.GADRecycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();


        return root;
    }




    private void loadJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);

        Call<List<GADSDevelopersIqSkillsModel>> call = request.getJSONSkillsIQ();
        call.enqueue(
                new Callback<List<GADSDevelopersIqSkillsModel>>(){

                    @Override
                    public void onResponse(Call<List<GADSDevelopersIqSkillsModel>> call, Response<List<GADSDevelopersIqSkillsModel>> response) {

                        data = new ArrayList<>(response.body());
                        adapter = new GADSDeveloperIqSkillsDataAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<GADSDevelopersIqSkillsModel>> call, Throwable t) {
                        Log.d("Error",t.getMessage());
                    }
                }
        );
    }
}