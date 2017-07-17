package com.blueicon.deleteitemrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.util.List;

/**
 * Created by developer on 17/07/17.
 */

public class AdapterListView extends BaseSwipeAdapter {

    private List<Persona> personaList;
    private Context context;

    public AdapterListView(List<Persona> personaList, Context context) {
        this.personaList = personaList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return personaList.size();
    }

    @Override
    public Object getItem(int position) {

        return personaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup viewGroup) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup,false);
        SwipeLayout swipeLayout = (SwipeLayout)view.findViewById(getSwipeLayoutResourceId(position));
        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                //YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
        swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(context, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    @Override
    public void fillValues(int position, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.txt);
        t.setText(personaList.get(position).getNombre()+" "+personaList.get(position).getApellido());

    }
}
