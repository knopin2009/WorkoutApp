package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    public static final String TAG="AppWorkoutFragments";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {

        Log.d(TAG, "itemClicked: " + id);

        View fragmentContainer = findViewById(R.id.fragment_container);

        if (fragmentContainer != null) {

            WorkoutDetailFragment detailFragment = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            detailFragment.setWorkoutId(id);
            ft.replace(R.id.fragment_container, detailFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("POSITIONID", id);
            startActivity(intent);
        }
    }
}