package com.example.gadsleaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.ui.main.GADSDevelopersIqSkillsModel;

import java.util.ArrayList;

public class GADSDeveloperIqSkillsDataAdapter extends RecyclerView.Adapter<GADSDeveloperIqSkillsDataAdapter.ViewHolder> {
    private ArrayList<GADSDevelopersIqSkillsModel> gadsDevelopersArrayListSkills;

    public GADSDeveloperIqSkillsDataAdapter(ArrayList<GADSDevelopersIqSkillsModel> gadsDevelopersArrayListSkills) {
        this.gadsDevelopersArrayListSkills = gadsDevelopersArrayListSkills;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_gads_skills, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv_name.setText(gadsDevelopersArrayListSkills.get(position).getName());
            holder.tv_score.setText(gadsDevelopersArrayListSkills.get(position).getScore());
            holder.tv_country.setText(gadsDevelopersArrayListSkills.get(position).getCountry());

            }

    @Override
    public int getItemCount() {
        return gadsDevelopersArrayListSkills.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_score,tv_country;
        public ViewHolder(View itemView) {
            super(itemView);
            //Card View
            tv_name = (TextView) itemView.findViewById(R.id.text_name_s);
            tv_score = (TextView)itemView.findViewById(R.id.text_score_s);
            tv_country = (TextView)itemView.findViewById(R.id.text_country_s);
        }
    }
}
