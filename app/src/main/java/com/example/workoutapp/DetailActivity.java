package com.example.workoutapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment frag;
        frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int id = (int)(long)getIntent().getExtras().get("POSITIONID");
        frag.setWorkoutId(id);

    }
}