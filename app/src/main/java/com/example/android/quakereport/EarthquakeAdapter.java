package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */
    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information bout the earthquake at a given position
     * in the list item of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if there is an existing ist item view (called convertView) that we can reuse
        View listItemView = convertView;

        // Otherwise, if convertView is null, then inflate a new list item layout
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        /**********************************************************************************/

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        /**********************************************************************************/

        // Find the TextView with view ID magnitude_text_view
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);

        // Set the proper background color n the magnitude circle.
        // Fetch the background from the TextView, which is GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        //Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Display the magnitude of the current earthquake in that TextView
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));

        /**********************************************************************************/

        String location = currentEarthquake.getLocation().toLowerCase();

        String[] split = new String[2];

        if (location.contains(LOCATION_SEPARATOR)) {
            split = location.split("(?<=" + LOCATION_SEPARATOR + ")");
        } else {
            split[0] = getContext().getString(R.string.near_the);
            split[1] = location;
        }

        String locationOffset = split[0];
        String primaryLocation = split[1];

        // Find the TextView with view ID direction_text_view
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);

        // Display the location offset of the current earthquake in that TextView
        locationOffsetTextView.setText(locationOffset);

        // Find the TextView with view ID place_text_view
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);

        // Display the primary location of the current earthquake in that TextView
        primaryLocationTextView.setText(primaryLocation);

        /**********************************************************************************/

        // Find the TextView with view ID date_text_view
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);

        // Display the date of the current earthquake in that TextView
        dateTextView.setText(currentEarthquake.getDate());

        // Find the TextView with view ID time_text_view
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);

        // Display the time of the current earthquake in that TextView
        timeTextView.setText(currentEarthquake.getTime());

        /**********************************************************************************/


        // Return the list item that is now showing the appropriate data
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        switch ((int) Math.floor(magnitude)) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }
}
