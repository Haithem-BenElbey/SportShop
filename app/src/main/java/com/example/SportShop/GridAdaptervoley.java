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

public class GridAdaptervoley extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageDescriptions;
    private int[] imageResources;

    public GridAdaptervoley(Context context, ArrayList<String> imageDescriptions, int[] imageResources) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = inflater.inflate(R.layout.grid_itemvoley, null);
        } else {
            gridView = convertView;
        }

        ImageView imageView = gridView.findViewById(R.id.imageView);
        TextView textView = gridView.findViewById(R.id.textView);

        imageView.setImageResource(imageResources[position]);
        textView.setText(imageDescriptions.get(position));

        // Définir un écouteur de clic sur l'image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir ImageDetailsActivityBasket avec l'ID de l'image sélectionnée
                Intent intent = new Intent(context, ImageDetailsActivityVoley.class);
                intent.putExtra("imageId", position + 1); // L'ID de l'image commence à partir de 1
                context.startActivity(intent);
            }
        });

        return gridView;
    }
}
