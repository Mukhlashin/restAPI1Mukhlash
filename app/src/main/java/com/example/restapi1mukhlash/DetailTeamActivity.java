package com.example.restapi1mukhlash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailTeamActivity extends AppCompatActivity {

    TextView tvDetailTeam;
    ImageView imgDetailTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        tvDetailTeam = findViewById(R.id.tv_detail_team);
        imgDetailTeam = findViewById(R.id.img_detail_team);

        Picasso.get().load(getIntent().getStringExtra("b")).into(imgDetailTeam);
        tvDetailTeam.setText(getIntent().getStringExtra("a"));

    }
}
