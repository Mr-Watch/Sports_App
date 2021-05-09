package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;

import java.util.ArrayList;
import java.util.List;

import Database.Classes.Athlete;


public class AthleteAdapter extends RecyclerView.Adapter<AthleteAdapter.AthleteHolder> {
    final private AthleteAdapter.ListItemClickListener mOnClickListener;
    private List<Athlete> athletes = new ArrayList<>();

    public AthleteAdapter(AthleteAdapter.ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
}


    @NonNull
    @Override
    public AthleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.athlete_recyclerview_item, parent, false);
        return new AthleteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AthleteHolder holder, int position) {
        Athlete currentSport = athletes.get(position);
        holder.textViewSportName.setText(currentSport.getAthleteFirstName());
        holder.textViewSportGender.setText(currentSport.getAthlete);
    }

    @Override
    public int getItemCount() {
        return athletes.size();
    }

    public Athlete getAthlete(int position) {
        return athletes.get(position);
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    class AthleteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewSportName;
        private TextView textViewSportGender;

        public AthleteHolder (@NonNull View itemView) {
            super(itemView);
            textViewSportName = itemView.findViewById(R.id.sport_name_recyclerView);
            textViewSportGender = itemView.findViewById(R.id.sport_gender_recyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}