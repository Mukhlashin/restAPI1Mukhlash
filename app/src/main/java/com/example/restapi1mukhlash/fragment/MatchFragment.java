package com.example.restapi1mukhlash.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi1mukhlash.R;
import com.example.restapi1mukhlash.adapter.MatchAdapter;
import com.example.restapi1mukhlash.adapter.TeamAdapter;
import com.example.restapi1mukhlash.api.ConfigRetrofit;
import com.example.restapi1mukhlash.modelmatch.EventsItem;
import com.example.restapi1mukhlash.modelmatch.ResponseMatch;
import com.example.restapi1mukhlash.modelteam.ResponseTeam;
import com.example.restapi1mukhlash.modelteam.TeamsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {

    RecyclerView rvMatch;
    MatchAdapter adapter;
    List<EventsItem> data;

    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.match_fragment, container, false);
        rvMatch = layout.findViewById(R.id.rv_match);
        rvMatch.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        getDataMatch();
        return layout;
    }

    private void getDataMatch() {
        ConfigRetrofit.getInstance().getDataMatch().enqueue(new Callback<ResponseMatch>() {
            @Override
            public void onResponse(Call<ResponseMatch> call, Response<ResponseMatch> response) {
                if (response.isSuccessful()) {
                    data = response.body().getEvents();
                    adapter = new MatchAdapter(getActivity(),data);
                    rvMatch.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvMatch.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseMatch> call, Throwable t) {

            }
        });
    }
}