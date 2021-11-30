package com.example.fitnessapplication402;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class DetermineActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        if(imageAdapter.mThumbIds[position] == 1){
            setContentView(R.layout.steps_counter);
        }
        else{
            setContentView(R.layout.steps_counter);
            System.out.println(imageAdapter.mThumbIds[position]); //Look into mem address reference 2131165287
        }
    }
}