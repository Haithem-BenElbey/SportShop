package com.example.SportShop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapterfoot extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageDescriptions;
    private int[] imageResources;

    public GridAdapterfoot(Context context, ArrayList<String> imageDescriptions, int[] imageResources) {
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
        TextView descreotion = convertView.findViewById(R.id.textView);
        String imageDescription = imageDescriptions.get(position);

        imageView.setImageResource(imageResources[position]);
        descreotion.setText(imageDescription);
        // Définir un écouteur de clic sur l'image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir ImageDetailsActivity avec l'ID de l'image sélectionnée
                Intent intent = new Intent(context, ImageDetailsActivityFoot.class);
                intent.putExtra("imageId", position + 1); // L'ID de l'image commence à partir de 1
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
