package com.example.restapi1mukhlash.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi1mukhlash.api.ConfigRetrofit;
import com.example.restapi1mukhlash.adapter.TeamAdapter;
import com.example.restapi1mukhlash.modelteam.ResponseTeam;
import com.example.restapi1mukhlash.modelteam.TeamsItem;
import com.example.restapi1mukhlash.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {

    RecyclerView rvTeam;
    TeamAdapter adapter;
    List<TeamsItem> data;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.team_fragment, container, false);
        rvTeam = layout.findViewById(R.id.rv_team);
        rvTeam.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        getDataTeams();
        return layout;


    }

    private void getDataTeams() {
        ConfigRetrofit.getInstance().getDataTeams().enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new TeamAdapter(getActivity(),data);
                    rvTeam.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvTeam.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {

            }
        });

    }
}

