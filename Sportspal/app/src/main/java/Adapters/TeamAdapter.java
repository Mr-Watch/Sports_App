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
    private List<Team> teams = new ArrayList<>();

    public TeamAdapter(ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_recyclerview_item, parent, false);
        return new TeamHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
        Team currentTeam = teams.get(position);
        holder.textViewTeamName.setText(currentTeam.getTeamName());
        holder.textViewTeamCity.setText(currentTeam.getTeamCity());
        holder.textViewTeamCountry.setText(currentTeam.getTeamCountry());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public Team getTeam(int position) {
        return teams.get(position);
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewTeamName;
        private TextView textViewTeamCity;
        private TextView textViewTeamCountry;

        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeamName = itemView.findViewById(R.id.team_name_recyclerView);
            textViewTeamCity = itemView.findViewById(R.id.team_city_recyclerView);
            textViewTeamCountry = itemView.findViewById(R.id.team_country_recyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}