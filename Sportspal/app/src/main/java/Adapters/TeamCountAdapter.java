package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.example.sportspal.ui.Team.TeamCount;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TeamCountAdapter extends RecyclerView.Adapter<TeamCountAdapter.TeamCountHolder> {
    private List<TeamCount> items = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public TeamCountHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_query_2_recyclerview_item, parent, false);
        return new TeamCountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeamCountHolder holder, int position) {
        TeamCount currentItem = items.get(position);
        holder.textViewNumberOfTeams.setText(Integer.toString(currentItem.getNumberOfTeams()));
        holder.textViewSportName.setText(currentItem.getSportName());
        holder.textViewSportId.setText(Integer.toString(currentItem.getSportId()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<TeamCount> items){
        this.items = items;
        notifyDataSetChanged();
    }

    class TeamCountHolder extends RecyclerView.ViewHolder {
        private TextView textViewNumberOfTeams;
        private TextView textViewSportName;
        private TextView textViewSportId;

        public TeamCountHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewNumberOfTeams = itemView.findViewById(R.id.room_query_2_number_of_teams);
            textViewSportName = itemView.findViewById(R.id.room_query_2_sport_name);
            textViewSportId = itemView.findViewById(R.id.room_query_2_sport_id);
        }
    }
}
