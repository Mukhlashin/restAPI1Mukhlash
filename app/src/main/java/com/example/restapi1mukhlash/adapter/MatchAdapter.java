package com.example.restapi1mukhlash.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi1mukhlash.R;
import com.example.restapi1mukhlash.modelmatch.EventsItem;
import com.example.restapi1mukhlash.modelteam.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    Context context;
    List<EventsItem> data;

    public MatchAdapter(Context context, List<EventsItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.match_viewholder, null);
        return new MatchAdapter.MatchViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int i) {
        matchViewHolder.tvHome.setText(data.get(i).getStrHomeTeam());
        matchViewHolder.tvAway.setText(data.get(i).getStrAwayTeam());
        matchViewHolder.tvScoreHome.setText(data.get(i).getIntHomeScore());
        matchViewHolder.tvScoreAway.setText(data.get(i).getIntAwayScore());

        Picasso.get().load(data.get(i).getStrThumb()).into(matchViewHolder.imgHome);
    }
    
//     ncuein qwx whs hallo bdeiuq dcen  saya swudb q

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvHome, tvScoreHome, tvAway, tvScoreAway;
        ImageView imgHome, imgAway;
        public MatchViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            tvHome = itemView.findViewById(R.id.tv_home);
            tvScoreHome = itemView.findViewById(R.id.tv_scorehome);
            tvAway = itemView.findViewById(R.id.tv_away);
            tvScoreAway = itemView.findViewById(R.id.tv_scoreaway);

            imgHome = itemView.findViewById(R.id.img_home);
        }
    }
}
