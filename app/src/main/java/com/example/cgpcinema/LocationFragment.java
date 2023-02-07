package com.example.cgpcinema;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class LocationFragment extends Fragment{


    private GoogleMap mMap;
    private LatLng coord1, coord2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        coord1 = new LatLng(-6.193924061113853, 106.78813220277623);
        coord2 = new LatLng(-
                6.20175020412279, 106.78223868546155);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                LatLngBounds bounds = new LatLngBounds.Builder()
                        .include(coord1)
                        .include(coord2)
                        .build();
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 40));

                MarkerOptions markerOptions1 = new MarkerOptions();
                markerOptions1.position(coord1);
                MarkerOptions markerOptions2 = new MarkerOptions();

                markerOptions1.title("CGP Alpha");
                markerOptions2.position(coord2);
                markerOptions2.title("CGP Beta");

                Marker marker = mMap.addMarker(markerOptions1);
                Marker marker1 = mMap.addMarker(markerOptions2);
                marker.showInfoWindow();
                marker1.showInfoWindow();
            }
        });
        return view;
    }

}