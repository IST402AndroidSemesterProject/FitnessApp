package com.example.fitnessapplication402;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesGV = findViewById(R.id.idActivities);

        ArrayList<ActivityModel> activityModelArrayList = new ArrayList<ActivityModel>();
        activityModelArrayList.add(new ActivityModel("Steps", R.drawable.foot));
        activityModelArrayList.add(new ActivityModel("Distance", R.drawable.road));
        activityModelArrayList.add(new ActivityModel("Calories", R.drawable.flame));
        activityModelArrayList.add(new ActivityModel("Water", R.drawable.water));
        activityModelArrayList.add(new ActivityModel("Exercises", R.drawable.workout));
        activityModelArrayList.add(new ActivityModel("User Info", R.drawable.user));

        ActivityGVAdapter adapter = new ActivityGVAdapter(this, activityModelArrayList);
        coursesGV.setAdapter(adapter);
    }
}
