package com.example.SportShop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Pingpong extends AppCompatActivity {

    private GridView gridView;
    private GridAdapterping gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();
    private int[] imageResources = {
            R.drawable.balle_ittf,
            R.drawable.ballon_3etoile,
            R.drawable.filet_good,
            R.drawable.filet_simple,
            R.drawable.raquette_pro,
            R.drawable.raquette_simple,
            R.drawable.table_pro,
            R.drawable.table_simple
    };

    private DatabaseHelperPing dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingpong);

        gridView = findViewById(R.id.gridView);
        dbHelper = new DatabaseHelperPing(this);

        // Récupérer les descriptions d'images depuis la base de données
        for (int i = 1; i <= imageResources.length; i++) {
            String description = dbHelper.getImageDescription(i);
            imageDescriptions.add(description);
        }

        // Créer et configurer l'adaptateur de la grille
        gridAdapter = new GridAdapterping(this, imageDescriptions, imageResources);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // Rafraîchir votre GridView ici
            // Par exemple, si vous avez une méthode appelée refreshGridView(), vous pouvez l'appeler ici
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
