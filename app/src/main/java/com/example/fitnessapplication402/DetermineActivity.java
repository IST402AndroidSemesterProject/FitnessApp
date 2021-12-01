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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.Random;



public class DetermineActivity extends Activity implements SensorEventListener, StepListener{
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    private TextView TvSteps;
    private Button BtnStart;
    private Button BtnStop;
    private WaterCount count;
    private CalcDistance dist;
    private CalcCalories cal;
    private TextView countView;
    private TextView distanceView;
    private TextView calorieView;
    private ImageView warmupImage;
    private TextView warmupTitle;
    private TextView warmupInstructions;


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        numSteps = savedInstanceState.getInt("savedSteps");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        if(imageAdapter.mThumbIds[position] == 2131230824){ // Opens Step Counter
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

                    //numSteps = 0;
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
        else if(imageAdapter.mThumbIds[position] == 2131230872){ // Opens Distance
            setContentView(R.layout.distance_walked);
            dist = new CalcDistance();
            distanceView = (TextView)findViewById(R.id.Distance);
            dist.CalcTotalDistance(numSteps);
            distanceView.setText(String.valueOf(dist.getTotalDistance()));
        }
        else if(imageAdapter.mThumbIds[position] == 2131230878){ // Water Intake
            setContentView(R.layout.water_counter);
            count = new WaterCount();
            countView = (TextView)findViewById(R.id.WaterCounter);
        }
        else if(imageAdapter.mThumbIds[position] == 2131230823){ // Calories Burned
            setContentView(R.layout.calories_burned);
            cal = new CalcCalories();
            calorieView = (TextView)findViewById(R.id.CalorieBurned);
            cal.CalcTotalBurned(numSteps);
            calorieView.setText(String.valueOf(cal.getTotalBurned()));
        }
        else if(imageAdapter.mThumbIds[position] == 2131230879){ // Warm-up Exercise
            int min = 1;
            int max = 8;
            setContentView(R.layout.warmup_randomizer);

            warmupImage = (ImageView)findViewById(R.id.warmupImage);
            warmupTitle = (TextView)findViewById(R.id.warmupTitle);
            warmupInstructions = (TextView)findViewById(R.id.warmupInstructions);

            int random_exercise = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (random_exercise == 1) {
                warmupImage.setImageResource(R.drawable.calf);
                warmupTitle.setText(getString(R.string.warmupCalf));
                warmupInstructions.setText(getString(R.string.warmupCalfText));//set exercise image and instructions and remember to add default case
            }
            else if(random_exercise == 2) {
                warmupImage.setImageResource(R.drawable.ham);
                warmupTitle.setText(getString(R.string.warmupHamstring));
                warmupInstructions.setText(getString(R.string.warmupHamstringText));
            }
            else if(random_exercise == 3) {
                warmupImage.setImageResource(R.drawable.quads);
                warmupTitle.setText(getString(R.string.warmupQuads));
                warmupInstructions.setText(getString(R.string.warmupQuadsText));
            }
            else if(random_exercise == 4) {
                warmupImage.setImageResource(R.drawable.hip);
                warmupTitle.setText(getString(R.string.warmupHipFlex));
                warmupInstructions.setText(getString(R.string.warmupHipFlexText));
            }
            else if(random_exercise == 5) {
                warmupImage.setImageResource(R.drawable.iliotibial);
                warmupTitle.setText(getString(R.string.warmupIliotibial));
                warmupInstructions.setText(getString(R.string.warmupIliotibialText));
            }
            else if(random_exercise == 6) {
                warmupImage.setImageResource(R.drawable.kneetochest);
                warmupTitle.setText(getString(R.string.warmupKneeToChest));
                warmupInstructions.setText(getString(R.string.warmupKneeToChestText));
            }
            else if(random_exercise == 7) {
                warmupImage.setImageResource(R.drawable.shoulderstretch);
                warmupTitle.setText(getString(R.string.warmupShouldler));
                warmupInstructions.setText(getString(R.string.warmupShoudlerText));
            }
            else if(random_exercise == 8) {
                warmupImage.setImageResource(R.drawable.neck);
                warmupTitle.setText(getString(R.string.warmupNeck));
                warmupInstructions.setText(getString(R.string.warmupNeckText));
            }

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
    //This adds water to the counter
    public void CountTap(View view){
        count.addCount();
        countView.setText(count.getCount().toString());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("savedSteps", numSteps);
    }

    }