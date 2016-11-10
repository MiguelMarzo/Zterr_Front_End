package org.zterr.frontend.android;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * extends a base adapter to create a customized ListAdapter
 *
 * @author Pello Xabier Altadill Izura
 * @greetz 4vientos students
 */
class CustomizedListAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Event> events;

    /**
     * Constructor
     *
     * @param activity
     * @param events
     */
    public CustomizedListAdapter(Activity activity, ArrayList<Event> events) {
        super();
        this.activity = activity;
        this.events = events;
    }


    /**
     * return number of items
     *
     * @return int
     */
    public int getCount() {
        // TODO Auto-generated method stub
        return events.size();
    }

    /**
     * returns one object in a given position
     *
     * @param position
     * @return Object
     */
    public Object getItem(int position) {
        return events.get(position);
    }

    /**
     * returns id for the custom_list_item(position)
     */
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * for each list custom_list_item it call this method to render it in the ListView
     *
     * @param position
     * @param convertView
     * @param parent
     * @result View
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        int icons[] = {android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_dialog_email};
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.main_list_item, null);
        }

        Event event = events.get(position);
        Log.d("PELLODEBUG", event.toString());

        //ImageView imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIcon);
        //imageViewIcon.setImageResource(icons[event.getId()]);

        TextView textViewTitle = (TextView) view.findViewById(R.id.textViewName);
        textViewTitle.setText(event.getName());

        TextView textViewText = (TextView) view.findViewById(R.id.textViewDescription);
        textViewText.setText(event.getDescription());


        return view;


    }


}