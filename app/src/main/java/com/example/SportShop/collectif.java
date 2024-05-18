package com.example.SportShop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class collectif extends Fragment {

    private GridView gridView;
    private GridAdapter1 gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();

    private int[] imageResources = {
            R.drawable.foot,
            R.drawable.basketball,
            R.drawable.voleyball,
            R.drawable.handball,

    };

    public collectif() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ne faites pas setContentView ici
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collectif, container, false);
        gridView = view.findViewById(R.id.gridView);

        // Ajouter les descriptions des images (vérifiez si imageDescriptions est initialisé)
        if (imageDescriptions != null) {
            imageDescriptions.add("Football");
            imageDescriptions.add("Basketball");
            imageDescriptions.add("Voleyball");
            imageDescriptions.add("handBall");

        }

        // Initialiser l'adaptateur et le configurer
        gridAdapter = new GridAdapter1(getContext(), imageDescriptions, imageResources);
        gridView.setAdapter(gridAdapter);

        return view;
    }
}
