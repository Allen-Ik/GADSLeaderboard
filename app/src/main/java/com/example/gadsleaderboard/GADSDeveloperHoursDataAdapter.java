package com.example.gadsleaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.ui.main.GADSDevelopersHoursModel;

import java.util.ArrayList;

public class GADSDeveloperHoursDataAdapter extends RecyclerView.Adapter<GADSDeveloperHoursDataAdapter.ViewHolder> {
    private ArrayList<GADSDevelopersHoursModel> gadsDevelopersArrayListHours;

    public GADSDeveloperHoursDataAdapter(ArrayList<GADSDevelopersHoursModel> gadsDevelopersArrayListHours) {
        this.gadsDevelopersArrayListHours = gadsDevelopersArrayListHours;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_gads_hours, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv_name.setText(gadsDevelopersArrayListHours.get(position).getName());
            holder.tv_hours.setText(gadsDevelopersArrayListHours.get(position).getHours());
            holder.tv_country.setText(gadsDevelopersArrayListHours.get(position).getCountry());

            }

    @Override
    public int getItemCount() {
        return gadsDevelopersArrayListHours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_hours,tv_country;
        public ViewHolder(View itemView) {
            super(itemView);
            //Card View
            tv_name = (TextView) itemView.findViewById(R.id.text_name);
            tv_hours = (TextView)itemView.findViewById(R.id.text_hours);
            tv_country = (TextView)itemView.findViewById(R.id.text_country);
        }
    }
}
