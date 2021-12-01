package com.example.fitnessapplication402;
import android.content.Context;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView and TextView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;

        if (convertView == null) {

            //Create the image buttons on screen
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);


        /*
        //Create the text that goes below the image buttons

        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setText(activityNames[position]);
         */

        return imageView;
    }


    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.foot, R.drawable.road,
            R.drawable.water, R.drawable.flame,
            R.drawable.workout
    };

    /*
    public String[] activityNames = {
        "Steps", "Distance", "Water Intake", "Calories Burned", "Recommended", "About Me"
    };

     */
}