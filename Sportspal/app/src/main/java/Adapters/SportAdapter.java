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

import Database.Classes.Sport;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportHolder> {
    final private ListItemClickListener mOnClickListener;
    private List<Sport> sports = new ArrayList<>();

    public SportAdapter(ListItemClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public SportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sport_recyclerview_item, parent, false);
        return new SportHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportHolder holder, int position) {
        Sport currentSport = sports.get(position);
        holder.textViewSportName.setText(currentSport.getSportName());
        holder.textViewSportGender.setText(currentSport.getSportGender());
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public Sport getSport(int position) {
        return sports.get(position);
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    class SportHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewSportName;
        private TextView textViewSportGender;

        public SportHolder(@NonNull View itemView) {
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