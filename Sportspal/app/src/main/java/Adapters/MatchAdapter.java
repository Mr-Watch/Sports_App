package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class MatchAdapter extends FirestoreRecyclerAdapter<Matches, MatchAdapter.MatchHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MatchAdapter(@NonNull @NotNull FirestoreRecyclerOptions<Matches> options) {
        super(options);
    }

    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_recyclerview_item, parent, false);
        return new MatchHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchHolder holder, int position) {
        Matches currentMatch = matches.get(position);
        holder.textViewMatch_id.setText(currentMatch.getMatch_id());
        holder.textViewMatchdate.setText(currentMatch.getDate().toString());
        holder.textViewCountry.setText(currentMatch.getCountry());
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull MatchHolder holder, int position, @NonNull @NotNull Matches model) {
        holder.textViewMatch_id.setText(model.getMatch_id());
        holder.textViewMatchdate.setText(model.getDate().toString());
        holder.textViewCountry.setText(model.getCountry());
    }




    @Override
    public int getItemCount() {
        return matches.size();
    }

    public Matches getMatches(int position) {
        return matches.get(position);
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
        notifyDataSetChanged();
    }

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    class MatchHolder extends RecyclerView.ViewHolder  {
        private TextView textViewMatch_id;
        private TextView textViewMatchdate;
        private TextView textViewCountry;

        public MatchHolder (@NonNull View itemView) {
            super(itemView);
            textViewMatch_id = itemView.findViewById(R.id.match_id_recyclerView);
            textViewMatchdate = itemView.findViewById(R.id.match_date_recyclerView);
            textViewCountry = itemView.findViewById(R.id.match_country_recyclerView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }
}