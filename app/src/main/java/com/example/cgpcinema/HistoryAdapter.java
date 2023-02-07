package com.example.cgpcinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    Context mcontext;

    public HistoryAdapter(Context context){
        mcontext = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.history_card, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Transaction transaction = TransactionService.transactions.get(TransactionService.transactions.size()-position-1);
        Glide.with(mcontext).load(transaction.movie.imageURL).into(holder.image);
        holder.title.setText(transaction.movie.title);
        holder.time.setText("Time: " + transaction.time);
        holder.location.setText(transaction.location);
        holder.date.setText(transaction.transactionDate.toString());
    }

    @Override
    public int getItemCount() {
        return TransactionService.transactions.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, date, time, location;
        public HistoryViewHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.iv_movie_history);
            title = itemView.findViewById(R.id.title_history);
            date = itemView.findViewById(R.id.date_history);
            location = itemView.findViewById(R.id.location_history);
            time = itemView.findViewById(R.id.time_movie);
        }
    }
}
