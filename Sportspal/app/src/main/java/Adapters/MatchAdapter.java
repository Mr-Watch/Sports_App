package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportspal.R;
import com.example.sportspal.ui.Firebase.Matches;
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
    protected void onBindViewHolder(@NonNull @NotNull MatchHolder holder, int position, @NonNull @NotNull Matches model) {
        holder.textViewMatch_id.setText(model.getMatch_id());
        holder.textViewMatchdate.setText(String.valueOf(model.getDate()));
        holder.textViewCountry.setText(model.getCountry());
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

        }

    }
}