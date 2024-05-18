package com.example.SportShop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PanierAdapter extends ArrayAdapter<Produit> {

    private Context mContext;
    private List<Produit> mListProduits;

    public PanierAdapter(Context context, List<Produit> listProduits) {
        super(context, 0);
        mContext = context;
        mListProduits = listProduits;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_produit, parent, false);
        }

        Produit produit = mListProduits.get(position);

        // Initialisation des vues dans l'item du panier
        TextView textViewNomProduit = listItem.findViewById(R.id.textViewNomProduit);
        TextView textViewPrixProduit = listItem.findViewById(R.id.textViewPrixProduit);

        // Assignation des valeurs du produit aux vues correspondantes
        textViewNomProduit.setText(produit.getNom());
        textViewPrixProduit.setText(String.valueOf(produit.getPrix()));

        return listItem;
    }
}

