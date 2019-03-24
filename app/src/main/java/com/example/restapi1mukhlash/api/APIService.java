package com.example.restapi1mukhlash.api;

import com.example.restapi1mukhlash.modelmatch.ResponseMatch;
import com.example.restapi1mukhlash.modelteam.ResponseTeam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponseTeam> getDataTeams();

    @GET("eventspastleague.php?id=4328")
    Call<ResponseMatch> getDataMatch();

}
