package de.dicegamesmix.dicegamesmix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] gameNames;
    String[] gameDescriptions;

    public ItemAdapter(Context c, String[] n, String[] d) {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //ACHTUNG!!! EIGENTLICH ARRAYS!!!   ?!?!?!
        gameNames = n;
        gameDescriptions = d;
    }

    @Override
    public int getCount() {
        return gameNames.length;
    }

    @Override
    public Object getItem(int i) {
        return gameNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.mainmenu_listview_layout, null);
        TextView name_TextView = (TextView) v.findViewById(R.id.name_TextView);
        TextView description_TextView = (TextView) v.findViewById(R.id.description_TextView);

        //writing the content of the variables in the text view
        name_TextView.setText(gameNames[i]);
        description_TextView.setText(gameDescriptions[i]);

        return v;
    }
}
