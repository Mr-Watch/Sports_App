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
        Athlete currentAthlete = athletes.get(position);
        holder.textViewAthleteName.setText(currentAthlete.getAthleteFirstName());
        holder.textViewAthleteSurname.setText(currentAthlete.getAthleteSurname());
        holder.textViewCountry.setText(currentAthlete.getAthleteCountry());
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
        private TextView textViewAthleteName;
        private TextView textViewAthleteSurname;
        private TextView textViewCountry;

        public AthleteHolder (@NonNull View itemView) {
            super(itemView);
            textViewAthleteName = itemView.findViewById(R.id.athlete_firstname_recyclerView);
            textViewAthleteSurname = itemView.findViewById(R.id.athlete_surname_recyclerView);
            textViewCountry = itemView.findViewById(R.id.athlete_country_recyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}