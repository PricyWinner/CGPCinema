package com.example.cgpcinema;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context mcontext;
    private OnNoteListener moNoteListener;
    public MovieAdapter(Context context, OnNoteListener onNoteListener) {
        mcontext = context;
        moNoteListener = onNoteListener;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.movie_card, parent, false);
        Log.wtf("data", MovieService.movies.size()+"inRV");
        return new MyViewHolder(view, moNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = MovieService.movies.get(position);
        Glide.with(mcontext).load(movie.imageURL).into(holder.image);
//        Drawable image = loadImageFromURL(movie.imageURL);
//        holder.image.setImageDrawable(image);
//        holder.title.setText(movie.title);
    }

    @Override
    public int getItemCount() {

        Log.wtf("data", MovieService.movies.size()+"inRV");
        return MovieService.movies.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        ImageView image;
        TextView title;
        OnNoteListener onNoteListener;
        public MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_movie);
//            title = itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

}
