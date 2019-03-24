package com.example.restapi1mukhlash.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.restapi1mukhlash.DetailTeamActivity;
import com.example.restapi1mukhlash.modelteam.TeamsItem;
import com.example.restapi1mukhlash.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    Context context;
    List<TeamsItem> data;

    public TeamAdapter(Context context, List<TeamsItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.team_viewholder, null);
        return new TeamViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder matchViewHolder, final int i) {

        matchViewHolder.tvTeam.setText(data.get(i).getStrTeam());
        Picasso.get().load(data.get(i).getStrTeamBadge()).into(matchViewHolder.imgTeam);
        matchViewHolder.lnTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(context, DetailTeamActivity.class);
                move.putExtra("a", data.get(i).getStrDescriptionEN());
                move.putExtra("b", data.get(i).getStrTeamBadge());
                context.startActivity(move);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTeam;
        TextView tvTeam;
        LinearLayout lnTeam;

        public TeamViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            imgTeam = itemView.findViewById(R.id.img_team);
            tvTeam = itemView.findViewById(R.id.tv_team);
            lnTeam = itemView.findViewById(R.id.ln_team);

        }
    }
}
