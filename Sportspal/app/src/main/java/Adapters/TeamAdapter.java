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

import Database.Classes.Team;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {
    final private ListItemClickListener mOnClickListener;
    private List<Team> sports = new ArrayList<>();

    public TeamAdapter(ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sport_recyclerview_item, parent, false);
        return new TeamHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
        Team currentTeam = sports.get(position);
        holder.textViewTeamName.setText(currentTeam.getTeamName());
        holder.textViewTeamGender.setText(currentTeam.getTeamFieldName()); //getTeamFieldName() needs to change to correct value
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public Team getTeam(int position) {
        return sports.get(position);
    }

    public void setTeams(List<Team> sports) {
        this.sports = sports;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewTeamName;
        private TextView textViewTeamGender;

        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeamName = itemView.findViewById(R.id.sport_name_recyclerView);
            textViewTeamGender = itemView.findViewById(R.id.sport_gender_recyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}