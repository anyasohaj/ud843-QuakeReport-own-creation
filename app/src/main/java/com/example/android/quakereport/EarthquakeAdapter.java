package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Created by User on 2018.03.25..
 */

public class EarthquakeAdapter extends ArrayAdapter {


    public EarthquakeAdapter(@NonNull Activity context, ArrayList arrayList) {
        super(context, 0, arrayList);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);

        TextView magText = (TextView) convertView.findViewById(R.id.mag);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String mag = formatter.format(currentEarthquake.getMag());
        magText.setText(mag);

        GradientDrawable magnitudeCircle = (GradientDrawable) magText.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(mag);



        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String originalText = currentEarthquake.getLocation();
        String distance;
        String place;

        if (originalText.contains("of")){
            String[] splitted =  originalText.split("of");
            distance = splitted[0] + "of";
            place = splitted[1];
        }else{
            distance = "Near the";
            place = originalText;
        }

        TextView distanceText = (TextView) convertView.findViewById(R.id.distance);
        distanceText.setText(distance);
        TextView locText = (TextView) convertView.findViewById(R.id.location);
        locText.setText(place);


        TextView dateText = (TextView) convertView.findViewById(R.id.date);
        dateText.setText(currentEarthquake.getFormattedDate());

        TextView timeText = (TextView) convertView.findViewById(R.id.time);
        timeText.setText(currentEarthquake.getFormattedTime());

        return convertView;
    }



    public int getMagnitudeColor(String magnitude){
        int colorResource;
        String testLetter = magnitude.substring(0,2);
        switch (testLetter) {
            case "0.":
            case "1.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case "2.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case "3.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case "4.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case "5.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case "6.": colorResource = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case "7.": colorResource =ContextCompat.getColor(getContext(),  R.color.magnitude7);
                break;
            case "8.": colorResource =ContextCompat.getColor(getContext(),  R.color.magnitude8);
                break;
            case "9.": colorResource =ContextCompat.getColor(getContext(),  R.color.magnitude9);
                break;
            case "10":
            default: colorResource = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return colorResource;
    }
}