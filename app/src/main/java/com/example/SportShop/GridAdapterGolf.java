package com.example.SportShop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class GridAdapterGolf extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageDescriptions;
    private int[] imageResources;

    public GridAdapterGolf(Context context, ArrayList<String> imageDescriptions, int[] imageResources) {
        this.context = context;
        this.imageDescriptions = imageDescriptions;
        this.imageResources = imageResources;
    }
    public void setImageDescriptions(ArrayList<String> imageDescriptions) {
        this.imageDescriptions = imageDescriptions;
    }
    @Override
    public int getCount() {
        return imageDescriptions.size();
    }

    @Override
    public Object getItem(int position) {
        return imageDescriptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_itemfoot, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView descriptionTextView = convertView.findViewById(R.id.textView);
        Button addToCartButton = convertView.findViewById(R.id.addToCartButton);

        String imageDescription = imageDescriptions.get(position);
        imageView.setImageResource(imageResources[position]);
        descriptionTextView.setText(imageDescription);

        // Définir un écouteur de clic sur l'image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir ImageDetailsActivity avec l'ID de l'image sélectionnée
                Intent intent = new Intent(context, ImageDetailsActivityGolf.class);
                intent.putExtra("imageId", position + 1); // L'ID de l'image commence à partir de 1
                context.startActivity(intent);
            }
        });

        // Définir un écouteur de clic sur le bouton "Ajouter au panier"
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afficher une alerte lorsque le bouton "Ajouter au panier" est cliqué
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Ce produit est ajouté au panier")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }
        });

        return convertView;
    }
}
