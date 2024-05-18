package com.example.SportShop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class golf extends AppCompatActivity {

    private GridView gridView;
    private GridAdapterGolf gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();
    private int[] imageResources = {
            R.drawable.chaussgolf,
            R.drawable.club,
            R.drawable.ensembliste,
            R.drawable.gantgolf,
            R.drawable.kora,
            R.drawable.sac,
            R.drawable.accces,
            R.drawable.tal3a
    };

    private DatabaseHelperGolf dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);

        gridView = findViewById(R.id.gridView);
        dbHelper = new DatabaseHelperGolf(this);

        // Récupérer les descriptions d'images depuis la base de données
        for (int i = 1; i <= imageResources.length; i++) {
            String description = dbHelper.getImageDescription(i);
            imageDescriptions.add(description);
        }

        // Créer et configurer l'adaptateur de la grille
        gridAdapter = new GridAdapterGolf(this, imageDescriptions, imageResources);
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
