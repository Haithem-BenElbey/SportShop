package com.example.SportShop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageDescriptions;
    private int[] imageResources;

    public GridAdapter2(Context context, ArrayList<String> imageDescriptions, int[] imageResources) {
        this.context = context;
        this.imageDescriptions = imageDescriptions;
        this.imageResources = imageResources;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = inflater.inflate(R.layout.grid_item2, null);
            ImageView imageView = gridView.findViewById(R.id.imageView);
            imageView.setImageResource(imageResources[position]);
            TextView textView = gridView.findViewById(R.id.textView);
            textView.setText(imageDescriptions.get(position));

            // Obtenez une référence au bouton d'action en fonction de son ID
            Button actionButton = gridView.findViewById(R.id.actionButton);

            // Décidez du texte et de l'action associés à chaque bouton en fonction de la position
            switch (position) {
                case 0:
                    actionButton.setText("Ping Pong");
                    actionButton.setOnClickListener(v -> startFootActivity());
                    break;
                case 1:
                    actionButton.setText("Tennis");
                    actionButton.setOnClickListener(v -> startBasketActivity());
                    break;
                case 2:
                    actionButton.setText("Golf");
                    actionButton.setOnClickListener(v -> startVoleyActivity());
                    break;
                case 3:
                    actionButton.setText("Boxe");
                    actionButton.setOnClickListener(v -> startHandActivity());
                    break;
                // Ajoutez plus de cas selon vos besoins
                default:
                    actionButton.setText("Action par défaut");
                    actionButton.setOnClickListener(v -> startDefaultActivity());
                    break;
            }
        } else {
            gridView = convertView;
        }
        return gridView;
    }

    // Méthodes pour démarrer les activités correspondantes à chaque sport
    private void startFootActivity() {
        // Ajoutez le code pour démarrer l'activité Foot
        Intent intent = new Intent(context, Pingpong.class);
        context.startActivity(intent);
    }

    private void startBasketActivity() {
        // Ajoutez le code pour démarrer l'activité Basket
        Intent intent = new Intent(context, tennis.class);
        context.startActivity(intent);
    }

    private void startVoleyActivity() {
        // Ajoutez le code pour démarrer l'activité Voley
        Intent intent = new Intent(context, golf.class);
        context.startActivity(intent);
    }

    private void startHandActivity() {
        // Ajoutez le code pour démarrer l'activité Hand
        Intent intent = new Intent(context, boxe.class);
        context.startActivity(intent);
    }

    private void startDefaultActivity() {
        // Ajoutez le code pour démarrer une activité par défaut ou afficher un message d'erreur
        // Cela peut être utile si la position n'a pas été gérée correctement
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Activité par défaut")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
