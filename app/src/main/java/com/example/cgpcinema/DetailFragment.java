package com.example.cgpcinema;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cgpcinema.databinding.ActivityMainBinding;
import com.example.cgpcinema.databinding.FragmentDetailBinding;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    FragmentDetailBinding binding;
    private Movie movie;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Spinner list;
    private Spinner location;
    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentDetailBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();

        Bundle bundle = getArguments();
        if(bundle!= null){
            int position = bundle.getInt("position");
            movie = MovieService.movies.get(position);
//            Log.wtf("click",movie.title);


        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
        binding.tvTitle.setText(movie.title);
        Glide.with(getContext()).load(movie.imageURL).into(binding.ivPoster);
        binding.spinnerTime.setOnItemSelectedListener(this);
        binding.btnPurchase.setOnClickListener(this);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, time);
        list = binding.spinnerTime;
        location = binding.spinnerLocation;
        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        TransactionService.transactions.add(new Transaction(movie, location.getSelectedItem().toString(), list.getSelectedItem().toString(),new Date()));

        FragmentManager fragmentManager = getFragmentManager();
        Log.wtf("DD", location.getTransitionName());

        Context context = getContext();
        CharSequence text = "Ticket Purchased";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Log.wtf("purchase", "berhasil beli");
        fragmentManager.popBackStack();
    }
}