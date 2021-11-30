package com.example.fitnessapplication402;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;



public class DetermineActivity extends Activity implements SensorEventListener, StepListener{
    private TextView textView;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    private TextView TvSteps;
    private Button BtnStart;
    private Button BtnStop;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        if(imageAdapter.mThumbIds[position] == 2131165287){ // Opens Step Counter
            setContentView(R.layout.steps_counter);

            // Get an instance of the SensorManager
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            simpleStepDetector = new StepDetector();
            simpleStepDetector.registerListener(this);

            // Finds the buttons in the steps_counter.xml file
            TvSteps = (TextView) findViewById(R.id.tv_steps);
            BtnStart = (Button) findViewById(R.id.btn_start);
            BtnStop = (Button) findViewById(R.id.btn_stop);

            // Creates the Listener for the start and stop buttons

            BtnStart.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    numSteps = 0;
                    sensorManager.registerListener(DetermineActivity.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

                }
            });

            BtnStop.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    sensorManager.unregisterListener(DetermineActivity.this);

                }
            });

        }
        else if(imageAdapter.mThumbIds[position] == 2131165329){ // Opens Distance



        }
        else if(imageAdapter.mThumbIds[position] == 2131165334) { // Water Intake

        }
        else if(imageAdapter.mThumbIds[position] == 2131165286){ // Calories Burned

        }
        else if(imageAdapter.mThumbIds[position] == 2131165335){ // Warm-up Exercise

        }
        else if(imageAdapter.mThumbIds[position] == 2131165333) { // User Statistics

        }
        else{
            System.out.println(imageAdapter.mThumbIds[position]); // This is a built in debug statement to get the addresses in memory
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }

    }