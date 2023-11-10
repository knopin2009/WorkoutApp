package com.example.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;
    public WorkoutDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view!=null){
            Workout workout = Workout.workouts[(int)workoutId];
            TextView textTitle = view.findViewById(R.id.textTitle);
            TextView textDescription = view.findViewById(R.id.textDescription);
            ImageView imageView = view.findViewById(R.id.imageWorkout);

            textTitle.setText(workout.getName());
            textDescription.setText(workout.getDescription());
            imageView.setImageResource(workout.getImageResourceId());
        }
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
