package com.example.fitnessapplication402;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fitnessapplication402.ActivityModel;

import java.util.ArrayList;

public class ActivityGVAdapter extends ArrayAdapter<ActivityModel> {
    public ActivityGVAdapter(@NonNull Context context, ArrayList<ActivityModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        ActivityModel courseModel = getItem(position);
        TextView activityTV = listitemView.findViewById(R.id.idTVActivity);
        ImageView activityIV = listitemView.findViewById(R.id.idIVActivity);
        activityTV.setText(courseModel.getCourse_name());
        activityIV.setImageResource(courseModel.getImgid());
        return listitemView;
    }
}
