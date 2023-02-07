package com.example.cgpcinema;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class MovieService {
    public static ArrayList<Movie> movies = new ArrayList<>();

//    public static void getMovies(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                movies = getMovies2();
////                Log.wtf("data", movies.get(1).toString());
//            }
//        }).start();
//
//    }
    Thread thread = new Thread();
    public static void getMovies(final Callback callback) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            movies = retrieveMovies();
//            Log.wtf("data", movies.toString());
            if (callback != null) {
                callback.onResult(movies);
            }
        }
    }).start();
}
//    public static void getMovies() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ArrayList<Movie> movies = retrieveMovies();
//                Log.wtf("data", movies.toString());
//            }
//        }).start();
//    }
    private static ArrayList<Movie> retrieveMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        final String URL = "https://imdb-api.com/en/API/Top250Movies/k_aqrdsaz8";
        try{
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int resCode = connection.getResponseCode();
            if (resCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                    System.out.println(line);
                }
                bufferedReader.close();
                JSONObject json = new JSONObject(response.toString());
                JSONArray data = json.getJSONArray("items");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject movieObject = data.getJSONObject(i);
                    Movie movie = new Movie();
                    movie.setId(movieObject.getString("id"));
                    movie.setImageURL(movieObject.getString("image"));
                    movie.setYear(movieObject.getString("year"));
                    movie.setTitle(movieObject.getString("fullTitle"));
                    movie.setRating(movieObject.getString("imDbRating"));
                    movies.add(movie);

                }
                Log.wtf("datar", "afterADD"+ movies.size());
                return movies;

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
public interface Callback {
    void onResult(ArrayList<Movie> movies);
  }

}
