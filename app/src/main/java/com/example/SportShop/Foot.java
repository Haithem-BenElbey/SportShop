package com.example.SportShop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Foot extends AppCompatActivity {

    private GridView gridView;
    private GridAdapterfoot gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();
    private int[] imageResources = {
            R.drawable.ballon,
            R.drawable.gant,
            R.drawable.protege,
            R.drawable.cr7,
            R.drawable.messi,
            R.drawable.rouge,
            R.drawable.cage,
            R.drawable.boudir
    };

    private DatabaseHelperFoot dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);

        gridView = findViewById(R.id.gridView);
        dbHelper = new DatabaseHelperFoot(this);

        // Récupérer les descriptions d'images depuis la base de données
        for (int i = 1; i <= imageResources.length; i++) {
            String description = dbHelper.getImageDescription(i);
            imageDescriptions.add(description);
        }



        // Créer et configurer l'adaptateur de la grille
        gridAdapter = new GridAdapterfoot(this, imageDescriptions, imageResources);
        gridView.setAdapter(gridAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK) {
            // Refresh your GridView here
            // For example, if you have a method called refreshGridView(), you can call it here
            // Récupérer les descriptions d'images depuis la base de données
            imageDescriptions = new ArrayList<>();
            for (int i = 1; i <= imageResources.length; i++) {
                String description = dbHelper.getImageDescription(i);
                imageDescriptions.add(description);
            }
            gridAdapter.setImageDescriptions(imageDescriptions);
            gridAdapter.notifyDataSetChanged();
        }
    }










}
