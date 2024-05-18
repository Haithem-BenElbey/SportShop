package com.example.SportShop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class acceuil extends Fragment {


    private ArrayList<Produit> produitsDansPanier; // Liste des produits dans le panier
    private PanierAdapter panierAdapter;

    public acceuil() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acceuil, container, false);



        return view;
    }
}

